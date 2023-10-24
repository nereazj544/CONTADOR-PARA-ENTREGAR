package com.example.contador_para_entregar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;

public class MercazumaActivity extends AppCompatActivity {
    TextView numerocont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercazuma);


        Intent intent = getIntent();
        Bundle datum = intent.getExtras();

        numerocont = (TextView) findViewById(R.id.puntosclicks);
        Button Aumentar = findViewById(R.id.aumentar);
        Button Multiplicar = findViewById(R.id.multiply);
        Button AC = findViewById(R.id.AutoC);

       if (datum.isEmpty()){
           //Datos que se recogeran de la base de datos interna del dispositivo.
       } else{
           String numero = datum.getString("data");
           numerocont.setText("Tus puntos de Pasión y Amistad: " + numero);

           String valorT = datum.getString("valor");
           String costoT = datum.getString("costo");
           String AcostT = datum.getString("AClik");
           String cotoTM = datum.getString("costo_mu");

           BigInteger valor = new BigInteger(valorT);
           BigInteger costo = new BigInteger(costoT);
           BigInteger costoM = new BigInteger(cotoTM);
           int ACost = Integer.parseInt(AcostT);

           //BOTONES
           Aumentar.setText("Aumentar costo: " + costo);
           Multiplicar.setText("Multiplicar costo: " + costoM);
           AC.setText("AutoClick costo: " + AcostT);

       }
    }

    public void volver(View v){
        Intent intent = new Intent();
        intent.putExtra("data", numerocont.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
        /*
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
         */
    }





    //END APP
}