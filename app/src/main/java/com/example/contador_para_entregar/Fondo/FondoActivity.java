package com.example.contador_para_entregar.Fondo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.contador_para_entregar.OpticonsActivity;
import com.example.contador_para_entregar.R;

public class FondoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fondo);
    }

    //CAMBIAR EL PULSADOR DE LA IMAGEN
    /*
    int [] img = {R.drawable.shawn, R.drawable.hakuryuu, R.drawable.paolo, R.drawable.copia};
    int cont = 0;
    public void cambiar(View v){
        Kariya_Kirino.setImageResource(img[cont]);
        cont++;
        if (cont >= img.length){
            cont=0;
        }
    }
     */
    public  void  volver(View v){
        Intent in = new Intent(this, OpticonsActivity.class);
        startActivity(in);
        finish();
    }
}