package com.guayaba.ejemploviewmodel.comun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guayaba.ejemploviewmodel.R;
import com.guayaba.ejemploviewmodel.dto.Version;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterBasico extends RecyclerView.Adapter<RecyclerViewAdapterBasico.ViewHolderBasico> {

    // Se puede usar un tipo genérico aquí
    private List<Version> listado;

    public RecyclerViewAdapterBasico() {
        // Se inicializa con sun conjunto vacío para evitar errores al componer la vista
        this.listado = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolderBasico onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.elemento_lista, parent, false);
        return new ViewHolderBasico(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBasico holder, int position) {
        final Version version = listado.get(position);
        holder.titulo.setText(version.getNombre());
        holder.subtitulo.setText("API " + version.getApi());
    }

    @Override
    public int getItemCount() {
        return listado.size();
    }

    // Éste adaptador permite actualizar el conjunto de datos.
    public void setListado(List<Version> listado) {
        this.listado = listado;
        notifyDataSetChanged();
    }

    static class ViewHolderBasico extends RecyclerView.ViewHolder {
        TextView titulo, subtitulo;

        public ViewHolderBasico(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            subtitulo = itemView.findViewById(R.id.subtitulo);
        }
    }
}
