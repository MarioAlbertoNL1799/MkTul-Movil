package com.example.mktul_movil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//Adaptador recycler view productos
public class Producto_Adapter extends RecyclerView.Adapter<Producto_Adapter.ProductoHolder> {
    private LayoutInflater layoutInflater;
    private List<Producto> productos;

    public Producto_Adapter(Context context, List<Producto> productos){
        this.layoutInflater = LayoutInflater.from(context);
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.cardview_productos,viewGroup,false);
        return new ProductoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoHolder productoHolder, int i) {
        String nombre = productos.get(i).toString();
        productoHolder.nomProd.setText(nombre);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ProductoHolder extends RecyclerView.ViewHolder{
        TextView nomProd, idProd, precioProd;
        Button addCar;


        public ProductoHolder(@NonNull View itemView) {
            super(itemView);
            nomProd = itemView.findViewById(R.id.nomProd);
            idProd = itemView.findViewById(R.id.id_cat_prod);
            precioProd = itemView.findViewById(R.id.cat_precioProd);
            addCar = itemView.findViewById(R.id.button_AnadirCarrito1);
        }
    }
}