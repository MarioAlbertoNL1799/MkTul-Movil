package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminVendedores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_vendedores);
    }

    public void InicioCuenta(View view) {
        Intent intent = new Intent(this, Config_Admin.class);
        startActivity(intent);
        finish();
    }
    public void Vendedores(View view){
        Intent intent = new Intent(this, AdminVendedores.class);
        startActivity(intent);
        finish();
    }
    public void Acceso(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}