package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    }

    public void registro(View view) {
        usuario = eTxt_Usuario.getText().toString();
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
    public void ingreso(View view){
        usuario = eTxt_Usuario.getText().toString();
        switch (usuario){
            case "admin":
                Intent intent = new Intent(this, Config_Admin.class);
                startActivity(intent);
                finish();
                break;
            case "consumidor":
                Intent intent1 = new Intent(this, Config_Cuenta.class);
                startActivity(intent1);
                finish();
                break;
            case "vendedor":
                Intent intent2 = new Intent(this, Config_Vendedor.class);
                startActivity(intent2);
                finish();
                break;
        }

    }
}