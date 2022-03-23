package com.example.trabajoequiposfinal.interactor.registrouser;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.trabajoequiposfinal.interactor.database.ConexionDB;
import com.example.trabajoequiposfinal.interfaces.registrouser.RegistroInteractor;
import com.example.trabajoequiposfinal.interfaces.registrouser.RegistroPresenter;

public class RegistroInteractorImpl implements RegistroInteractor {

    @Override
    public void registrar(String nombre, String user, String pass, RegistroPresenter presenter, Context contexto) {

        if(nombre.equals("")){
            presenter.setErrorNombre();
        }
        else if(user.equals("")){
            presenter.setErrorUser();
        }
        else if(pass.equals("")){
            presenter.setErrorPassword();
        }
        else {
            //registrar en SQLite
            ConexionDB conexion = new ConexionDB(contexto, "administracion", null, 1);
            SQLiteDatabase bd = conexion.getWritableDatabase();

            ContentValues registro = new ContentValues();
            registro.put("user", user);
            registro.put("nombre", nombre);
            registro.put("pass", pass);

            long x = bd.insert("usuarios", null, registro);
            bd.close();

            if (x > 0) {
                presenter.exito();
            } else {
                presenter.error();
            }
        }
    }
}