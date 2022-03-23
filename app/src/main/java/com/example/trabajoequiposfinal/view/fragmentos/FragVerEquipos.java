package com.example.trabajoequiposfinal.view.fragmentos;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trabajoequiposfinal.R;
import com.example.trabajoequiposfinal.interactor.recyclerView.AdaptadorDatos;
import com.example.trabajoequiposfinal.interactor.recyclerView.RegistroEquiposDatos;
import com.example.trabajoequiposfinal.interfaces.mostrarequipo.VerEquipoPresenter;
import com.example.trabajoequiposfinal.interfaces.mostrarequipo.VerEquipoView;
import com.example.trabajoequiposfinal.presenter.mostrarequipo.VerEquipoPresenterImpl;

import java.util.ArrayList;


public class FragVerEquipos extends Fragment implements VerEquipoView {

   AdaptadorDatos adaptador;
   VerEquipoPresenter presentador;
   RecyclerView myRecyclerView2;

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
      
      View v = inflater.inflate(R.layout.fragment_frag_ver_equipo, container, false);
      
      myRecyclerView2 = v.findViewById(R.id.myRecyclerView2);
      
      presentador = new VerEquipoPresenterImpl(this);
      presentador.llenarRecycler(getContext());

      return v;
   }
   


   @Override
   public void exito(ArrayList<RegistroEquiposDatos> listaRegistros) {
      adaptador = new AdaptadorDatos(listaRegistros, getContext());
      LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
      myRecyclerView2.setLayoutManager(layoutManager);
      myRecyclerView2.setAdapter(adaptador);
      
   }

   

   @Override
   public void error() {
      Toast.makeText(getContext(), "NO EXISTEN REGISTROS", Toast.LENGTH_SHORT).show();
   }
}