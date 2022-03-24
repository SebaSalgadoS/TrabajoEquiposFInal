package com.example.trabajoequiposfinal.view.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajoequiposfinal.R;
import com.example.trabajoequiposfinal.interfaces.eliminarequipo.EliminarEquipoPresenter;
import com.example.trabajoequiposfinal.interfaces.eliminarequipo.EliminarEquipoView;
import com.example.trabajoequiposfinal.presenter.eliminarequipo.EliminarEquipoPresenterImpl;


public class FragEliminarEquipo extends Fragment implements EliminarEquipoView {

    Button btnEliminar;
    TextView txtCodigoEliminar;

    EliminarEquipoPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_frag_eliminar_equipo, container, false);

        btnEliminar = v.findViewById(R.id.btnEliminar);
        txtCodigoEliminar = v.findViewById(R.id.txtCodigoEliminar);

        presenter = new EliminarEquipoPresenterImpl(this);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarRegistro();
            }
        });
        return v;
    }

    private void comprobarRegistro() {
        presenter.eliminarEquipo(txtCodigoEliminar.getText().toString(),getContext());
    }



    @Override
    public void exitoEliminar() {
        Toast.makeText(getContext(), "REGISTRO ELIMINADO", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error() {
        Toast.makeText(getContext(), "ERROR: CODIGO NO EXISTE", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void errorCodigo() {
        Toast.makeText(getContext(), "INGRESE CODIGO", Toast.LENGTH_SHORT).show();
    }


}