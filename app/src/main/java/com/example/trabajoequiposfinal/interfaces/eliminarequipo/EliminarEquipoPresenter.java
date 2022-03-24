package com.example.trabajoequiposfinal.interfaces.eliminarequipo;

import android.content.Context;

public interface EliminarEquipoPresenter {

    void eliminarEquipo(String codigo, Context context);
    void exitoEliminar();
    void error();
    void errorCodigo();

}
