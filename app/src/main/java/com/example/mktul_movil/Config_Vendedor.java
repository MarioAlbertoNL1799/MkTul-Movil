package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Config_Vendedor extends AppCompatActivity {
    String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config__vendedor);

        dato = getIntent().getStringExtra("dato_inicio");//dato obtenido de login
        Toast.makeText(this, dato,Toast.LENGTH_SHORT).show();//impresion en movil del dato pasado
    }

    public void Inicio(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void Ventas(View view){
        Intent intent = new Intent(this, VendedorVentas.class);
        startActivity(intent);
    }
    public  void Cuenta(View view){
        Intent intent = new Intent(this, Config_Vendedor.class);
        startActivity(intent);
        finish();
    }

}