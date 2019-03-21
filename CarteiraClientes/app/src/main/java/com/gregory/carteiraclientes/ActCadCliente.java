package com.gregory.carteiraclientes;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gregory.carteiraclientes.database.DadosOpenHelper;
import com.gregory.carteiraclientes.dominio.entidades.Cliente;
import com.gregory.carteiraclientes.dominio.repositrorio.ClienteRepositorio;

import org.w3c.dom.Text;

public class ActCadCliente extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEndereco;
    private EditText edtTelefone;
    private EditText edtEmail;
    private ConstraintLayout layoutContentActCadCliente;
    private ClienteRepositorio clienteRepositorio;
    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;

    private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cad_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //maneira de pegar os elementos do layout
        edtNome = (EditText)findViewById(R.id.edtNome);
        edtEndereco = (EditText)findViewById(R.id.edtEndereco);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtTelefone = (EditText)findViewById(R.id.edtTelefone);

        layoutContentActCadCliente = (ConstraintLayout)findViewById(R.id.layoutContentActCadCliente);

        criaConexao();
    }

    private void criaConexao(){

        try {

            dadosOpenHelper = new DadosOpenHelper(this);
            conexao = dadosOpenHelper.getWritableDatabase();

            Snackbar.make(layoutContentActCadCliente, R.string.message_conexao_criada_com_sucesso, Snackbar.LENGTH_LONG ).setAction(R.string.acti_ok, null).show();

            clienteRepositorio = new ClienteRepositorio(conexao);

        }catch (SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.title_erro);
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton(R.string.acti_ok, null);
            dlg.show();

        }

    }


    private void confirmar(){

        cliente = new Cliente();

        if (validaCampos() == false){

            try{

            clienteRepositorio.inserir(cliente);

                finish();

            }catch (SQLException ex){

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle(R.string.title_erro);
                dlg.setMessage(ex.getMessage());
                dlg.setNeutralButton(R.string.acti_ok, null);
                dlg.show();

            }
        }

    }


    private boolean validaCampos(){

        boolean res = false;

        String nome = edtNome.getText().toString();
        String endereco = edtEndereco.getText().toString();
        String email = edtEmail.getText().toString();
        String telefone = edtTelefone.getText().toString();

        cliente.nome = nome;
        cliente.endereco = endereco;
        cliente.email = email;
        cliente.telefone = telefone;

        if (res = isCampoVazio(nome)){
            edtNome.requestFocus();
        }
        else if (res = isCampoVazio(endereco)){
            edtEndereco.requestFocus();
        }
        else if (res = !isEmailValido(email)){
            edtEmail.requestFocus();
        }
        else if (res = isCampoVazio(telefone)){
            edtTelefone.requestFocus();
        }

        //função para exibir a mensagem caso tenha algo invalido
        if (res){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.title_aviso);
            dlg.setMessage(R.string.message_campos_invalidos_brancos);
            dlg.setNeutralButton(R.string.acti_ok, null);
            dlg.show();
        }

        return res;
    }

    // função para validar se os campos estão vazios incluindo se só tem espaço com valor.trim
    private boolean isCampoVazio(String valor){

        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty() );

        return resultado;
    }
    //Função para validar o e-mail
    private boolean isEmailValido(String email){
        //Patterns já tem funções padroes de validações, como a de e-mail
        boolean resultado = (!isCampoVazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());

        return resultado;
    }
    /* Função para validar o telefone ***Verificar a forma correta***
    private boolean isTelefoneValido(String telefone){
        boolean resultado = (!isCampoVazio(telefone) && Patterns.PHONE.matcher(telefone).matches());

        return resultado;
    }*/


    //modo para colcar o menu que foi criado na activity Cadastro cliente
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_cad_cliente, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch(id){
            case R.id.action_ok:
                //metodo para exibir uma mensagem de teste quando o ok for selecionada
                //Toast.makeText(this, "Botaão ok Selecionado", Toast.LENGTH_SHORT ).show();

                //Validações dos campos do cadastro cliente e a inserção dos valor no banco
                confirmar();

            break;

            case R.id.action_cancelar:
                //metodo para exibir uma mensagem de teste quando o cancelar for selecionada
                //Toast.makeText(this, "Botaão cancelar Selecionado", Toast.LENGTH_SHORT ).show();

                //Finalizar a activity
                finish();
            break;
        }

        return super.onOptionsItemSelected(item);
    }
}
