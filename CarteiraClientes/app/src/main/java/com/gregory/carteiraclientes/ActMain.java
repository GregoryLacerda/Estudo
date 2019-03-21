package com.gregory.carteiraclientes;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gregory.carteiraclientes.database.DadosOpenHelper;
import com.gregory.carteiraclientes.dominio.entidades.Cliente;
import com.gregory.carteiraclientes.dominio.repositrorio.ClienteRepositorio;

import java.util.List;

public class ActMain extends AppCompatActivity {

    private RecyclerView lstDados;
    private FloatingActionButton fab;
    private ConstraintLayout layoutContentMain;
    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;
    private ClienteAdapter clienteAdapter;
    private ClienteRepositorio clienteRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        lstDados = (RecyclerView)findViewById(R.id.lstDados);
        layoutContentMain = (ConstraintLayout)findViewById(R.id.layoutContentMain);

        criaConexao();

        lstDados.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lstDados.setLayoutManager(linearLayoutManager);

        clienteRepositorio = new ClienteRepositorio(conexao);

        List<Cliente> dado = clienteRepositorio.buscarTodos();

        clienteAdapter = new ClienteAdapter(dado);

        lstDados.setAdapter(clienteAdapter);


        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ao clicar no botão, esse codigo faz com que chame a outra activity(ActCadCliente)
                Intent it = new Intent(ActMain.this, ActCadCliente.class);
                startActivity(it);
            }
        });*/
    }

    private void criaConexao(){

        try {

            dadosOpenHelper = new DadosOpenHelper(this);
            conexao = dadosOpenHelper.getWritableDatabase();

            Snackbar.make(layoutContentMain, R.string.message_conexao_criada_com_sucesso, Snackbar.LENGTH_LONG ).setAction(R.string.acti_ok, null).show();
        }catch (SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.title_erro);
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton(R.string.acti_ok, null);
            dlg.show();

        }

    }

        //outra forma de chamar outra activity(ActCadCliente)
    public void cadastar(View view){
        Intent it = new Intent(ActMain.this, ActCadCliente.class);
        startActivity(it);
    }

}
