package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CarritoCompras extends AppCompatActivity {
    private String GenCarro = "https://marketul.herokuapp.com/api/carrito/?format=json";
    TextView cantidad, total;
    List<Producto> lisrprod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_compras);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());



        //General
        cantidad = findViewById(R.id.textView_Num_Producto);
        total = findViewById(R.id.textView_Precio);
        Carrito_total(GenCarro);


        //  Cards
        RecyclerView recview = findViewById(R.id.Lista_productos);

        lisrprod= new ArrayList<>();
        lisrprod.add(new Producto("Producto 1","$ 1500.00",1,R.drawable.libros));
        lisrprod.add(new Producto("Huawei","$ 1500.00",1,R.drawable.libros));
        lisrprod.add(new Producto("Impresora","$ 1500.00",1,R.drawable.libros));

        ProductoAdapter adapter = new ProductoAdapter(this, lisrprod);
        recview.setAdapter(adapter);
        recview.setLayoutManager(new GridLayoutManager(this,2));
    }

    public void Inicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void Categorias(View view){
        Intent intent = new Intent(this, Categorias.class);
        startActivity(intent);
    }
    public void Carrito(View view){
        Intent intent = new Intent(this, CarritoCompras.class);
        startActivity(intent);
        finish();
    }
    public void Cuenta(View view){
        Intent intent = new Intent(this, Config_Cuenta.class);
        startActivity(intent);
    }


    //Metodo general
    private void Carrito_total(String respuestaURL){
        try{
            URL url = new URL(respuestaURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Log.e("Abriendo conexion",connection.toString());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            String webResult="";
            JSONObject js = null;
            while ((line = bufferedReader.readLine()) != null){
                webResult += line;
                js = new JSONObject(webResult);
            }
            bufferedReader.close();
            parsGeneral(js);
        }catch(Exception e){
            Log.e("Error de conexion",e.getMessage());
        }
    }

    private void parsGeneral(JSONObject jsonObject) {
        String count,price;
        Log.e("JSON: ", jsonObject.toString());
        //Se obtiene cada uno de los datos cliente del webservice
        try {
            count = jsonObject.getString("cantidad");
            price = jsonObject.getString("subtotal");
            //Se muestran los datos del cliente en su respectivo EditText
            cantidad.setText(count);
            total.setText("$ " + price);

        }catch (JSONException e){
            Log.e("Error parseo ",e.getMessage());
        }
    }

}