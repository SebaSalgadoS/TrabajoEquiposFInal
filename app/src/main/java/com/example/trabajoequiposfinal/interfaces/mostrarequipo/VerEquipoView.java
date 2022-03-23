package com.example.trabajoequiposfinal.interfaces.mostrarequipo;

import com.example.trabajoequiposfinal.interactor.recyclerView.RegistroEquiposDatos;

import java.util.ArrayList;

public interface VerEquipoView {

    void exito(ArrayList<RegistroEquiposDatos>listaRegistros);
    void error();
}
