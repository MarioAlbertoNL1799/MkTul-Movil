package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

public class Config_Admin extends AppCompatActivity {
    String dato;//variable del dato a recibir

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config__admin);

        dato = getIntent().getStringExtra("dato_inicio");//dato obtenido de login
        Toast.makeText(this, dato,Toast.LENGTH_SHORT).show();//impresion en movil del dato pasado
    }

    public void Inicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void Vendedores(View view){
        Intent intent = new Intent(this, AdminVendedores.class);
        startActivity(intent);
        finish();
    }
}