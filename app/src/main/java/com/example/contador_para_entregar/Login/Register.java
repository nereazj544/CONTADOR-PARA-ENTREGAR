package com.example.contador_para_entregar.Login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contador_para_entregar.R;

public class Register extends AppCompatActivity {

    //Boton
    Button btnRegis;

    //EditText
    EditText user, pass, repass;
    DBhelper DBhelper;
    TextView loggin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        user = (EditText) findViewById(R.id.name_user);
        pass = (EditText) findViewById(R.id.contra);
        repass = (EditText) findViewById(R.id.contraf);
        btnRegis = (Button) findViewById(R.id.register);
        loggin = findViewById(R.id.login);

        final DBhelper DBhelper = new DBhelper(this);


        //CAMBIO DE COLOR
        user.setTextColor(Color.WHITE);
        pass.setTextColor(Color.WHITE);
        repass.setTextColor(Color.WHITE);

        //Texto a la escucha
        loggin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivityLogin.class);
                startActivity(intent);
            }
        });






        //Boton a la escucha
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User, Pass, RePass;
                User = user.getText().toString();
                Pass = pass.getText().toString();
                RePass = repass.getText().toString();

                if (User.equals("") ||
                        Pass.equals("") || RePass.equals("")){
                    Toast.makeText(Register.this,
                            "CAMPOS SIN RELLENAR",
                            Toast.LENGTH_SHORT).show();
                }else {
                    if (Pass.equals(RePass)) {
                        if (DBhelper.OkUser(User)) {
                            Toast.makeText(Register.this,
                                    "Usuario existente",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }

                        boolean registro = DBhelper.insertDatos(User, Pass);
                        if (registro){
                            Toast.makeText(Register.this,
                                    "Te hemos hakeado el telefono :)",
                                    Toast.LENGTH_LONG).show();
                        }else
                            Toast.makeText(Register.this,
                                    "Usuario no registrado",
                                    Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(Register.this,
                                "NO COINCIDEN CONTRASEÑAS",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }




    }
//End app
