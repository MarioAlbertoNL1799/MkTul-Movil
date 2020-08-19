package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Producto_Catalogo extends AppCompatActivity {
    TextView titulo, vendedor;
    String tienda, cpersona;
    List<Producto> items;
    private String lprods = "https://marketul.herokuapp.com/api/catalogo-productos/1/?format=json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto__catalogo);

        RecyclerView recview = findViewById(R.id.recycler);
        titulo = findViewById(R.id.textView_Registro2);//dato a pasar variable
        vendedor = findViewById(R.id.textView3);

        tienda = getIntent().getStringExtra("Tienda");
        cpersona = getIntent().getStringExtra("Vendedor");

        titulo.setText(tienda);
        vendedor.setText(cpersona);

        items = new ArrayList<>();

        //creacion de objetos acorde el constructor creado
        /*items.add(new Producto("Producto 1","$ 1500.00",1,R.drawable.libros));
        items.add(new Producto("Huawei","$ 1500.00",1,R.drawable.libros));
        items.add(new Producto("Impresora","$ 1500.00",1,R.drawable.libros));*/

        webREST(lprods);

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


    private void webREST(String respuestaURL){
        try{
            URL url = new URL(respuestaURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Log.e("Abriendo conexion",connection.toString());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            String webResult="";
            while ((line = bufferedReader.readLine()) != null){
                webResult += line;
            }
            bufferedReader.close();
            parseInformation(webResult);
        }catch(Exception e){
            Log.e("Error de conexion",e.getMessage());
        }
    }

//obtencion de prodctos xD
    private void parseInformation(String jsonResult){
        JSONArray jsonArray = null;
        String prod, precio,idp;
        try{
            jsonArray = new JSONArray(jsonResult);
            Log.i("JSON","Datos: " + jsonArray.toString());
        }catch (JSONException e){
            Log.i("Error de datos",e.getMessage());
        }
        for(int i=0;i<jsonArray.length();i++){
            try{
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                prod = jsonObject.getString("nombreProd");
                precio = jsonObject.getString("precioProd");
                idp = jsonObject.getString("idProd");
                items.add(new Producto(prod,"$ "+ precio,Integer.parseInt(idp),R.drawable.phone));
                Log.e("Datos", "nombreproducto= "+prod+", precio= "+precio+" ,id: "+idp);
            }catch (JSONException e){
                Log.e("Error parseo",e.getMessage());
            }
        }

    }


}