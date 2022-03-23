package com.example.trabajoequiposfinal.presenter.mostrarequipo;

import android.content.Context;

import com.example.trabajoequiposfinal.interactor.mostrarequipo.VerEquiposInteractorImpl;
import com.example.trabajoequiposfinal.interactor.recyclerView.RegistroEquiposDatos;
import com.example.trabajoequiposfinal.interfaces.mostrarequipo.VerEquipoInteractor;
import com.example.trabajoequiposfinal.interfaces.mostrarequipo.VerEquipoPresenter;
import com.example.trabajoequiposfinal.interfaces.mostrarequipo.VerEquipoView;

import java.util.ArrayList;

public class VerEquipoPresenterImpl implements VerEquipoPresenter {

    VerEquipoView vista;
    VerEquipoInteractor interactor;

    public VerEquipoPresenterImpl(VerEquipoView vista){
        this.interactor = new VerEquiposInteractorImpl();
        this.vista = vista;
    }

    @Override
    public void llenarRecycler(Context contexto) {
        interactor.llenarRecycler(this,contexto);
    }

    @Override
    public void exito(ArrayList<RegistroEquiposDatos> listaRegistros) {
        vista.exito(listaRegistros);
    }

    @Override
    public void error() {
        vista.error();
    }
}
