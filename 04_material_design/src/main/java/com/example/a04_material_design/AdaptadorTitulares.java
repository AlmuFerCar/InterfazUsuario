package com.example.a04_material_design;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorTitulares extends RecyclerView.Adapter<AdaptadorTitulares.TitularesViewHolder> {

    private ArrayList<Titular> datos;

    public AdaptadorTitulares(ArrayList<Titular> datos) {
        this.datos = datos;
    }

    public static class TitularesViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTitulo;
        private TextView txtSubtitulo;
        public TitularesViewHolder (View itemView){
            super (itemView);
            this.txtTitulo =itemView.findViewById(R.id.titulo);
            this.txtSubtitulo=itemView.findViewById(R.id.subtitulo);
        }

        public void bindTitular (Titular titular)
        {
            txtTitulo.setText(titular.getTitulo());
            txtSubtitulo.setText(titular.getSubtitulo());
        }
    }

    //Construye la vista
    @Override
    public TitularesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewTpe)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_component, viewGroup, false);
        TitularesViewHolder tvh =new TitularesViewHolder(itemView);
        return tvh;
    }

    //Asigna cada componente
    @Override
    public void onBindViewHolder(@NonNull TitularesViewHolder holder, int position) {
        Titular titular = datos.get(position);
        holder.bindTitular(titular);
    }

    //Devuelve el tamaño del array
    @Override
    public int getItemCount() {
        return datos.size();
    }
}
