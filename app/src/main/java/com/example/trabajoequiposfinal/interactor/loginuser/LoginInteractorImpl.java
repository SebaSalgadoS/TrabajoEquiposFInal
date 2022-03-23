package com.example.trabajoequiposfinal.interactor.loginuser;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.trabajoequiposfinal.interactor.database.ConexionDB;
import com.example.trabajoequiposfinal.interfaces.loginuser.LoginInteractor;
import com.example.trabajoequiposfinal.interfaces.loginuser.LoginPresenter;

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void validarUsuario(String user, String pass, LoginPresenter presentador, Context contexto) {
        String nombre = "";
        if(user.equals("")){
            presentador.setErrorUser();
        }
        else if(pass.equals("")){
            presentador.setErrorPassword();
        }
        else{
            ConexionDB conexion = new ConexionDB(contexto, "administracion", null, 1);
            SQLiteDatabase bd = conexion.getWritableDatabase();

            Cursor fila = bd.rawQuery("SELECT nombre FROM usuarios WHERE user='"+user+"' and pass='"+pass+"'", null);

            if(fila.moveToFirst()){
                nombre = fila.getString(0);
                presentador.exito(nombre);
                bd.close();
            }
            else{
                presentador.noExiste();
                bd.close();
            }
        }

    }
}
