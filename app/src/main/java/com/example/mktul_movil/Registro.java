package com.example.mktul_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    TextView nombre,apellidos, usuario, correo, pass, pass2;
    Button registro;
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuario = findViewById(R.id.eTxt_RegUsuario);
        nombre = findViewById(R.id.eTxt_RegNombre);
        apellidos = findViewById(R.id.eTxt_RegApellido);
        correo = findViewById(R.id.eTxt_Email);
        pass = findViewById(R.id.eTxt_RegPass);
        pass2 = findViewById(R.id.eTxt_RepRegPass);
        spin = findViewById(R.id.RegTipo);

        registro = findViewById(R.id.btn_RegRegistrar);
    }

    public void Registro(View view){
        String tipo_registro = spin.getSelectedItem().toString();
        Toast.makeText(this, "Usuario tipo " + tipo_registro, Toast.LENGTH_SHORT).show();
        if(!validar()) return;
    }

    //validacion simple de registro
    private boolean validar() {
        boolean valid = true;
        String sUser = usuario.getText().toString();
        String sNombre = nombre.getText().toString();
        String sApe = apellidos.getText().toString();
        String sEmail = correo.getText().toString();
        String pwd = pass.getText().toString();
        String pwd2 = pass2.getText().toString();

        if (sNombre.isEmpty() || sNombre.length() < 3) {
            nombre.setError("Ingrese al menos 4 caracteres");
            valid = false;
        } else {
            nombre.setError(null);
        }

        if (sUser.isEmpty() || sUser.length() < 3){
            usuario.setError("Ingrese al menos 4 carácteres");
            valid = false;
        } else{
            usuario.setError(null);
        }

        if (sEmail.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()) {
            correo.setError("Dirección de correo electrónico no válida");
            valid = false;
        } else {
            correo.setError(null);
        }

        if (sApe.isEmpty() || sApe.length() < 3) {
            apellidos.setError("Ingrese al menos 4 carácteres alfanuméricos");
            valid = false;
        } else {
            apellidos.setError(null);
        }

        if (pwd.isEmpty() || pwd.length() < 8){
            pass.setError("Ingrese al menos 8 caracteres");
        }else{
            pass.setError(null);
        }
        if (pwd2.equals(pwd)){
            pass2.setError(null);
        }else{
            pass2.setError("Contraseñas no coinciden");
        }
        return valid;
    }
}