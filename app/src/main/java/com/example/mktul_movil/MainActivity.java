package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_registro, btn_ingreso;
    EditText eTxt_Usuario;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_registro = findViewById(R.id.btn_Registro);
        btn_ingreso = findViewById(R.id.btn_Ingreso);
        eTxt_Usuario = findViewById(R.id.eTxt_Usuario);


        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        conexion();
    }

    @Override
    protected void onResume() {// al dejar la aplicacion en segundo plano y retornar valida la conexion.
        super.onResume();
        conexion();
    }

    public void registro(View view) {
        usuario = eTxt_Usuario.getText().toString();
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
    public void ingreso(View view){
        usuario = eTxt_Usuario.getText().toString();
        switch (usuario){
            case "admin1290":
                Intent intent = new Intent(this, Config_Admin.class);
                intent.putExtra("dato_inicio",usuario);//envio de dato de login, cambiar por variable obtenida de api
                startActivity(intent);
                finish();
                break;
            case "cons1290":
                Intent intent1 = new Intent(this, Config_Cuenta.class);
                intent1.putExtra("dato_inicio",usuario);
                startActivity(intent1);
                finish();
                break;
            case "vend1290":
                Intent intent2 = new Intent(this, Config_Vendedor.class);
                intent2.putExtra("dato_inicio",usuario);
                startActivity(intent2);
                finish();
                break;
        }

    }

    public void conexion(){ //verificacion de conexion
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // Si hay conexión a Internet en este momento
        } else {
            // No hay conexión a Internet en este momento
            Toast t =Toast.makeText(getApplicationContext(),"No hay acceso a Internet",Toast.LENGTH_SHORT);
            t.show();
        }
    }
}