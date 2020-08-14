package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VendedorVentas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedor_ventas);
    }

    public void Inicio(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void Ventas(View view){
        Intent intent = new Intent(this, VendedorVentas.class);
        startActivity(intent);
        finish();
    }
    public  void Cuenta(View view){
        Intent intent = new Intent(this, Config_Vendedor.class);
        startActivity(intent);
    }
}