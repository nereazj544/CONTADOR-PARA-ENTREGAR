package com.example.contador_para_entregar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.math.BigInteger;

public class MercazumaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercazuma);

        Intent intent = getIntent();
        String datoS = intent.getStringExtra("data");
        BigInteger data = new BigInteger(datoS);

    }
}