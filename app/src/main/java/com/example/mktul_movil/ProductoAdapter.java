package com.example.mktul_movil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//Adaptador recycler view productos
public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {
    private Context context;
//    private LayoutInflater layoutInflater;
    private List<Producto> productos;

    public ProductoAdapter(Context context, List<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater linf = LayoutInflater.from(context);
        view = linf.inflate(R.layout.cardview_productos,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nameProd.setText(productos.get(i).getNombreProd());
        viewHolder.costProd.setText(productos.get(i).getPrecioProd());
        //viewHolder.idProd.setText(productos.get(i).getIdProd());
    }

    @Override
    public int getItemCount() {//tamaño del recyclerview
        return productos.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView nameProd, costProd,idProd;//variables de cardview
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //buscar campos del cardview
            nameProd = itemView.findViewById(R.id.nomProd);
            costProd = itemView.findViewById(R.id.cat_precioProd);
            idProd = itemView.findViewById(R.id.id_cat_prod);

        }
    }
}