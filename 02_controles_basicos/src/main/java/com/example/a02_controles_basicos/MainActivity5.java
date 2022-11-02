package com.example.a02_controles_basicos;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    EditText nombre;
    EditText edad;
    TextView resultado;
    Spinner spinner;
    String valor, dato;
    RadioGroup grupo;
    RadioButton op1, op2, op3;
    CheckBox op4, op5, op6;
    Button boton_send, boton_clear;
    int seleccion=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practica_botones);

        spinner=findViewById(R.id.spinner2);
        resultado=findViewById(R.id.resultado);
        nombre=findViewById(R.id.nombre);
        edad=findViewById(R.id.edad);
        grupo=findViewById(R.id.grupo);
        op1=findViewById(R.id.mujer);
        op2=findViewById(R.id.hombre);
        op3=findViewById(R.id.otro);
        op4=findViewById(R.id.baloncesto);
        op5=findViewById(R.id.malabares);
        op6=findViewById(R.id.teatro);
        boton_send=findViewById(R.id.botonsend);
        boton_clear=findViewById(R.id.botonclear);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.valoreswork,
                android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                valor=spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        boton_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("Tu nombres es "+nombre.getText()+" con edad "+edad.getText()+" y tu sexo es ");

                grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        seleccion=grupo.getCheckedRadioButtonId();

                        switch (seleccion)
                        {
                            case R.id.mujer:
                            {
                                dato=op1.getText().toString();
                                break;
                            }
                            case R.id.hombre:
                            {
                                dato=op2.getText().toString();
                                break;
                            }
                            case R.id.otro:
                            {
                                dato=op3.getText().toString();
                                break;
                            }
                        }
                    }
                });
                resultado.setText("Tu nombres es "+nombre.getText()+" con edad "+edad.getText()+" y tu sexo es "+dato);
                resultado.append("\n");
                valor=spinner.getSelectedItem().toString();
                resultado.append("Tu profesion es: "+valor);
                resultado.setTextSize(30);

                InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(nombre.getWindowToken(),0);//PARA QUE EL TECLADO SE ESCONDA

            }
        });

    }

}
