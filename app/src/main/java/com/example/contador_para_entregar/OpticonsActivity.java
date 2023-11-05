package com.example.contador_para_entregar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contador_para_entregar.MH.MonsterhighActivity;

public class OpticonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opticons);

        TextView textView = findViewById(R.id.text_view);

        registerForContextMenu(textView);
    }
    public  void  volver(View v){
        Intent in = new Intent(this, PantallaActivity.class);
        startActivity(in);
        finish();
    }

    //OPCIONES
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose your option");
        getMenuInflater().inflate(R.menu.men, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        /*
        if (id == R.id.item1) {
        // Acción para la opción 1
        Intent intent = new Intent(this, OtroActivity.class);
        startActivity(intent);
    } else if (id == R.id.item2) {
        // Acción para la opción 2
        Intent intent = new Intent(this, OtroActivity.class);
        startActivity(intent);
    }
    return super.onOptionsItemSelected(item);
         */
        if (id == R.id.item1) {
            Toast.makeText(this, "Monster High", Toast.LENGTH_SHORT).show();
            Intent monsterhigh = new Intent(this, MonsterhighActivity.class);
            startActivity(monsterhigh);
        } else if (id == R.id.item2) {
            Toast.makeText(this, "Cambien Wallpaper", Toast.LENGTH_SHORT).show();

        }else if(id == R.id.item3){
            Toast.makeText(this, "Musica :)", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}