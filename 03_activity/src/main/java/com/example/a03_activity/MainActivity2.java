package com.example.a03_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView resultado;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        resultado=findViewById(R.id.resultado);


        Intent intent2=getIntent();
        Bundle b= intent2.getExtras();
        Persona p=(Persona) b.getSerializable(MainActivity.PERSONA);

        resultado.setText (p.getNombre()+"\n");
        resultado.append (p.getEdad()+"\n");
        resultado.append (p.getSexo()+"\n");
        resultado.append (p.getProf()+"\n");


        for(i=0; i<p.getHob().length; i++)
        {
                resultado.append(p.getHob()[i]+"\n");
        }


        //resultado.setText(intent2.getStringExtra(MainActivity.MESSAGE_NOMBRE));
       // resultado.append(intent2.getStringExtra(MainActivity.MESSAGE_EDAD));


    }
}