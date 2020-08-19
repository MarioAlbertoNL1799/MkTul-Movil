package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

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

public class CarritoCompras extends AppCompatActivity {
    private String GenCarro = "https://marketul.herokuapp.com/api/carrito/?format=json";
    TextView cantidad, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_compras);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());

        //General
        cantidad = findViewById(R.id.textView_Num_Producto);
        total = findViewById(R.id.textView_Precio);
        Carrito_total(GenCarro);


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