package com.example.contador_para_entregar.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.contador_para_entregar.PantallaActivity;
import com.example.contador_para_entregar.R;

public class Registrarse extends AppCompatActivity {

    Button resesion, registrarse;
    EditText reuser, recontra, reecontra;

    @SuppressLint({"ResourceType", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        recontra = (EditText) findViewById(R.id.contra);
        reecontra = (EditText) findViewById(R.id.contraf);
        reuser = (EditText) findViewById(R.id.name_user);
        registrarse = (Button) findViewById(R.id.reg);

        final Database_Helper DBhelper = new Database_Helper(this);

        //CAMBIO DE COLOR
        reuser.setTextColor(Color.WHITE);
        recontra.setTextColor(Color.WHITE);
        reecontra.setTextColor(Color.WHITE);

        //Inicar sesion
        resesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jugar = new Intent(Registrarse.this, PantallaActivity.class);
                startActivity(jugar);
            }
        });



        //REGISTRARSE
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String user, contra, reContra;
                    user = reuser.getText().toString();
                    contra = recontra.getText().toString();
                    reContra = reecontra.getText().toString();

                    if (user.equals("") ||
                    contra.equals("") || reContra.equals("")){
                        Toast.makeText(Registrarse.this,
                                "CAMPOS SIN RELLENAR",
                                Toast.LENGTH_SHORT).show();
                    }else {
                        if (contra.equals(reContra)) {
                            if (DBhelper.OkUser(user)) {
                                Toast.makeText(Registrarse.this,
                                        "Usuario existente",
                                        Toast.LENGTH_SHORT).show();
                                return;
                            }

                            boolean registro = DBhelper.insertarDatos(user, contra);
                            if (registro){
                                Toast.makeText(Registrarse.this,
                                        "Te hemos hakeado el telefono :)",
                                        Toast.LENGTH_SHORT).show();
                                /*Intent longi = new Intent(Registrarse.this, MainActivityLogin.class);
                                startActivity(longi);

                                 */
                            }else
                                Toast.makeText(Registrarse.this,
                                        "Usuario no registrado",
                                        Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(Registrarse.this,
                                    "NO COINCIDEN CONTRASEÑAS",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                /*
                SQLiteDatabase db = DBhelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(Database_estrucute.FeedEntry.CAMPO1id, reuser.getText().toString());
                values.put(Database_estrucute.FeedEntry.CAMPO2, recontra.getText().toString());

                long newRowId = db.insert(Database_estrucute.FeedEntry.TB_NAME,
                        null, values);


                 */

            }
        });




    }//END onCreate





    public  void  cuenta(View v){
        //Para ir a la iniciar sesion de la cuenta.
        Intent in = new Intent(this, MainActivityLogin.class);
        startActivity(in);
        finish();
    }
} //END ACTIVITY