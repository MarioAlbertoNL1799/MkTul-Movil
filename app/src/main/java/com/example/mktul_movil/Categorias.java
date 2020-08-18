package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Categorias extends AppCompatActivity {
    String boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
    }

    public void Menu(View view){
        Intent intent = new Intent(this, Config_Cuenta.class);
        startActivity(intent);
        finish();
    }
    // Categorias
    public void CatalogosComputo(View view){
        boton = "Computo";
        //Toast.makeText(this,"Dirigiendo catalogos de: "+ boton, Toast.LENGTH_LONG).show();//mensaje de ubicacion de categoria
        Intent intent = new Intent(this, Catalogos.class);
        intent.putExtra("categoria",boton);
        startActivity(intent);
    }
    public void CatalogosDomesticos(View view){
        boton= "Electrodomesticos";
        //Toast.makeText(this,"Dirigiendo catalogos de: "+ boton, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Catalogos.class);
        intent.putExtra("categoria",boton);
        startActivity(intent);

    }
    public void CatalogosMascota(View view){
        boton = "Mascotas";
        //Toast.makeText(this,"Dirigiendo catalogos de: " + boton, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Catalogos.class);
        intent.putExtra("categoria",boton);
        startActivity(intent);
    }
    public void CatalogosInfantil(View view){
        boton = "Niños";
        //Toast.makeText(this,"Dirigiendo catalogos de: " + boton, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Catalogos.class);
        intent.putExtra("categoria",boton);
        startActivity(intent);
    }
    public void CatalogosHombre(View view){
        boton = "Hombre";
        //Toast.makeText(this,"Dirigiendo catalogos de: " + boton, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Catalogos.class);
        intent.putExtra("categoria",boton);
        startActivity(intent);
    }
    public void CatalogosMujer(View view){
        boton = "Mujer";
        //Toast.makeText(this,"Dirigiendo catalogos de: " + boton, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Catalogos.class);
        intent.putExtra("categoria",boton);
        startActivity(intent);
    }
    public void CatalogosMuebles(View view){
        boton = "Muebles";
        //Toast.makeText(this,"Dirigiendo catalogos de: " + boton, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Catalogos.class);
        intent.putExtra("categoria",boton);
        startActivity(intent);
    }
    public void CatalogosLibros(View view){
        boton = "Libros";
        Intent intent = new Intent(this, Catalogos.class);
        //Toast.makeText(this,"Dirigiendo catalogos de: " + boton, Toast.LENGTH_SHORT).show();
        intent.putExtra("categoria",boton);
        startActivity(intent);
    }
}