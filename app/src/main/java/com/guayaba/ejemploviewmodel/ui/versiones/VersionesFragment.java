package com.guayaba.ejemploviewmodel.ui.versiones;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.guayaba.ejemploviewmodel.R;
import com.guayaba.ejemploviewmodel.comun.RecyclerViewAdapterBasico;
import com.guayaba.ejemploviewmodel.dto.Version;

import java.util.List;

public class VersionesFragment extends Fragment {

    public VersionesFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_versiones, container, false);

        // Se accede a la base de datos atravez deñ ViewModel
        VersionesModel versionesModel = new ViewModelProvider(this).get(VersionesModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.listado_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final RecyclerViewAdapterBasico adaptador = new RecyclerViewAdapterBasico();
        recyclerView.setAdapter(adaptador);

        // Se dispara la consulta de los datos y se define un manejador que actualiza la pantalla con ayuda del adaptador.
        versionesModel.getVersinoes().observe(getViewLifecycleOwner(), new Observer<List<Version>>() {
            @Override
            public void onChanged(List<Version> versiones) {
                adaptador.setListado(versiones);
            }
        });

        return view;
    }
}
