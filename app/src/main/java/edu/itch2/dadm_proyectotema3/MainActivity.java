package edu.itch2.dadm_proyectotema3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //DECLARAMOS VARIABLES PARA EL DISEÑO
    private Button btnActividad2, btnActividad3, btnSorpresa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INICIALIZAMOS VARIABLES DE DISEÑO
        btnActividad2 = findViewById(R.id.btnActividad2);
        btnActividad3 = findViewById(R.id.btnActividad3);
        btnSorpresa = findViewById(R.id.btnSorpresa);

        //HACEMOS EL ESCUCHADOR DEL BOTON btnActividad2 PARA QUE CUANDO SE DE CLIC SE ENVIE A LA SEGUNDA ACTIVIDAD
        btnActividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                //Toast.makeText(MainActivity.this, "Fuiste enviado a la actividad 2", Toast.LENGTH_SHORT).show();
            }
        });

        //HACEMOS EL ESCUCHADOR DEL BOTON btnActividad3 PARA QUE CUANDO SE DE CLIC SE ENVIE A LA TERCERA ACTIVIDAD
        btnActividad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
                //Toast.makeText(MainActivity.this, "Fuiste enviado a la actividad 3", Toast.LENGTH_SHORT).show();
            }
        });

        //HACEMOS EL ESCUCHADOR DEL BOTON btnSorpresa PARA QUE CUANDO SE DE CLIC SE ENVIE A LA ACTIVIDAD SORPRESA
        btnSorpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SorprecitaActivity.class);
                startActivity(intent);
                //Toast.makeText(MainActivity.this, "Fuiste enviado a la sorpresa", Toast.LENGTH_SHORT).show();
            }
        });
        
    }
}