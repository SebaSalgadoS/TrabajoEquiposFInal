package com.example.trabajoequiposfinal.interactor.mostrarequipo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;

import com.example.trabajoequiposfinal.interactor.database.ConexionDB;
import com.example.trabajoequiposfinal.interactor.recyclerView.RegistroEquiposDatos;
import com.example.trabajoequiposfinal.interfaces.mostrarequipo.VerEquipoInteractor;
import com.example.trabajoequiposfinal.interfaces.mostrarequipo.VerEquipoPresenter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VerEquiposInteractorImpl implements VerEquipoInteractor {

    ArrayList<RegistroEquiposDatos> listaRegistros = new ArrayList<>();

    @Override
    public void llenarRecycler(VerEquipoPresenter presentador, Context contexto) {

        File ruta = null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            ruta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + "/MyApp/");
        }
        else{
            ruta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        }

        File fotos[] = ruta.listFiles();

        String codigo = "";
        String modelo = "";
        String marca  = "";
        String fecha = "";
        String equipo = "";
        String cargador = "";
        String manual = "";
        String garantia = "";
        String equipoSo = "";
        String monitor = "";
        String audio = "";
        String touchpad = "";
        String observaciones = "";


        ConexionDB conexion = new ConexionDB(contexto, "notebook", null, 1);
        SQLiteDatabase bd = conexion.getWritableDatabase();

        Cursor fila = bd.rawQuery("SELECT * FROM equipos ORDER BY fecha DESC", null);

        if(fila.moveToFirst()){
            do{
                codigo = fila.getString(0);
                marca = fila.getString(1);
                modelo = fila.getString(2);
                fecha = fila.getString(3);
                equipo = fila.getString(4);
                cargador = fila.getString(5);
                manual = fila.getString(6);
                garantia = fila.getString(7);
                equipoSo = fila.getString(8);
                monitor = fila.getString(9);
                audio = fila.getString(10);
                touchpad = fila.getString(11);
                observaciones = fila.getString(12);

                List<Bitmap> archivos = new ArrayList<>();

                if(fotos != null){
                    for(int i = 0; i<fotos.length; i++){
                        if(fotos[i].getAbsolutePath().contains(codigo)){
                            archivos.add(BitmapFactory.decodeFile(fotos[i].getAbsolutePath()));
                        }
                    }
                    listaRegistros.add(new RegistroEquiposDatos(archivos.get(0),archivos.get(1),"Codigo: "+codigo,"Marca: "+marca,"Modelo: "+modelo,"Fecha: "+fecha,
                            "Equipo: "+equipo,"Cargador: "+cargador,"Manual: "+manual, "Garantia: "+garantia,"Equipo/SystemOP: "+equipoSo,
                            "Monitor: "+monitor, "Audio: "+audio,"Touchpad: "+touchpad,"Observaciones: "+observaciones));
                }
                else{
                    Toast.makeText(contexto, "Aun no hay Fotos", Toast.LENGTH_SHORT).show();
                    break;
                }
            }while(fila.moveToNext());

            presentador.exito(listaRegistros);
        }
        else{
            presentador.error();
        }
        fila.close();
        bd.close();






    }
}
