package com.example.contador_para_entregar.PracticasGuiadas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.contador_para_entregar.R;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RecyclerView rv = (RecyclerView) findViewById(R.id.itemlist);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<Equipos> l = Arrays.asList(
                new Equipos("Alpino", R.drawable.alpino),
                new Equipos("Royal Academy", R.drawable.alpino),
                new Equipos("Raimon", R.drawable.alpino),
                new Equipos("Luz Eterna", R.drawable.alpino),
                new Equipos("Inazuma Battel Eleven", R.drawable.alpino),
                new Equipos("Inazuma Best Eleven", R.drawable.alpino),
                new Equipos("Equipo Zero", R.drawable.alpino),
                new Equipos("Equipo Ogre", R.drawable.alpino),
                new Equipos("Instituto Zeus", R.drawable.alpino),
                new Equipos("Instituto Universal", R.drawable.alpino),
                new Equipos("Resistencia de Japon", R.drawable.alpino),
                new Equipos("Dragones de Fuego", R.drawable.alpino),
                new Equipos("Namuhara", R.drawable.alpino),
                new Equipos("Earth Eleven", R.drawable.alpino),
                new Equipos("Inazuma Japon", R.drawable.alpino),
                new Equipos("The Little Gigants", R.drawable.alpino),
                new Equipos("Instituto Occult", R.drawable.alpino),
                new Equipos("Unicorn", R.drawable.alpino)
        );
        rv.setAdapter(new EquipoAdarer(l));

    }
}