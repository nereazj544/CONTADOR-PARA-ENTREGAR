package com.example.contador_para_entregar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        if (id == R.id.item1) {
            Toast.makeText(this, "Opcion 1", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item2) {
            Toast.makeText(this, "opcion 2", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}