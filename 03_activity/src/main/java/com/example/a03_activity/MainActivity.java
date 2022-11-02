package com.example.a03_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    EditText edad;
    Spinner spinner;
    String valor, dato, cadena="";
    String aux1="",aux2="", aux3="";
    RadioGroup grupo;
    RadioButton op1, op2, op3;
    CheckBox op4, op5, op6;
    Button boton_send, boton_clear;
    int i=0;
    static String MESSAGE_NOMBRE, TAG, MESSAGE_EDAD, PERSONA,  MESSAGE_SEXO, MESSAGE_PROFESION, MESSAGE_HOBBIES;
    int seleccion=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d(TAG, "Estoy dentro de onCreate");
        spinner=findViewById(R.id.spinner2);
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
                paginaSiguiente();
            }
        });
    }


    public void paginaSiguiente()
    {

        String nombreC=nombre.getText().toString();
        String edadC=edad.getText().toString();
        String sexoC=dato;
        String profesionC=valor;
        String [] aficionesC= {aux1, aux2, aux3};
        Persona p= new Persona(nombreC, edadC, sexoC, profesionC, aficionesC);
        Bundle b=new Bundle();
        b.putSerializable(PERSONA, p);

        Intent intent=new Intent(this, MainActivity2.class);
        intent.putExtras(b);

        startActivity(intent);
    }

      //  String sexoC=dato;
      //  String profesionC=valor;
       // String hobbiesC=cadena;

       // intent.putExtra(MESSAGE_NOMBRE, nombreC);

       // intent.putExtra(MESSAGE_EDAD, edadC);
       // intent.putExtra(MESSAGE_SEXO, sexoC);
      //  intent.putExtra(MESSAGE_PROFESION,profesionC);
       // intent.putExtra(MESSAGE_HOBBIES,hobbiesC);




       /* @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(TAG, "Estoy dentro de onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Estoy dentro de onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Estoy dentro de onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Estoy dentro de onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Estoy dentro de onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Estoy dentro de onDestroy");
    }*/
}
