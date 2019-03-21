package com.gregory.carteiraclientes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gregory.carteiraclientes.dominio.entidades.Cliente;

import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolderCliente> {

    private List<Cliente> dados;

    public ClienteAdapter(List<Cliente> dados){

        this.dados = dados;

    }

    @NonNull
    @Override
    public ClienteAdapter.ViewHolderCliente onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.linha_clientes, parent, false);

        ViewHolderCliente holderCliente = new ViewHolderCliente(view);

        return holderCliente;
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteAdapter.ViewHolderCliente holder, int position) {

        if ((dados !=null ) && (dados.size() > 0)) {

            Cliente cliente = dados.get(position);

            holder.txtNome.setText(cliente.nome);
            holder.txtTelefone.setText(cliente.telefone);
        }
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHolderCliente extends RecyclerView.ViewHolder{

        public TextView txtNome;
        public TextView txtTelefone;

        public ViewHolderCliente(@NonNull View itemView) {

            super(itemView);

            txtNome = (TextView) itemView.findViewById(R.id.txtNome);
            txtTelefone = (TextView) itemView.findViewById(R.id.txtTelefone);
        }
    }
}
