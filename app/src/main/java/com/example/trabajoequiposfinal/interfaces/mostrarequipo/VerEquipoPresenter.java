package com.example.trabajoequiposfinal.interfaces.mostrarequipo;

import android.content.Context;

import com.example.trabajoequiposfinal.interactor.recyclerView.RegistroEquiposDatos;

import java.util.ArrayList;

public interface VerEquipoPresenter {

    void llenarRecycler(Context contexto);
    void exito(ArrayList<RegistroEquiposDatos> listaRegistros);
    void error();
}
