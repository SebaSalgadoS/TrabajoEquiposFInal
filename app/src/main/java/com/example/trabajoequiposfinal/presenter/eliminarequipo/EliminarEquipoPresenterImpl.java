package com.example.trabajoequiposfinal.presenter.eliminarequipo;

import android.content.Context;

import com.example.trabajoequiposfinal.interactor.eliminarequipo.EliminarEquipoInteractorImpl;
import com.example.trabajoequiposfinal.interfaces.eliminarequipo.EliminarEquipoInteractor;
import com.example.trabajoequiposfinal.interfaces.eliminarequipo.EliminarEquipoPresenter;
import com.example.trabajoequiposfinal.interfaces.eliminarequipo.EliminarEquipoView;

public class EliminarEquipoPresenterImpl implements EliminarEquipoPresenter {

    EliminarEquipoView vista;
    EliminarEquipoInteractor interactor;

    public EliminarEquipoPresenterImpl(EliminarEquipoView vista){
        this.vista = vista;
        interactor = new EliminarEquipoInteractorImpl();

    }

    @Override
    public void eliminarEquipo(String codigo, Context context) {
       interactor.eliminarEquipo(codigo,this, context);
    }

    @Override
    public void exitoEliminar() {
        vista.exitoEliminar();
    }

    @Override
    public void error() {
        vista.error();
    }

    @Override
    public void errorCodigo() {
        vista.errorCodigo();
    }
}
