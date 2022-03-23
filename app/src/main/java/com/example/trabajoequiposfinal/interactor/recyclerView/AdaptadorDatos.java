package com.example.trabajoequiposfinal.interactor.recyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajoequiposfinal.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorDatos extends RecyclerView.Adapter<AdaptadorDatos.ViewHolderDatos> {

    ArrayList<RegistroEquiposDatos> listDatos;
    Context context;

    public AdaptadorDatos(ArrayList<RegistroEquiposDatos> listDatos, Context context){
        this.listDatos = listDatos;
        this.context = context;
    }

    @NonNull
    @Override
    public AdaptadorDatos.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_recycler, null , false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDatos.ViewHolderDatos holder, int position) {
        Bitmap bit1 = listDatos.get(position).getB1();
        Bitmap bit2 = listDatos.get(position).getB2();
        String cod = listDatos.get(position).getCodigo();
        String marc = listDatos.get(position).getMarca();
        String model = listDatos.get(position).getModelo();
        String fec = listDatos.get(position).getFecha();
        String equip = listDatos.get(position).getEquipo();
        String carg = listDatos.get(position).getCargador();
        String manu = listDatos.get(position).getManual();
        String garan = listDatos.get(position).getGarantia();
        String equipSo = listDatos.get(position).getEquipoSo();
        String moni = listDatos.get(position).getMonitor();
        String audi = listDatos.get(position).getAudio();
        String touch = listDatos.get(position).getTouchpad();
        String obser = listDatos.get(position).getObservaciones();

        holder.imagen1.setImageBitmap(bit1);
        holder.imagen2.setImageBitmap(bit2);
        holder.codigo.setText(cod);
        holder.marca.setText(marc);
        holder.modelo.setText(model);
        holder.fecha.setText(fec);
        holder.equipo.setText(equip);
        holder.cargador.setText(carg);
        holder.manual.setText(manu);
        holder.garantia.setText(garan);
        holder.equipoSo.setText(equipSo);
        holder.monitor.setText(moni);
        holder.audio.setText(audi);
        holder.touchpad.setText(touch);
        holder.observaciones.setText(obser);
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }


    public class ViewHolderDatos extends RecyclerView.ViewHolder  {

        ImageView imagen1;
        ImageView imagen2;
        TextView codigo;
        TextView fecha;
        TextView marca;
        TextView modelo;
        TextView equipo;
        TextView cargador;
        TextView manual;
        TextView garantia;
        TextView equipoSo;
        TextView monitor;
        TextView audio;
        TextView touchpad;
        TextView observaciones;

        public ViewHolderDatos(@NonNull View itemView){
            super(itemView);

            imagen1 = itemView.findViewById(R.id.mostrarImg1);
            imagen2 = itemView.findViewById(R.id.mostrarImg2);
            codigo = itemView.findViewById(R.id.mostrarCodigo);
            fecha = itemView.findViewById(R.id.mostrarFecha);
            marca = itemView.findViewById(R.id.mostrarMarca);
            modelo = itemView.findViewById(R.id.mostrarModelo);
            equipo = itemView.findViewById(R.id.mostrarEquipo);
            cargador = itemView.findViewById(R.id.mostrarCargador);
            manual = itemView.findViewById(R.id.mostrarManual);
            garantia = itemView.findViewById(R.id.mostrarGarantia);
            equipoSo = itemView.findViewById(R.id.mostrarEquipoSo);
            monitor = itemView.findViewById(R.id.mostrarMonitor);
            audio = itemView.findViewById(R.id.mostrarAudio);
            touchpad = itemView.findViewById(R.id.mostrarTouchpad);
            observaciones = itemView.findViewById(R.id.mostrarObservaciones);



        }



    }
}
