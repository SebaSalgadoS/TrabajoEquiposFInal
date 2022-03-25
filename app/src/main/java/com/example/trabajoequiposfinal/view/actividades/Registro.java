package com.example.trabajoequiposfinal.view.actividades;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.trabajoequiposfinal.R;
import com.example.trabajoequiposfinal.interfaces.registrouser.RegistroPresenter;
import com.example.trabajoequiposfinal.interfaces.registrouser.RegistroView;
import com.example.trabajoequiposfinal.presenter.registrouser.RegistroPresenterImpl;

public class Registro extends AppCompatActivity implements RegistroView {


    EditText txtNombre, txtUser2, txtPass2;
    Button btnRegistrar;


    RegistroPresenter presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNombre = findViewById(R.id.txtNombre);
        txtUser2 = findViewById(R.id.txtUser2);
        txtPass2 = findViewById(R.id.txtPass2);
        btnRegistrar = findViewById(R.id.btnRegistrar);



        presentador = new RegistroPresenterImpl(this);
        //getSupportActionBar(myToolbarLogin);
    }






    public void registro(View view){
        presentador.registrar(txtNombre.getText().toString(),
                txtUser2.getText().toString(),
                txtPass2.getText().toString(), this);
    }

    @Override
    public void exito() {
        Toast.makeText(this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error() {
        Toast.makeText(this, "Error: No se pudo registrar", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setErrorNombre() {
        txtNombre.setError("Complete el campo");
    }

    @Override
    public void setErrorUser() {
        txtUser2.setError("Complete el campo");
    }

    @Override
    public void setErrorPassword() {
        txtPass2.setError("Complete el campo");
    }


}