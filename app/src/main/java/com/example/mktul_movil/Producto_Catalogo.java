package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Producto_Catalogo extends AppCompatActivity {

    List<Producto> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto__catalogo);

        RecyclerView recview = findViewById(R.id.recycler);

        items = new ArrayList<>();

        //creacion de objetos acorde el constructor creado
        items.add(new Producto("Producto 1","$ 1500.00",1,R.drawable.libros));
        items.add(new Producto("Huawei","$ 1500.00",1,R.drawable.libros));
        items.add(new Producto("Impresora","$ 1500.00",1,R.drawable.libros));

        ProductoAdapter adapter = new ProductoAdapter(this, items);
        recview.setAdapter(adapter);
        recview.setLayoutManager(new GridLayoutManager(this,2));


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