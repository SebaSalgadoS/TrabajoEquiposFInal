package com.example.trabajoequiposfinal.view.fragmentos;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajoequiposfinal.R;
import com.example.trabajoequiposfinal.interfaces.registroequipo.RegistroEquipoPresenter;
import com.example.trabajoequiposfinal.interfaces.registroequipo.RegistroEquipoView;
import com.example.trabajoequiposfinal.presenter.registroequipo.RegistroEquipoPresenterImpl;
import com.example.trabajoequiposfinal.view.actividades.OtraActividad;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class FragRegistroEquipo extends Fragment implements RegistroEquipoView {

    EditText txtCodigo, txtMarca, txtModelo, txtObservaciones;
    TextView txtFecha;

    RadioButton rdEquipo, rdNoEquipo, rdCargador, rdNoCargador, rdManual, rdNoManual, rdGarantia, rdNoGarantia, rdEquipoSo, rdNoEquipoSO;
    RadioButton rdMonitor, rdNoMonitor, rdAudio, rdNoAudio, rdTouchpad, rdNoTouchpad;

    RegistroEquipoPresenter presenter;

    String f = "";

    Button btnFoto1, btnFoto2, btnRegistrarEquipo;
    ImageView imgFoto1, imgFoto2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_frag_registro_equipo, container, false);

        txtCodigo = v.findViewById(R.id.txtCodigo);
        txtFecha = v.findViewById(R.id.txtFechaIngreso);
        txtModelo = v.findViewById(R.id.txtModelo);
        txtMarca = v.findViewById(R.id.txtMarca);
        txtObservaciones = v.findViewById(R.id.txtObservaciones);

        rdEquipo = v.findViewById(R.id.rdEquipoCaja);
        rdNoEquipo = v.findViewById(R.id.rdNoEquipoCaja);
        rdCargador = v.findViewById(R.id.rdCargadorCaja);
        rdNoCargador = v.findViewById(R.id.rdNoCargadorCaja);
        rdManual = v.findViewById(R.id.rdManualCaja);
        rdNoManual = v.findViewById(R.id.rdNoManualCaja);
        rdGarantia = v.findViewById(R.id.rdGarantiaCaja);
        rdNoGarantia = v.findViewById(R.id.rdNoGarantiaCaja);
        rdEquipoSo = v.findViewById(R.id.rdEquipoSo);
        rdNoEquipoSO = v.findViewById(R.id.rdNoEquipoSo);
        rdMonitor = v.findViewById(R.id.rdMonitor);
        rdNoMonitor = v.findViewById(R.id.rdNoMonitor);
        rdAudio = v.findViewById(R.id.rdAudio);
        rdNoAudio = v.findViewById(R.id.rdNoAudio);
        rdTouchpad = v.findViewById(R.id.rdTouchpad);
        rdNoTouchpad = v.findViewById(R.id.rdNoTouchpad);

        btnFoto1 = v.findViewById(R.id.btnFoto1);
        btnFoto2 = v.findViewById(R.id.btnFoto2);
        btnRegistrarEquipo = v.findViewById(R.id.btnAddRegistro);

        imgFoto1 = v.findViewById(R.id.imgFoto1);
        imgFoto2 = v.findViewById(R.id.imgFoto2);

        presenter = new RegistroEquipoPresenterImpl(this);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        f = formatter.format(calendar.getTime());
        txtFecha.setText(f);

        btnFoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((OtraActividad)getActivity()).permisosCamara1(imgFoto1);
            }
        });

        btnFoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((OtraActividad)getActivity()).permisosCamara2(imgFoto2);
            }
        });

        btnRegistrarEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solicitarRegistro();
            }
        });

        return v;
    }

    @Override
    public void exitoEquipo() {
        Toast.makeText(getContext(), "REGISTRO EFECTUADO", Toast.LENGTH_SHORT).show();
        ((OtraActividad)getActivity()).permisosAlmacenamiento(txtCodigo.getText().toString());
    }

    @Override
    public void errorEquipo() {
        Toast.makeText(getContext(), "NO SE PUDO REGISTRAR", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setErrorCodigo() {
        Toast.makeText(getContext(), "INGRESE CODIGO", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setErrorMarca() {
        Toast.makeText(getContext(), "INGRESE MARCA", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setErrorModelo() {
        Toast.makeText(getContext(), "INGRESE MODELO", Toast.LENGTH_SHORT).show();
    }

    public void solicitarRegistro(){
        String equipo   = "";
        String cargador = "";
        String manual   = "";
        String garantia = "";
        String equipoSo = "";
        String monitor  = "";
        String audio    = "";
        String touchpad = "";
        if(rdEquipo.isChecked()){
            equipo = "si incluye";
        }
        if(rdNoEquipo.isChecked()){
            equipo = "no incluye";
        }
        if(rdCargador.isChecked()){
            cargador = "si incluye";
        }
        if(rdNoCargador.isChecked()){
            cargador = "ni incluye";
        }
        if(rdManual.isChecked()){
            manual = "si incluye";
        }
        if(rdNoManual.isChecked()){
            manual = "no incluye";
        }
        if(rdGarantia.isChecked()){
            garantia = "si incluye";
        }
        if(rdNoGarantia.isChecked()){
            garantia = "no incluye";
        }
        if(rdEquipoSo.isChecked()){
            equipoSo = "si enciende";
        }
        if(rdNoEquipoSO.isChecked()){
            equipoSo = "no enciende";
        }
        if(rdMonitor.isChecked()){
            monitor = "si funciona";
        }
        if(rdNoMonitor.isChecked()){
            monitor = "no funciona";
        }
        if(rdAudio.isChecked()){
            audio = "si funciona";
        }
        if(rdNoAudio.isChecked()){
            audio = "no funciona";
        }
        if(rdTouchpad.isChecked()){
            touchpad = "si funciona";
        }
        if(rdNoTouchpad.isChecked()){
            touchpad = "no funciona";
        }
        presenter.registrarEquipo(txtCodigo.getText().toString(),txtMarca.getText().toString(),txtModelo.getText().toString(),f,equipo,cargador,manual,garantia,equipoSo,monitor,
                audio,touchpad,txtObservaciones.getText().toString(),getContext());
    }

    public static  void mostrarImagen(ImageView img, Bitmap bitmap){

        img.setImageBitmap(bitmap);
    }
}