package com.example.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CrearPersonas extends AppCompatActivity {

    private EditText cedula, nombre, apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_personas);

        cedula = findViewById(R.id.txtCedula);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
    }

    public void guardar(View V){
        String ced, nom, apell;
        Persona persona;
        if(validar()){
            ced = cedula.getText().toString();
            nom = nombre.getText().toString();
            apell = apellido.getText().toString();
            persona = new Persona(ced, nom, apell);
            persona.guardar();
        }
    }

    public boolean validar(){
            String error;
            error = getResources().getString(R.string.error);
        if(cedula.getText().toString().isEmpty()){
            cedula.setError(error);
            return false;
        }else if(nombre.getText().toString().isEmpty()){
            nombre.setError(error);
            return false;
        }else if(apellido.getText().toString().isEmpty()){
            apellido.setError(error);
            return false;
        }
        return true;
    }

    public void limpiar(View V){
        cedula.setText("");
        nombre.setText("");
        apellido.setText("");
        cedula.requestFocus();
    }
}
