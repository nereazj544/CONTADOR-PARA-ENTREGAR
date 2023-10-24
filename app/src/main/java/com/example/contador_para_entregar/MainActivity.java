package com.example.contador_para_entregar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    TextView contador;
    Button boton;
    Button boton_multiplicacion;
    Button boton_resetear;
    ImageView Kariya_Kirino;
    Button boton_AutoClick;
    int auto = 1;
    //Para un valor concreto: int num = 95;
    //Y despues en el protected void se pone: contador.setText(""+num);

    /* //Esto es con Int:
    int num = 999; int valor=1; int costo= 100; int costo_multiplicacion=1000;
    */
    //Esto es con BigInteger
    BigInteger num = BigInteger.ZERO;
    BigInteger valor = BigInteger.ONE;
    BigInteger costo = new BigInteger("100");
    BigInteger costo_multiplicacion = new BigInteger("1000");
    /*Para no complicarse la vida con los ceros :) */
    BigInteger mil = new BigInteger("1000");
    BigInteger millon = new BigInteger("1000000");
    BigInteger billon = new BigInteger("1000000000");

    //AutoClick
    BigInteger ACcost = new BigInteger("10");
    int automatico = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador=(TextView) findViewById(R.id.textocontador);
        contador.setText(num.toString());
        Kariya_Kirino = (ImageView) findViewById(R.id.Kariya_Kirino);
        boton_resetear = (Button) findViewById(R.id.restear);
        boton_AutoClick = (Button) findViewById(R.id.AutoClicker);
        //boton_multiplicacion = (Button) findViewById(R.id.multiplicar);
        //boton = (Button) findViewById (R.id.button1);

    }

    //IR A OTRAS PAGINAS
    public  void  volver(View v){
        //Esto va a ir a la otra pantalla
        Intent in = new Intent(this, PantallaActivity.class);
        startActivity(in);
        finish();
    }
    public  void  shop(View v){
        Intent mercazuma = new Intent(this, MercazumaActivity.class);
        mercazuma.putExtra("data", num.toString());
        startActivity(mercazuma);
    }


    //CONTADOR + ANIMACION
    public void sumar(View v){
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(100);
        Kariya_Kirino.startAnimation(fade_in);
        num= num.add(valor);
        contador.setText(NumeroFormato(num));
        /* //Esto era cuando se encontraba aqui este metodo, antes de hacer el autoclick
        if (num.compareTo(mil) >= 0 && num.compareTo(millon) < 0){
            contador.setText(num.divide(mil) + "Mil");
        } else if (num.compareTo(millon) >= 0 && num.compareTo(billon) < 0){
            contador.setText(num.divide(millon) + "M");
        } else if (num.compareTo(billon) >= 0) {
            contador.setText(num.divide(billon) + "B");
        }
        */
       /*  //ESTO ES CON INT
       if(num >= 1000 && num < 1000000){
           contador.setText(Double.toString(num/1000d).substring(0,3) + "Mil");
       } else if (num >= 1000000 && num< 1000000000 ) {
           contador.setText(Double.toString(num/1_000_000d).substring(0,4) + "M");
       } else if (num >= 1000_000_000){
           contador.setText(Double.toString(num/1000_000_000d).substring(0,4) + "K");
       }else{
           contador.setText(Integer.toString(num));
       }
       //return 0;
        */
    }


    //MEJORAS EN EL JUEGO
    public String NumeroFormato(BigInteger val) {
        String foVal = "";
        if (val.compareTo(mil) >= 0 && val.compareTo(millon) < 0) {
            foVal = val.divide(mil) + "Mil";
            contador.setTextColor(Color.RED);
        } else if (val.compareTo(millon) >= 0 && val.compareTo(billon) < 0) {
            foVal = val.divide(millon) + "M";
            contador.setTextColor(Color.GREEN);
        } else if (val.compareTo(billon) >= 0) {
            foVal = val.divide(billon) + "B";
            contador.setTextColor(Color.CYAN);
        } else {
            foVal = val.toString();
        }
        return foVal;
    }
    public void mejora(View v) {
        if (num.compareTo(new BigInteger("100")) >= 0) {
            num = num.subtract(costo);
            valor = valor.add(new BigInteger("1"));
            contador.setText(NumeroFormato(num));
            costo = costo.add(new BigInteger("20"));
            boton.setText("Coste: " + costo);
        }
    }
    public void multiplicador (View v){
        if(num.compareTo(new BigInteger("1000")) >=0){
            num=num.subtract(new BigInteger("1000"));
            valor= valor.multiply(new BigInteger("2"));
            costo_multiplicacion = costo_multiplicacion.add(new BigInteger("20")) ;
            boton_multiplicacion.setText("Coste multiplicación (x2): " + costo_multiplicacion);

        }
    }
    public void rest(View v){
        num = new BigInteger("0");
        contador.setText(num.toString());
        contador.setTextColor(Color.WHITE);
    }

//AUTOCLICK
    public  void autoclick(View v){
        if (num.compareTo(new BigInteger("10")) >= 0){
            num = num.subtract(new BigInteger("10"));
            valor = valor.add(new BigInteger("10"));
            contador.setText(NumeroFormato(num));
            ACcost = ACcost.add(new BigInteger("10"));
            boton_AutoClick.setText("AutoClick coste: " + ACcost);
            AutoClick();

        }
    }

    public void AutoClick(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            while(true){
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
                num= num.add(BigInteger.valueOf(auto));
                //Background work here
                handler.post(() -> {
                    //UI Thread work here
                    ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    fade_in.setDuration(100);
                    Kariya_Kirino.startAnimation(fade_in);
                    contador.setText(NumeroFormato(num));


                });}
        });

    }
}
