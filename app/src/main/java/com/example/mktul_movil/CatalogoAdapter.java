package com.example.mktul_movil;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CatalogoAdapter extends RecyclerView.Adapter<CatalogoAdapter.ViewHolder> {
    private Context context;
    private List <CatalogoObject> listas;

    public CatalogoAdapter(Context context, List <CatalogoObject> listas){
        this.context = context;
        this.listas = listas;
    }

    @NonNull
    @Override
    public CatalogoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        LayoutInflater linf = LayoutInflater.from(context);
        v = linf.inflate(R.layout.cardview_catalogos,viewGroup, false);
        return new CatalogoAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final CatalogoAdapter.ViewHolder viewHolder, int i) {
        viewHolder.nomCat.setText(listas.get(i).getNombreCat());
        viewHolder.vend.setText(listas.get(i).getVendCat());

        //click
        viewHolder.dir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"Dirigir a: " + viewHolder.nomCat.getText().toString(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Producto_Catalogo.class);
                intent.putExtra("Tienda", viewHolder.nomCat.getText().toString());
                intent.putExtra("Vendedor", viewHolder.vend.getText().toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomCat, idCat,vend;
        ImageView imagCat;
        Button dir;
        public ViewHolder(@NonNull View iv){
            super(iv);
            nomCat = iv.findViewById(R.id.txt_categoria);
            imagCat = iv.findViewById(R.id.img_categoria);
            vend = iv.findViewById(R.id.txt_vendCat);
            dir = iv.findViewById(R.id.btn_catalogos);
        }
    }
}
