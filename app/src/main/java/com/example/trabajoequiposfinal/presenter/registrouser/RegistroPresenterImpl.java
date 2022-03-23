package com.example.trabajoequiposfinal.presenter.registrouser;

import android.content.Context;

import com.example.trabajoequiposfinal.interactor.registrouser.RegistroInteractorImpl;
import com.example.trabajoequiposfinal.interfaces.registrouser.RegistroInteractor;
import com.example.trabajoequiposfinal.interfaces.registrouser.RegistroPresenter;
import com.example.trabajoequiposfinal.interfaces.registrouser.RegistroView;
import com.example.trabajoequiposfinal.view.fragmentos.FragRegistroEquipo;

public class RegistroPresenterImpl implements RegistroPresenter {

    RegistroView vista;
    RegistroInteractor interactor;

    public RegistroPresenterImpl(RegistroView vista) {
        this.vista = vista;
        interactor = new RegistroInteractorImpl();
    }


    @Override
    public void registrar(String nombre, String user, String pass, Context contexto) {
        interactor.registrar(nombre, user, pass, this, contexto);
    }

    @Override
    public void error() {
        vista.error();
    }

    @Override
    public void exito() {
        vista.exito();
    }

    @Override
    public void setErrorNombre() {
        vista.setErrorNombre();
    }

    @Override
    public void setErrorUser() {
        vista.setErrorUser();
    }

    @Override
    public void setErrorPassword() {
        vista.setErrorPassword();
    }
}