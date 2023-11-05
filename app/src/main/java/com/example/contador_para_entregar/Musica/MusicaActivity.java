package com.example.contador_para_entregar.Musica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.contador_para_entregar.InformacionActivity;
import com.example.contador_para_entregar.OpticonsActivity;
import com.example.contador_para_entregar.R;

public class MusicaActivity extends AppCompatActivity {
    public class MainActivity extends AppCompatActivity {

        Button buttonIE;
        Button buttonMonster;
        Button buttonLol;

        // Declarar variable para el reproductor de música
        private MediaPlayer mediaPlayer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_musica);


            // Obtener referencias a los botones
            buttonIE = findViewById(R.id.ie);
            buttonMonster = findViewById(R.id.monster);
            buttonLol = findViewById(R.id.lol);

            // Asignar OnClickListener a los botones
            buttonIE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Reproducir música correspondiente al botón "IE"
                    playMusic(R.raw.ieopg);
                }
            });

            buttonMonster.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Reproducir música correspondiente al botón "Monster"
                    playMusic(R.raw.monsterhigh);
                }
            });

            buttonLol.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Reproducir música correspondiente al botón "LOL"
                    playMusic(R.raw.paranoia);
                }
            });
        }

        // Método para reproducir música
        private void playMusic(int musicResId) {
            // Detener la reproducción si ya se está reproduciendo música
            stopMusic();

            // Crear y configurar el reproductor de música
            mediaPlayer = MediaPlayer.create(this, musicResId);
            mediaPlayer.start(); // Iniciar la reproducción
        }

        // Método para detener la reproducción de música
        private void stopMusic() {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop(); // Detener la reproducción
                mediaPlayer.release(); // Liberar recursos
                mediaPlayer = null;
            }
        }

        public  void  atras(View v){
            Intent at = new Intent(this, OpticonsActivity.class);
            startActivity(at);
        }
    }

}