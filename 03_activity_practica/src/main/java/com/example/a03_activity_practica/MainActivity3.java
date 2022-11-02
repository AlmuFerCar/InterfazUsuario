package com.example.a03_activity_practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView resultadoA3;
    Button enviarA1, volver, nuevoA1;
    EditText textoA3;
    static final String TEXTOA3="TEXTO DE A3";
    static final int CODIGO_TEXTOA3=10;
    static final int CODIGO_NUEVOA3=15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        resultadoA3 = findViewById(R.id.resultadoA3);
        enviarA1 = findViewById(R.id.botonA3);
        volver= findViewById(R.id.botonvolver);
        nuevoA1=findViewById(R.id.botonnewA1);
        textoA3=findViewById(R.id.textoA3);

        Intent intent = getIntent();
        String mensaje= intent.getStringExtra(MainActivity2.TEXTO);
        resultadoA3.setText(mensaje);
        resultadoA3.setTextColor(Color.BLACK);
        resultadoA3.setTextSize(30);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volver();
            }
        });
        enviarA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarTextoA1();
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
        MainActivity3.super.onBackPressed();
    }
    public void enviarTextoA1()
    {
        String dato3=textoA3.getText().toString();
        Intent intent = new Intent( this, MainActivity3.class);
        intent.putExtra(TEXTOA3, dato3);
        setResult(CODIGO_TEXTOA3, intent);
        MainActivity3.super.onBackPressed();
    }

    public void nuevaActividad1()
    {
        Intent intent = new Intent( this, MainActivity.class);
        intent.putExtra(TEXTOA3, "Voy de vuelta a A1 para limpiar");
        setResult(CODIGO_NUEVOA3, intent);
        MainActivity3.super.onBackPressed();
    }
}