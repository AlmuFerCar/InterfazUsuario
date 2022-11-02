package com.example.a03_activity_practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView resultadoA2;
    Button enviarA3, volver, nuevoA1;
    EditText textoA2;
    static final String TEXTO="TEXTO DE A2";
    static final int CODIGO_TEXTO=10;
    static final int CODIGO_NUEVO=15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        resultadoA2 = findViewById(R.id.resultadoA2);
        enviarA3 = findViewById(R.id.botonA2);
        volver= findViewById(R.id.botonvolver);
        nuevoA1=findViewById(R.id.nuevaA1);
        textoA2=findViewById(R.id.textoA2);

        Intent intent = getIntent();
        String mensaje= intent.getStringExtra(MainActivity.MESSAGE_TEXTOA1);
        resultadoA2.setText(mensaje);
        resultadoA2.setTextColor(Color.BLACK);
        resultadoA2.setTextSize(30);

        //boton de atras no modifica el texto -->igual que si pulsamos la tecla atrás
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volver();
            }
        });

        enviarA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarTextoA3();
            }
        });
        //LIMPIAMOS LA ACTIVIDAD A1
        nuevoA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevaActividad1();
            }
        });
    }

    public void volver()
    {
        MainActivity2.super.onBackPressed();
    }

    public void enviarTextoA3()
    {
        String dato2=textoA2.getText().toString();
        Intent intent = new Intent( this, MainActivity3.class);
        intent.putExtra(TEXTO, dato2);
       // setResult(CODIGO_TEXTO, intent);
        //MainActivity2.super.onBackPressed();
        startActivity(intent);
    }

    public void nuevaActividad1()
    {
        Intent intent = new Intent( this, MainActivity.class);
        intent.putExtra(TEXTO, "Voy de vuelta a A1 para limpiar");
        setResult(CODIGO_NUEVO, intent);
        MainActivity2.super.onBackPressed();
    }
}