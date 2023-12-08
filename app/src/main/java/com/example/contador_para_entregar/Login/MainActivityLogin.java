package com.example.contador_para_entregar.Login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contador_para_entregar.PantallaActivity;
import com.example.contador_para_entregar.R;

public class MainActivityLogin extends AppCompatActivity {

    Database_Helper DBhelper;
    Cursor fill;
    Button insesion;
    EditText inusuario, incontra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicar_sesion);
        insesion = (Button) findViewById(R.id.iniciar);
        inusuario = (EditText) findViewById(R.id.name_user);
        incontra = (EditText) findViewById(R.id.contra);

        DBhelper = new Database_Helper(this);

        //CAMBIO DE COLOR
        inusuario.setTextColor(Color.WHITE);
        incontra.setTextColor(Color.WHITE);



    }

    public void iniciar(View v){
        SQLiteDatabase db = DBhelper.getWritableDatabase();
        String user = inusuario.getText().toString();
        String contra = incontra.getText().toString();

        fill = db.rawQuery("select * from usuarios where nombre_de_usuario = ?" + user
                + " and contra = ?" + contra, null);
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(contra))
            Toast.makeText(MainActivityLogin.this, "CAMPOS SIN RELLENAR",
                    Toast.LENGTH_SHORT).show();

            else{
                Boolean Okuser = DBhelper.OkUser(user);
                Boolean Okcontra = DBhelper.OkContra(contra);
                Boolean Okuyc = DBhelper.OkUseryContra(user, contra);
                if (Okuyc == true){
                    Toast.makeText(MainActivityLogin.this, "Iniciando sesion",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivityLogin.this, PantallaActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivityLogin.this, "No se ha podido inicar sesion",
                            Toast.LENGTH_SHORT).show();
                }
        }


    }

    //NO CUENTA
    public  void  nocuenta(View v){
        //Esto va a ir a la otra pantalla
        Intent nocuenta = new Intent(this, Registrarse.class);
        startActivity(nocuenta);
        finish();
    }



}