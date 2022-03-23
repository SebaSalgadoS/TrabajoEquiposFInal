package com.example.trabajoequiposfinal.interactor.recyclerView;

import android.graphics.Bitmap;

public class RegistroEquiposDatos {


    private Bitmap b1;
    private Bitmap b2;
    private String codigo;
    private String fecha;
    private String marca;
    private String modelo;
    private String equipo;
    private String cargador;
    private String manual;
    private String garantia;
    private String equipoSo;
    private String monitor;
    private String audio;
    private String touchpad;
    private String observaciones;


    public RegistroEquiposDatos(Bitmap b1, Bitmap b2, String codigo, String fecha, String marca, String modelo, String equipo, String cargador, String manual, String garantia, String equipoSo,
                               String monitor, String audio, String touchpad, String observaciones){

        this.b1 = b1;
        this.b2 = b2;
        this.codigo = codigo;
        this.fecha = fecha;
        this.marca = marca;
        this.modelo = modelo;
        this.equipo = equipo;
        this.cargador = cargador;
        this.manual = manual;
        this.garantia = garantia;
        this.equipoSo = equipoSo;
        this.monitor = monitor;
        this.audio = audio;
        this.touchpad = touchpad;
        this.observaciones = observaciones;
    }

    public Bitmap getB1(){

        return b1;
    }

    public void setB1(Bitmap b1){

        this.b1 = b1;
    }

    public Bitmap getB2(){

        return b2;
    }

    public void setB2(Bitmap b2){

        this.b2 = b2;
    }

    public String getCodigo(){

        return codigo;
    }

    public void setCodigo(String codigo){

        this.codigo = codigo;
    }

    public String getFecha(){

        return fecha;
    }

    public void setFecha(String fecha){

        this.fecha = fecha;
    }

    public String getEquipo(){

        return equipo;
    }

    public void setEquipo(String equipo){

        this.equipo = equipo;
    }

    public String getModelo(){

        return modelo;
    }

    public void setModelo(String modelo){

        this.modelo = modelo;
    }

    public  String getMarca(){

        return marca;
    }

    public void setMarca(String marca){

        this.marca = marca;
    }

    public String getCargador(){

        return cargador;
    }

    public void setCargador(String cargador){

        this.cargador = cargador;
    }

    public String getEquipoSo(){

        return equipoSo;
    }

    public void setEquipoSo(String equipoSo){

        this.equipoSo = equipoSo;
    }

    public String getMonitor(){

        return monitor;
    }

    public void setMonitor(String monitor){

        this.monitor = monitor;
    }

    public String getManual(){

        return manual;
    }

    public void setManual(String manual){

        this.manual = manual;
    }

    public String getGarantia(){

        return garantia;
    }

    public void setGarantia(String garantia){

        this.garantia = garantia;
    }

    public String getAudio(){

        return audio;
    }

    public void setAudio(String audio){

        this.audio = audio;
    }

    public String getTouchpad(){

        return touchpad;
    }

    public void setTouchpad(String touchpad){

        this.touchpad = touchpad;
    }

    public String getObservaciones(){

        return observaciones;
    }

    public void setObservaciones(String observaciones){

        this.observaciones = observaciones;
    }
}