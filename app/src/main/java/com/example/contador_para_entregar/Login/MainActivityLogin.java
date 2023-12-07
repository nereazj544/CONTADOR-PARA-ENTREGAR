package com.example.contador_para_entregar.Login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contador_para_entregar.MainActivity;
import com.example.contador_para_entregar.R;

public class MainActivityLogin extends AppCompatActivity {
    Button insesion;
    EditText inusuario, incontra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicar_sesion);
        insesion = (Button) findViewById(R.id.iniciar);
        inusuario = (EditText) findViewById(R.id.name_user);
        incontra = (EditText) findViewById(R.id.contra);


        //CAMBIO DE COLOR
        insesion.setTextColor(Color.WHITE);
        incontra.setTextColor(Color.WHITE);



        final Database_Helper DBhelper = new Database_Helper(this);


        insesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean estaLogeado = DBhelper.OkyUserLongin(insesion.getText().toString(),
                        incontra.getText().toString());

                if (estaLogeado){
                    Intent jugar = new Intent(MainActivityLogin.this, MainActivity.class);
                    startActivity(jugar);
                } else {
                    Toast.makeText(MainActivityLogin.this,
                            "Fallo en el sistema",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
}







    //NO CUENTA
    public  void  nocuenta(View v){
        //Esto va a ir a la otra pantalla
        Intent nocuenta = new Intent(this, Registrarse.class);
        startActivity(nocuenta);
        finish();
    }



}
