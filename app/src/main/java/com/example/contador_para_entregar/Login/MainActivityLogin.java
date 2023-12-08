package com.example.contador_para_entregar.Login;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contador_para_entregar.R;

public class MainActivityLogin extends AppCompatActivity {

    //Datos de los usuarios
    EditText usuario, contra;

    //Boton
    Button btnSesion;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicar_sesion);

        //Editar texto
        usuario = (EditText) findViewById(R.id.name_user);
        contra = (EditText) findViewById(R.id.contra);

        //boton
        btnSesion = (Button) findViewById(R.id.insion);

        //Cambio de color del Edit Text
        usuario.setTextColor(Color.WHITE);
        contra.setTextColor(Color.WHITE);

    }

}
