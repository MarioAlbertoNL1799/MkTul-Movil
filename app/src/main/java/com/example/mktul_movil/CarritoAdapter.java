package com.example.mktul_movil;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarritoAdapter extends RecyclerView.Adapter<CarritoAdapter.ViewHolder> {
    private Context context;
    private List<Producto> lcar;

    public CarritoAdapter(Context context, List <Producto> listas){
        this.context = context;
        this.lcar = listas;
    }

    @NonNull
    @Override
    public CarritoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        LayoutInflater linf = LayoutInflater.from(context);
        v = linf.inflate(R.layout.card_lista_carrito,viewGroup, false);
        return new CarritoAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final CarritoAdapter.ViewHolder viewHolder, int i) {
        viewHolder.nameProd.setText(lcar.get(i).getNombreProd());
        viewHolder.nameProd.setText(lcar.get(i).getPrecioProd());

        //click
        viewHolder.dir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"Dirigir a: " + viewHolder.nomCat.getText().toString(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Producto_Catalogo.class);
                intent.putExtra("Tienda", viewHolder.nameProd.getText().toString());
                intent.putExtra("Vendedor", viewHolder.costProd.getText().toString());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return lcar.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameProd, costProd,idProd;//variables de cardview
        ImageView imagCat;
        Button dir;
        public ViewHolder(@NonNull View iv){
            super(iv);
            nameProd = itemView.findViewById(R.id.editText_Descripcion2);
            costProd = itemView.findViewById(R.id.textView_PrecioDescripcion);
            //idProd = itemView.findViewById(R.id.id_cat_prod);
        }
    }
}
