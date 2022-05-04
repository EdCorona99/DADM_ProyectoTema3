package edu.itch2.dadm_proyectotema3;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class SorprecitaActivity extends AppCompatActivity {

    //DECLARAMOS LAS VARIABLES DE LA PARTE DE DISEÑO
    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorprecita);

        //INICIALIZAMOS LAS VARIABLES DEL APARTADO DE DISEÑO
        //btnPlay = findViewById(R.id.btnPlay);
        //btnPause = findViewById(R.id.btnPause);
        //btnStop = findViewById(R.id.btnStop);
        //VideoView video = (VideoView) findViewById(R.id.videoView);

        video = findViewById(R.id.videoView);


        //ENVIAMOS LA RUTA DEL VIDEO PARA QUE PUEDA REPRODUCIRSE
        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sorpresita));

        //INICIALIZAMOS LOS CONTROLES DEL VIDEO
        MediaController mc = new MediaController(this);

        //LE ASIGNAMOS LOS CONTROLES A NUESTRO VIDEO
        video.setMediaController(mc);
        mc.setAnchorView(video);

        //REPRODUCIMOS NUESTRO VIDEO
        video.start();
    }
}