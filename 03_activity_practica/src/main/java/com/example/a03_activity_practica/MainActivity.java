package com.example.a03_activity_practica;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
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


public class MainActivity extends AppCompatActivity
{
    TextView resultadoA1;
    EditText textoA1;
    Button botonA1, botonSalir;
    static String MESSAGE_TEXTOA1;
    private static final String TAG="RESULTADO";

    ActivityResultLauncher<Intent> activityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.d(TAG,""+result.getResultCode());
                    int code =result.getResultCode();
                    switch (code)
                    {
                        case RESULT_CANCELED:
                            Log.d(TAG, "Vuelve cancelado");
                            break;

                        case MainActivity3.CODIGO_TEXTO:
                            Log.d(TAG, "Vuelve con codigo, buscar intent");
                            Intent intent = result.getData();
                            String mensaje= intent.getStringExtra(MainActivity3.MESSAGE_TEXTO);
                            resultadoA1.setText(mensaje);
                            resultadoA1.setTextColor(Color.BLACK);
                            resultadoA1.setTextSize(30);
                            break;

                        case MainActivity2.CODIGO_NUEVO:
                            Log.d(TAG, "Limpiar texto");
                            resultadoA1.setText("");
                            textoA1.setText("");
                            break;
                        case MainActivity3.CODIGO_NUEVO:
                            Log.d(TAG, "Limpiar texto");
                            resultadoA1.setText("");
                            textoA1.setText("");
                            break;

                    }
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoA1=findViewById(R.id.textoA1);
        botonA1=findViewById(R.id.botonA1);
        resultadoA1=findViewById(R.id.resultadoA1);
        botonSalir= findViewById(R.id.botonSalir);


        botonA1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                enviarMensajeA2();
            }
        });
    }

    public void enviarMensajeA2()
    {
        String dato=textoA1.getText().toString();
        Intent intent=new Intent(this, MainActivity2.class);
        intent.putExtra(MESSAGE_TEXTOA1, dato);
        activityResult.launch(intent);
        //antes:
        //startActivity(intent);
    }




}