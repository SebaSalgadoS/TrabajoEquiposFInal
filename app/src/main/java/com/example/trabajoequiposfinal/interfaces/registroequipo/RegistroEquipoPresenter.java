package com.example.trabajoequiposfinal.interfaces.registroequipo;

import android.content.Context;

public interface RegistroEquipoPresenter {

    void registrarEquipo(String codigo, String marca, String modelo, String fecha, String equipo, String cargador, String manual,
                         String garantia, String equipoSo, String monitor, String audio, String touchpad, String observaciones, Context contexto);

    void errorEquipo();
    void exitoEquipo();
    void setErrorCodigo();
    void setErrorMarca();
    void setErrorModelo();
}
