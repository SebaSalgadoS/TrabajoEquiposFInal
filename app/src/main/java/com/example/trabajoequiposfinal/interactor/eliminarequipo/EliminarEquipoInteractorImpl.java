package com.example.trabajoequiposfinal.interactor.eliminarequipo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.trabajoequiposfinal.interactor.database.ConexionDB;
import com.example.trabajoequiposfinal.interfaces.eliminarequipo.EliminarEquipoInteractor;
import com.example.trabajoequiposfinal.interfaces.eliminarequipo.EliminarEquipoPresenter;

public class EliminarEquipoInteractorImpl implements EliminarEquipoInteractor {




    @Override
    public void eliminarEquipo(String codigo, EliminarEquipoPresenter presenter, Context context) {

        if(codigo.equals("")){
            presenter.errorCodigo();
        }
        else{
            ConexionDB conexion = new ConexionDB(context,"notebook", null , 1);
            SQLiteDatabase bd = conexion.getWritableDatabase();

            int a = bd.delete("equipos","codigo='"+codigo+"'", null);

            if(a>0){
                presenter.exitoEliminar();
            }
            else{
                presenter.error();
            }
        }

    }
}
