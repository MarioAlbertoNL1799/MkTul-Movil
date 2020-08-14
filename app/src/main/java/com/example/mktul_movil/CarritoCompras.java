package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CarritoCompras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_compras);
    }

    public void Inicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void Categorias(View view){
        Intent intent = new Intent(this, Categorias.class);
        startActivity(intent);
    }
    public void Carrito(View view){
        Intent intent = new Intent(this, CarritoCompras.class);
        startActivity(intent);
        finish();
    }
    public void Cuenta(View view){
        Intent intent = new Intent(this, Config_Cuenta.class);
        startActivity(intent);
    }

}