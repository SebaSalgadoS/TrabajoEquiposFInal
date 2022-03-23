package com.example.trabajoequiposfinal.interactor.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionDB extends SQLiteOpenHelper {
    public ConexionDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table usuarios(user text primary key, nombre text, pass text)");

        bd.execSQL("create table equipos(codigo text primary key, marca text" +
                "   , modelo text,fecha text, equipo text, cargador text, manual text, garantia text" +
                ",sistemaop text, monitor text, audio text, touchpad text, observaciones text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
