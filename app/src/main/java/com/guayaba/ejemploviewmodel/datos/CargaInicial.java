package com.guayaba.ejemploviewmodel.datos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.guayaba.ejemploviewmodel.datos.ContratoDatos.VersionesAndroid;

public class CargaInicial {

    private SQLiteDatabase db;

    public CargaInicial(SQLiteDatabase db) {
        this.db = db;
    }

    void crearTablas() {
        String SQL_CREAR_TABLA_ANDROID = "CREATE TABLE IF NOT EXISTS " +
                VersionesAndroid.NOMBRE_TABLA + " (" +
                VersionesAndroid.COLUMNA_ID + " INTEGER PRIMARY KEY, " +
                VersionesAndroid.COLUMNA_NOMBRE + " TEXT, " +
                VersionesAndroid.COLUMNA_VERSION + " REAL," +
                VersionesAndroid.COLUMNA_API + " INTEGER)";
        db.execSQL(SQL_CREAR_TABLA_ANDROID);
    }
    void cargarDatos() {
        db.insert(VersionesAndroid.NOMBRE_TABLA,
                null,
                crearContentValues("Pie", 9.0, 28));
        db.insert(VersionesAndroid.NOMBRE_TABLA,
                null,
                crearContentValues("Oreo", 8.1, 27));
        db.insert(VersionesAndroid.NOMBRE_TABLA,
                null,
                crearContentValues("Nougat", 7.1, 25));
        db.insert(VersionesAndroid.NOMBRE_TABLA,
                null,
                crearContentValues("Marshmallow", 6.0, 23));
        db.insert(VersionesAndroid.NOMBRE_TABLA,
                null,
                crearContentValues("Lollipop", 5.1, 22));
        db.insert(VersionesAndroid.NOMBRE_TABLA,
                null,
                crearContentValues("KitKat", 4.4, 20));
        db.insert(VersionesAndroid.NOMBRE_TABLA,
                null,
                crearContentValues("Jelly Bean", 4.3, 18));
    }

    private ContentValues crearContentValues(String nombre, double version, int api) {
        ContentValues cv = new ContentValues();
        cv.put(VersionesAndroid.COLUMNA_NOMBRE, nombre);
        cv.put(VersionesAndroid.COLUMNA_VERSION, version);
        cv.put(VersionesAndroid.COLUMNA_API, api);
        return cv;
    }
}
