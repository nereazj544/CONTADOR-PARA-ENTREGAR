package com.example.contador_para_entregar.Fondo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.contador_para_entregar.OpticonsActivity;
import com.example.contador_para_entregar.R;

public class FondoActivity extends AppCompatActivity {
    ImageView imagen;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fondo);

        imagen = (ImageView) findViewById(R.id.img);
    }

    //CAMBIAR EL PULSADOR DE LA IMAGEN

    int [] imgs = {R.drawable.shawn, R.drawable.hakuryuu, R.drawable.xavier,
            R.drawable.mh1, R.drawable.mh2, R.drawable.mh3,
            R.drawable.cmd1, R.drawable.cmd2, R.drawable.cmd3,
            R.drawable.gi1, R.drawable.gi2, R.drawable.gi3,
            R.drawable.lol1,R.drawable.lol2,R.drawable.lol3
    };
    int cont = 0;
    public void cambiar(View v){
        imagen.setImageResource(imgs[cont]);
        cont++;
        if (cont >= imgs.length){
            cont=0;
        }
    }

    public  void  volver(View v){
        Intent in = new Intent(this, OpticonsActivity.class);
        startActivity(in);
        finish();
    }
}