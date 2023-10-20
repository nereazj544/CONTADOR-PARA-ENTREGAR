package com.example.contador_para_entregar.PracticasGuiadas.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.contador_para_entregar.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Personajes[] personajes = new Personajes[]{
                new Personajes("Shawn Froste", "Alpino", R.drawable.shawn),

        };

        PersonajeAdapter adapter = new PersonajeAdapter(this, R.layout.listapersonaje, Arrays.asList(personajes));
        setListAdapter(adapter);

        ListView listView = getListView();
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Personajes personaje = (Personajes) adapterView.getItemAtPosition(position);
        String nombre = personaje.getNombre();
        Toast.makeText(this, nombre, Toast.LENGTH_LONG).show();
    }
}
