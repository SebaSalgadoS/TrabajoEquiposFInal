package com.example.trabajoequiposfinal.presenter.registroequipo;

import android.content.Context;

import com.example.trabajoequiposfinal.interactor.registroequipos.RegistroEquiposInteractorImpl;
import com.example.trabajoequiposfinal.interfaces.registroequipo.RegistroEquipoInteractor;
import com.example.trabajoequiposfinal.interfaces.registroequipo.RegistroEquipoPresenter;
import com.example.trabajoequiposfinal.view.fragmentos.FragRegistroEquipo;

public class RegistroEquipoPresenterImpl implements RegistroEquipoPresenter {

    FragRegistroEquipo vista;
    RegistroEquipoInteractor interactor;

    public RegistroEquipoPresenterImpl(FragRegistroEquipo vista){
        this.vista = vista;
        interactor = new RegistroEquiposInteractorImpl();
    }

    @Override
    public void registrarEquipo(String codigo, String marca, String modelo, String fecha, String equipo, String cargador, String manual,
                                String garantia, String equipoSo, String monitor, String audio, String touchpad, String observaciones, Context contexto) {
        interactor.registrarEquipo(codigo, marca, modelo, fecha, equipo, cargador, manual, garantia, equipoSo, monitor, audio, touchpad, observaciones,  this, contexto);
    }

    @Override
    public void errorEquipo() {

        vista.errorEquipo();
    }

    @Override
    public void exitoEquipo() {

        vista.exitoEquipo();
    }

    @Override
    public void setErrorCodigo() {

        vista.setErrorCodigo();
    }

    @Override
    public void setErrorMarca() {

        vista.setErrorMarca();
    }

    @Override
    public void setErrorModelo() {

        vista.setErrorModelo();
    }
}
