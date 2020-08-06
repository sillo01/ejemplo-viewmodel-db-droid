package com.guayaba.ejemploviewmodel.datos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.guayaba.ejemploviewmodel.dto.Version;

import java.util.ArrayList;
import java.util.List;

public class VersionDao {

    private SQLiteDatabase db;

    public VersionDao(SQLiteDatabase db) {
        this.db = db;
    }

    public List<Version> traerTodasLasVersines() {
        String[] columnas = {
                ContratoDatos.VersionesAndroid.COLUMNA_ID,
                ContratoDatos.VersionesAndroid.COLUMNA_NOMBRE,
                ContratoDatos.VersionesAndroid.COLUMNA_VERSION,
                ContratoDatos.VersionesAndroid.COLUMNA_API
        };
        String orden = ContratoDatos.VersionesAndroid.COLUMNA_API + " ASC";

        Cursor c = db.query(ContratoDatos.VersionesAndroid.NOMBRE_TABLA,
                columnas,
                null,
                null,
                null,
                null,
                orden);

        List<Version> versiones = new ArrayList<>();
        while (c.moveToNext()) {
            versiones.add(new Version(
                    c.getInt(c.getColumnIndex(ContratoDatos.VersionesAndroid.COLUMNA_ID)),
                    c.getString(c.getColumnIndex(ContratoDatos.VersionesAndroid.COLUMNA_NOMBRE)),
                    c.getDouble(c.getColumnIndex(ContratoDatos.VersionesAndroid.COLUMNA_VERSION)),
                    c.getInt(c.getColumnIndex(ContratoDatos.VersionesAndroid.COLUMNA_API))
            ));
        }
        c.close();

        return versiones;
    }
}
