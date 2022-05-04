package edu.itch2.dadm_proyectotema3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();
    }

    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement("#775447", "Pedro", "México", "Activo"));
        elements.add(new ListElement("#762390", "Julio", "Tabasco", "Activo"));
        elements.add(new ListElement("#239812", "Alejandra", "Chihuahua", "Cancelado"));
        elements.add(new ListElement("#237854", "Jessica", "Durango", "Inactivo"));
        elements.add(new ListElement("#129845", "Armando", "Yucatan", "Activo"));
        elements.add(new ListElement("#317634", "Fernando", "Tijuana", "Cancelado"));
        elements.add(new ListElement("#328795", "Eduardo", "Chihuahua", "Activo"));
        elements.add(new ListElement("#348723", "Isaac", "Jalisco", "Inactivo"));
        elements.add(new ListElement("#549824", "Bryan", "Monterrey", "Activo"));
        elements.add(new ListElement("#328735", "Jaime", "Guadalajara", "Cancelado"));
        elements.add(new ListElement("#329853", "Enrique", "Chihuahua", "Activo"));
        elements.add(new ListElement("#982333", "Jesus", "Cuahutemoc", "Activo"));
        elements.add(new ListElement("#387342", "Georgina", "Monterrey", "Activo"));
        elements.add(new ListElement("#359843", "Ernesto", "Jalisco", "Inactivo"));
        elements.add(new ListElement("#198348", "Francisco", "Hermosillo", "Cancelado"));

        ListAdapter listAdapter = new ListAdapter(elements, this);

        RecyclerView recyclerView = findViewById(R.id.ListRecyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(listAdapter);
    }

}