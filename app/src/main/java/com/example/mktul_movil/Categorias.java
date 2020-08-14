package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Categorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
    }

    public void Menu(View view){
        Intent intent = new Intent(this, Config_Cuenta.class);
        startActivity(intent);
    }
    // Categorias
    public void CatalogosComputo(View view){
        Toast.makeText(this,"Dirigiendo catalogos de Computo", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, Catalogos.class);
        startActivity(intent);
    }
    public void CatalogosDomesticos(View view){
        Toast.makeText(this,"Dirigiendo catalogos de Electrodomesticos", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, Catalogos.class);
        startActivity(intent);

    }
    public void CatalogosMascota(View view){
        Toast.makeText(this,"Dirigiendo catalogos de Mascotas", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, Catalogos.class);
        startActivity(intent);
    }
    public void CatalogosInfantil(View view){
        Toast.makeText(this,"Dirigiendo catalogos de Niños", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, Catalogos.class);
        startActivity(intent);
    }
    public void CatalogosHombre(View view){
        Toast.makeText(this,"Dirigiendo catalogos de Hombres", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, Catalogos.class);
        startActivity(intent);
    }
    public void CatalogosMujer(View view){
        Toast.makeText(this,"Dirigiendo catalogos de Mujeres", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, Catalogos.class);
        startActivity(intent);
    }
    public void CatalogosMuebles(View view){
        Toast.makeText(this,"Dirigiendo catalogos de Muebles", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, Catalogos.class);
        startActivity(intent);
    }
    public void CatalogosLibros(View view){
        Intent intent = new Intent(this, Catalogos.class);
        Toast.makeText(this,"Dirigiendo catalogos de Libros", Toast.LENGTH_LONG);
        startActivity(intent);
    }
}