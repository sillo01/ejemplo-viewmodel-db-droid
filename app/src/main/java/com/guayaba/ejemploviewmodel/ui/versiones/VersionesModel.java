package com.guayaba.ejemploviewmodel.ui.versiones;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.guayaba.ejemploviewmodel.datos.MyDbHelper;
import com.guayaba.ejemploviewmodel.datos.VersionDao;
import com.guayaba.ejemploviewmodel.dto.Version;

import java.util.List;

public class VersionesModel extends AndroidViewModel {

    private MutableLiveData<List<Version>> versiones;
    private MyDbHelper dbHelper;

    public VersionesModel(@NonNull Application application) {
        super(application);
        dbHelper = new MyDbHelper(application.getApplicationContext());
    }

    public LiveData<List<Version>> getVersinoes() {
        if (versiones == null) {
            versiones = new MutableLiveData<>();
            cargarDatosVersiones();
        }
        return versiones;
    }

    // El código del ViewModel se ejecuta en segundo plano. Podemos correr tareas pesadas aquí.
    private void cargarDatosVersiones() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        VersionDao dao = new VersionDao(db);
        versiones.setValue(dao.traerTodasLasVersines());
        db.close();
    }
}
