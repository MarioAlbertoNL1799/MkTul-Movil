package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Catalogos extends AppCompatActivity {
    String cat,lista;
    TextView texcat,listaProd;
    List<CatalogoObject> lcat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogos);

        texcat = findViewById(R.id.textView_Registro2);
        cat = getIntent().getStringExtra("categoria");
        texcat.setText(cat);
        listaProd = findViewById(R.id.txt_categoria);//texto de categoria

        RecyclerView rview = findViewById(R.id.recyclerv);

        lcat  = new ArrayList<>();

        lcat.add(new CatalogoObject("MKTUL","Marco Antonio",R.drawable.computadoras));
        lcat.add(new CatalogoObject("Radioshack","Javier Gomez",R.drawable.computadoras));
        lcat.add(new CatalogoObject("Steren","Daniel Diaz",R.drawable.computadoras));
        lcat.add(new CatalogoObject("Electronics","Alejandra",R.drawable.computadoras));
        lcat.add(new CatalogoObject("Roboticx","Diego",R.drawable.computadoras));
        lcat.add(new CatalogoObject("Computo Tec","Mario",R.drawable.computadoras));

        CatalogoAdapter adapter = new CatalogoAdapter(this, lcat);
        rview.setAdapter(adapter);
        rview.setLayoutManager(new GridLayoutManager(this,2));

    }
    public void Categorias(View view){
        Intent intent = new Intent(this, Categorias.class);
        startActivity(intent);
        finish();
    }

}