package com.example.interfazusuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText texto;
    Button botonreset;
    Button botonmas;
    Button botonmenos;
    Button botonmulti;
    Button botondivi;
    Button botoncero;
    Button botonuno;
    Button botondos;
    Button botontres;
    Button botoncuatro;
    Button botoncinco;
    Button botonseis;
    Button botonsiete;
    int num1;
    int num2;
    int operacion;//1 suma, 2 resta, 3 multi, 4 divi
    int resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);
        texto=findViewById(R.id.resultado);
        botonreset=findViewById(R.id.buttonreset);
        botonmas=findViewById(R.id.buttonsuma);
        botonmenos=findViewById(R.id.buttonresta);
        botonmulti=findViewById(R.id.buttonmulti);
        botondivi=findViewById(R.id.buttondiv);

        botonseis.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                num1 = 6;
            }
         });

        botondos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num2=2;
            }
        });

         botonmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion=1;
            }
        });
         botonmenos.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 operacion=2;
             }
         });
         botonmulti.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 operacion=3;
             }
         });
         botondivi.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 operacion=4;
             }
         });
         switch (operacion){
             case 1:
                 resultado=num1+num2;
                 texto.setText(resultado+"");
                 break;
             case 2:
                 resultado=num1-num2;
                 texto.setText(resultado+"");
             break;
             case 3:
                 resultado=num1*num2;
                 texto.setText(resultado+"");
                 break;
             default:
                 resultado=(int)num1/num2;
                 texto.setText(resultado+"");
                 break;
         }

    }
}