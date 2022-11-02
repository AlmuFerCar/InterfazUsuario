package com.example.a04_material_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Titular> datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);
        datos= new ArrayList<Titular>();

        for(int i=0; i<50; i++)
        {
            datos.add(new Titular("Titulo: "+i, "Subtitulo: "+i));
        }

        AdaptadorTitulares adaptadorTitulares = new AdaptadorTitulares(datos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adaptadorTitulares);
    }
}