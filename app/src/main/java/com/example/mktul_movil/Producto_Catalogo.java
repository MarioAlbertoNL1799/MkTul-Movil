package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Producto_Catalogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto__catalogo);
    }

    public void AddProd(View view){
        Toast.makeText(this,"Producto añadido al carrito",Toast.LENGTH_SHORT).show();
    }
    public void Catalogos(View view){
        Intent intent = new Intent(this, Catalogos.class);
        startActivity(intent);
        finish();
    }
}