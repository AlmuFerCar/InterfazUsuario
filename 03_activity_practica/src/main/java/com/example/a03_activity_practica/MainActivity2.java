package com.example.a03_activity_practica;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
    private static final String TAG = "RESULTADO";
    public static final String MESSAGE_TEXTO="Message";

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
    ActivityResultLauncher<Intent> activityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.d(TAG, ""+result.getResultCode());
                    switch (result.getResultCode()){
                        case MainActivity3.CODIGO_TEXTO:
                            Intent intent = result.getData();
                            resultadoA2.setText(intent.getStringExtra(MainActivity2.MESSAGE_TEXTO));
                            break;
                        case MainActivity3.CODIGO_NUEVO:
                            Intent intent3 = result.getData();
                            resultadoA2.setText("");
                            textoA2.setText("");
                            setResult(CODIGO_NUEVO, intent3);
                            MainActivity2.super.onBackPressed();
                            break;
                        case MainActivity3.CODIGO_A:
                            Intent intent2 = result.getData();
                            String msg= intent2.getStringExtra(MainActivity2.MESSAGE_TEXTO);
                            intent2.putExtra(MESSAGE_TEXTO, msg);
                            setResult(CODIGO_TEXTO, intent2);
                            MainActivity2.super.onBackPressed();
                            break;
                    }

                }
            }
    );

    public void volver()
    {
        MainActivity2.super.onBackPressed();
    }

    public void enviarTextoA3()
    {
        String dato2=textoA2.getText().toString();
        Intent intent = new Intent( this, MainActivity3.class);
        intent.putExtra(MESSAGE_TEXTO, dato2);
       // setResult(CODIGO_TEXTO, intent);
        //MainActivity2.super.onBackPressed();
        //startActivity(intent);
        activityResult.launch(intent);
    }

    public void nuevaActividad1()
    {
        Intent intent = new Intent( this, MainActivity.class);
        intent.putExtra(TEXTO, "Voy de vuelta a A1 para limpiar");
        setResult(CODIGO_NUEVO, intent);
        MainActivity2.super.onBackPressed();
    }

}