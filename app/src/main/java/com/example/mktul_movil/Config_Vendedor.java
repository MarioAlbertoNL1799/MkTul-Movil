package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Config_Vendedor extends AppCompatActivity {
    TextView ConfNombre,ConfEmail, ConfTel;
    String dato;
    private String Urldata = "https://marketul.herokuapp.com/api/consumidor-config/?format=json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config__vendedor);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());

        //campos de la vista
        ConfNombre = findViewById(R.id.eTxt_ConfNombre);
        ConfTel = findViewById(R.id.eTxtConfTel);
        ConfEmail = findViewById(R.id.eTxtConfEmail);

        webS(Urldata);

        dato = getIntent().getStringExtra("dato_inicio");//dato obtenido de login
        Toast.makeText(this, dato,Toast.LENGTH_SHORT).show();//impresion en movil del dato pasado
    }

    public void Inicio(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void Ventas(View view){
        Intent intent = new Intent(this, VendedorVentas.class);
        startActivity(intent);
    }
    public  void Cuenta(View view){
        Intent intent = new Intent(this, Config_Vendedor.class);
        startActivity(intent);
        finish();
    }

    private void webS(String respuestaURL) {
        try {
            URL url = new URL(respuestaURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Log.e("Abriendo conexion", connection.toString());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            String webResult = "";
            JSONObject js = null;
            while ((line = bufferedReader.readLine()) != null) {
                webResult += line;
                js = new JSONObject(webResult);
            }
            bufferedReader.close();
            parseInformation(js);
        } catch (Exception e) {
            Log.e("Error de conexion", e.getMessage());
        }
    }

        private void parseInformation(JSONObject jsonObject) {
            String name, tel,email;
            Log.e("JSON: ", jsonObject.toString());
            //Se obtiene cada uno de los datos cliente del webservice
            try {
                name = jsonObject.getString("nombre");
                email = jsonObject.getString("correo");
                tel = jsonObject.getString("telefono");
                //Se muestran los datos del cliente en su respectivo EditText
                ConfNombre.setText(name);
                ConfEmail.setText(email);
                ConfTel.setText(tel);

            }catch (JSONException e){
                Log.e("Error parseo ",e.getMessage());
            }
        }
    }
