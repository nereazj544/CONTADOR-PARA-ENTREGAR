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
                new Equipos("Royal Academy", R.drawable.royalacademy),
                new Equipos("Raimon", R.drawable.raimon),
                new Equipos("Luz Eterna", R.drawable.Escudo_Luz_Eterna),
                new Equipos("Inazuma Battel Eleven", R.drawable.Inazuma_Battle_Eleven_Emblema),
                new Equipos("Inazuma Best Eleven", R.drawable.Inazuma_Best_Eleven_Emblema),
                new Equipos("Equipo Zero", R.drawable.Equipo_Zero_Emblema),
                new Equipos("Equipo Ogre", R.drawable.Ogro),
                new Equipos("Instituto Zeus", R.drawable.Escudo_Zeus_FF),
                new Equipos("Instituto Universal", R.drawable.Universal_Emblema),
                new Equipos("Resistencia de Japon", R.drawable.Resistencia_Jap_Logo),
                new Equipos("Dragones de Fuego", R.drawable.Dragones_de_Fuego_Emblema),
                new Equipos("Namuhara", R.drawable.Nagumohara),
                new Equipos("Earth Eleven", R.drawable.Earth_Eleven_Emblema),
                new Equipos("Inazuma Japon", R.drawable.inazuma_japon),
                new Equipos("The Little Gigants", R.drawable.little_gigants),
                new Equipos("Instituto Occult", R.drawable.Occult_Emblema),
                new Equipos("Unicorn", R.drawable.Unicorn_Emblema),
                new Equipos("Aullido Lunar", R.drawable.Aullido_Lunar_Emblema)
        );
        rv.setAdapter(new EquipoAdarer(l));

    }
}