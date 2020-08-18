package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Catalogos extends AppCompatActivity {
    String cat;
    TextView texcat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogos);

        texcat = findViewById(R.id.textView_Registro2);
        cat = getIntent().getStringExtra("categoria");
        texcat.setText(cat);

    }
    public void Categorias(View view){
        Intent intent = new Intent(this, Categorias.class);
        startActivity(intent);
        finish();
    }

    public void Productos(View view){
        Intent intent = new Intent(this, Producto_Catalogo.class);
        startActivity(intent);
    }
}