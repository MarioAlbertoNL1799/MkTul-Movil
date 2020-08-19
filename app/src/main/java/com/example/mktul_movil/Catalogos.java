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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;

public class Catalogos extends AppCompatActivity {
    String cat,lista;
    TextView texcat,listaProd;
    List<CatalogoObject> lcat;
    CatalogoAdapter adapter;
    private  String catalogosURL = "https://marketul.herokuapp.com/api/categoria-computo/?format=json";
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

        webREST(catalogosURL);

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


    private void parseInformation(String jsonResult){
        JSONArray jsonArray = null;
        String correo, vendedor,nomVend, validado,telefono;
        try{
            jsonArray = new JSONArray(jsonResult);
            Log.i("JSON","Datos: " + jsonArray.toString());
        }catch (JSONException e){
            Log.i("Error de datos",e.getMessage());
        }
        for(int i=0;i<jsonArray.length();i++){
            try{
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                vendedor = jsonObject.getString("idVend");
                nomVend = jsonObject.getString("nombreVend");
                correo = jsonObject.getString("correo");
                telefono = jsonObject.getString("telefono");
                //adapter.add(id_as + ": " + correo +" |validado: "+validado);
                System.out.println("Datos-> nombre= "+nomVend+", correo= "+correo+" ,telefono: "+telefono);
            }catch (JSONException e){
                Log.e("Error parseo",e.getMessage());
            }
        }

    }
}