package com.example.contador_para_entregar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contador_para_entregar.Login.DBhelper;

public class MainActivityLogin extends AppCompatActivity {

    DBhelper dBhelper;

    //Datos de los usuarios
    EditText usuario, pass;

    //Boton
    Button btnSesion;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicar_sesion);

        //Editar texto
        usuario = (EditText) findViewById(R.id.name_user);
        pass = (EditText) findViewById(R.id.contra);

        //boton
        btnSesion = (Button) findViewById(R.id.insion);

        //Cambio de color del Edit Text
        usuario.setTextColor(Color.WHITE);
        pass.setTextColor(Color.WHITE);

        dBhelper = new DBhelper(this);

        btnSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isLogged = dBhelper.OkSP(usuario.getText().toString(),
                        pass.getText().toString());

                if (isLogged){
                   Intent logg = new Intent(MainActivityLogin.this, PantallaActivity.class);
                   startActivity(logg);


                }else{
                    Toast.makeText(MainActivityLogin.this, "No carrula", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public  void  nocuenta(View v){
        //Esto va a ir a la otra pantalla
        Intent nocuenta = new Intent(this, Register.class);
        startActivity(nocuenta);
        finish();
    }


}
