package com.example.trabajoequiposfinal.interactor.registroequipos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.trabajoequiposfinal.interactor.database.ConexionDB;
import com.example.trabajoequiposfinal.interfaces.registroequipo.RegistroEquipoInteractor;
import com.example.trabajoequiposfinal.interfaces.registroequipo.RegistroEquipoPresenter;

public class RegistroEquiposInteractorImpl implements RegistroEquipoInteractor {

    @Override
    public void registrarEquipo(String codigo, String marca, String modelo, String fecha, String equipo, String cargador, String manual,
                                String garantia, String equipoSo, String monitor, String audio, String touchpad, String observaciones, RegistroEquipoPresenter presenter, Context contexto) {

        if(codigo.equals("") ){
            presenter.setErrorCodigo();
        }
        else if(modelo.equals("")){
            presenter.setErrorModelo();
        }
        else if(marca.equals("")){
            presenter.setErrorMarca();
        }
        else {
            //registrar en SQLite
            ConexionDB conexion = new ConexionDB(contexto, "notebook", null, 1);
            SQLiteDatabase bd = conexion.getWritableDatabase();

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("marca", marca);
            registro.put("modelo", modelo);
            registro.put("fecha", fecha);
            registro.put("equipo", equipo);
            registro.put("cargador", cargador);
            registro.put("manual", manual);
            registro.put("garantia", garantia);
            registro.put("sistemaop", equipoSo);
            registro.put("monitor", monitor);
            registro.put("audio", audio);
            registro.put("touchpad", touchpad);
            registro.put("observaciones", observaciones);

            long x = bd.insert("equipos", null, registro);


            if (x > 0) {
                presenter.exitoEquipo();
            } else {
                presenter.errorEquipo();
            }
            bd.close();
            presenter.exitoEquipo();
        }
    }


}