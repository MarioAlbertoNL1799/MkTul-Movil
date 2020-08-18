package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< Updated upstream
=======
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
>>>>>>> Stashed changes

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
<<<<<<< Updated upstream
=======
import android.widget.Adapter;
import android.widget.GridLayout;
>>>>>>> Stashed changes
import android.widget.Toast;

public class Producto_Catalogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto__catalogo);
<<<<<<< Updated upstream
=======

        RecyclerView recview = findViewById(R.id.recycler);

        items = new ArrayList<Producto>();

        items.add(new Producto("Producto 1"));
        items.add(new Producto("Producto 2"));
        items.add(new Producto("Producto 3"));

        recview.setHasFixedSize(true);

        recview.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new Producto_Adapter(this,items);
        recview.setAdapter(adapter);

>>>>>>> Stashed changes
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