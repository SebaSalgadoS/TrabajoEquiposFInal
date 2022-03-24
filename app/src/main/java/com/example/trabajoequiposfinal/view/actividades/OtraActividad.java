package com.example.trabajoequiposfinal.view.actividades;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajoequiposfinal.R;
import com.example.trabajoequiposfinal.interactor.camara.Permisos;
import com.example.trabajoequiposfinal.view.fragmentos.FragEliminarEquipo;
import com.example.trabajoequiposfinal.view.fragmentos.FragRegistroEquipo;
import com.example.trabajoequiposfinal.view.fragmentos.FragVerEquipos;
import com.google.android.material.navigation.NavigationView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OtraActividad extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout myDrawer;
    NavigationView myNav;
    Toolbar myToolbar;

    ActionBarDrawerToggle toogle; //para implementar el icono de hamburguesa

    ImageView imActual;

    String cod = "";

    String nombre = "";

    Bitmap bitmap;
    List<Bitmap> listaFotos = new ArrayList<>();

    TextView cabecera;

    private static final int REQUEST_PERMISSION_CAMERA = 100;
    private static final int TAKE_PICTURE = 101;
    private static  final int REQUEST_PERMISSION_WRITE_STORAGE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra_actividad);

        myDrawer = findViewById(R.id.myDrawerLayout);
        myNav = findViewById(R.id.myNavigationView);
        myToolbar = findViewById(R.id.myToolbar);

        nombre = getIntent().getStringExtra("x");

        //mostrar actionbar
        setSupportActionBar(myToolbar);

        //eventos click en items de navigationDrawer
        myNav.setNavigationItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.myFrame, new FragRegistroEquipo())
                .commit();
        setTitle("Registrar equipo");

        //para activar icono hamburguesa
        //toogle = new ActionBarDrawerToggle(this, myDrawer, myToolbar, R.string.drawer_open, R.string.drawer_close);
        toogle = setDrawerToogle();
        myDrawer.addDrawerListener(toogle); //para oir al icono de hamburguesa

        //NOMBRE CABECERA
        View header = myNav.getHeaderView(0);
        cabecera = header.findViewById(R.id.txtNombreCabecera);
        cabecera.setText(nombre);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toogle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toogle.syncState();
    }

    private ActionBarDrawerToggle setDrawerToogle() {
        return new ActionBarDrawerToggle(this, myDrawer, myToolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //para mostrar los fragmentos
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (item.getItemId()) {
            case R.id.nav_registro:
                ft.replace(R.id.myFrame, new FragRegistroEquipo()).commit();
                break;
            case R.id.nav_ver:
                ft.replace(R.id.myFrame, new FragVerEquipos()).commit();
                break;
            case R.id.nav_eliminar:
                ft.replace(R.id.myFrame, new FragEliminarEquipo()).commit();
                break;
            case R.id.nav_salir:
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

        }
        setTitle(item.getTitle()); //para mostrar el título
        myDrawer.closeDrawers(); //para cerrar drawer
        return true;
    }

    public void permisosCamara1(ImageView ima){
        this.imActual = ima;
        permisoCamaraGeneral();
    }

    public void permisosCamara2(ImageView ima){
        this.imActual = ima;
        permisoCamaraGeneral();
    }

    public void permisoCamaraGeneral(){
        Permisos p = new Permisos(this,this);
        int x = p.permisoGeneral();
        if(x == 1) tomarFoto();
    }

    public void tomarFoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, TAKE_PICTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if (requestCode == TAKE_PICTURE){
            if(resultCode == Activity.RESULT_OK && data != null){
                listaFotos.add((Bitmap) data.getExtras().get("data"));
                bitmap = (Bitmap) data.getExtras().get("data");

                FragRegistroEquipo.mostrarImagen(this.imActual, bitmap);
            }
        }
        super.onActivityResult(requestCode,resultCode,data);
    }

    public void permisosAlmacenamiento(String codigo){
        cod = codigo;

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.P){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    guardarFoto1();
                    guardarFoto2();
                }
                else{
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION_WRITE_STORAGE);
                }
            }
            else{
                guardarFoto1();
                guardarFoto2();
            }
        }
        else{
            guardarFoto1();
            guardarFoto2();
        }

    }

    public void guardarFoto1(){
        OutputStream outputStream = null;
        File file = null;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            ContentResolver resolver = getContentResolver();
            ContentValues values = new ContentValues();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss");
            String tiempo = formatter.format(new Date());
            String filename = cod + "@Img1" + "@" + tiempo;

            values.put(MediaStore.Images.Media.DISPLAY_NAME,filename);
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            values.put(MediaStore.Images.Media.IS_PENDING, 1);

            Uri collection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
            Uri imageUri = resolver.insert(collection, values);

            try{
                outputStream = resolver.openOutputStream(imageUri);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }

            values.clear();
            values.put(MediaStore.Images.Media.IS_PENDING, 0);

            resolver.update(imageUri, values, null, null);

        }
        else{
            String imageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss");
            String tiempo = formatter.format(new Date());

            String filename = cod + "@Img1" + "@" + tiempo + ".jpg";

            file = new File(imageDir, filename);

            try{
                outputStream = new FileOutputStream(file);
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }

        boolean saved = listaFotos.get(0).compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        if(saved){
            Toast.makeText(this, "Registro Realizado", Toast.LENGTH_SHORT).show();
        }
        if(outputStream != null){
            try{
                outputStream.flush();
                outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(file != null){
            MediaScannerConnection.scanFile(this, new String[]{file.toString()}, null, null);
        }
    }

    public void guardarFoto2(){
        OutputStream outputStream = null;
        File file = null;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            ContentResolver resolver = getContentResolver();
            ContentValues values = new ContentValues();

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss");
            String tiempo = formatter.format(new Date());

            String filename = cod + "@Img2" + "@" + tiempo;

            values.put(MediaStore.Images.Media.DISPLAY_NAME, filename);
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/MyApp");
            values.put(MediaStore.Images.Media.IS_PENDING, 1);

            Uri collection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
            Uri imageUri = resolver.insert(collection, values);

            try{
                outputStream = resolver.openOutputStream(imageUri);
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }

            values.clear();
            values.put(MediaStore.Images.Media.IS_PENDING, 0);
            resolver.update(imageUri, values, null, null);
        }
        else{
            String imageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss");
            String tiempo = formatter.format(new Date());

            String filename = cod + "@Img2" + "@" + tiempo + ".jpg";

            file = new File(imageDir, filename);

            try{
                outputStream = new FileOutputStream(file);
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }

        boolean saved = listaFotos.get(1).compress(Bitmap.CompressFormat.JPEG, 100, outputStream);

        if(saved){
            Toast.makeText(this, "Registro Realizado", Toast.LENGTH_SHORT).show();
        }
        if(outputStream != null){
            try{
                outputStream.flush();
                outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(file != null){
            MediaScannerConnection.scanFile(this, new String[]{file.toString()}, null, null);
        }
        archivos();
    }
    private File[] archivos(){
        File ruta = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File fotos[] = ruta.listFiles();
        return fotos;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResult){
        if(requestCode == REQUEST_PERMISSION_CAMERA){
            if(permissions.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED){
                tomarFoto();
            }
        }
        else if(requestCode == REQUEST_PERMISSION_WRITE_STORAGE){
            if(permissions.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED){
                guardarFoto1();
                guardarFoto2();
            }
        }
        super.onRequestPermissionsResult(requestCode,permissions,grantResult);
    }
}