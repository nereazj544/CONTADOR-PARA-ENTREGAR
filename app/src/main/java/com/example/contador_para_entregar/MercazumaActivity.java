package com.example.contador_para_entregar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.math.BigInteger;

public class MercazumaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercazuma);

        Intent intent = getIntent();
       Bundle datum = intent.getExtras();

       if (datum != null){
           String valorT = datum.getString("valor");
           String costoT = datum.getString("costo");
           String AcostT = datum.getString("AClik");

           BigInteger valor = new BigInteger(valorT);
           BigInteger costo = new BigInteger(costoT);
          int ACost = Integer.parseInt(AcostT);

           Button Aumentar = findViewById(R.id.aumentar);
           Button Multiplicar = findViewById(R.id.multiply);
           Button AC = findViewById(R.id.AutoC);

           Aumentar.setText("Aumentar costo: " + costo);
           Multiplicar.setText("Multiplicar costo: " + costo);
           AC.setText("AutoClick costo: " + costo);

       }
       



    }





    //END APP
}