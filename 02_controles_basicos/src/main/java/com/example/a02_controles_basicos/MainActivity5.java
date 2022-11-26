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
import android.widget.CompoundButton;
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
    String aux1="",aux2="", aux3="";
    int i=0;


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

        op4.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    aux1=op4.getText().toString();
                }
                else
                {
                    aux1=" ";
                }
                i++;
            }
        });
        op5.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    aux2=op5.getText().toString();
                    //cadena=cadena+(" "+op5.getText()+" ");
                }
                else
                {
                    aux2=" ";
                }
                i++;
            }
        });
        op6.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    aux3=op6.getText().toString();
                    //cadena=cadena+(" "+op6.getText()+" ");
                }
                else
                {
                    aux3=" ";
                }
            }
        });

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
        boton_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("Tu nombres es "+nombre.getText()+" con edad "+edad.getText()+" y tu sexo es "+dato);
                resultado.append("\n");
                valor=spinner.getSelectedItem().toString();
                resultado.append("Tu profesion es: "+valor);
                resultado.append("\n");
                resultado.append("Tus hobbies son: "+aux1+" "+aux2+" "+aux3);
                resultado.setTextSize(20);

                InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(nombre.getWindowToken(),0);//PARA QUE EL TECLADO SE ESCONDA

            }
        });
        boton_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("");
                nombre.setText("");
                edad.setText("");
                grupo.clearCheck();
                spinner.setSelection(0);
                op4.setChecked(false);
                op5.setChecked(false);
                op6.setChecked(false);

                InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(nombre.getWindowToken(),0);//PARA QUE EL TECLADO SE ESCONDA

            }
        });



    }

}
