package com.example.a02_controles_basicos;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    /*EditText nombre;
    EditText correo;
    EditText telefono;
    TextView resultado;
    Button boton;*/
    ToggleButton btnToggle;
    ImageButton btnImagen;
    TextView textoboton;
    Switch btnSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toglebutton);

        btnToggle=(ToggleButton) findViewById(R.id.BtnToggle);
        btnImagen=(ImageButton) findViewById(R.id.BtnImagen);
        textoboton=(TextView) findViewById(R.id.textoboton);
        btnSwitch= (Switch) findViewById(R.id.BtnSwitch);

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (btnToggle.isChecked())
                textoboton.setText("Boton encendido");
            else
                textoboton.setText("Boton apagado");
            }
        });
        btnImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnSwitch.isChecked())
                    textoboton.setText("Boton encendido");
                else
                    textoboton.setText("Boton apagado");
            }
        });


       /* nombre=findViewById(R.id.nombre);
        correo=findViewById(R.id.correo);
        telefono=findViewById(R.id.telf);
        resultado=findViewById(R.id.resultado);
        boton=findViewById(R.id.boton);

        Typeface letra=Typeface.createFromAsset(getAssets(),"fonts/Pacifico.ttf");

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(nombre.getText());
                resultado.append("\n");
                resultado.append(correo.getText());
                resultado.append("\n");
                resultado.append(telefono.getText());
                resultado.setTextColor(Color.WHITE);
                resultado.setTypeface(letra);
                resultado.setTextSize(30);

               InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(nombre.getWindowToken(),0);//PARA QUE EL TECLADO SE ESCONDA

            }
        });
       /* telefono.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionID, KeyEvent keyEvent) {
                if(actionID== EditorInfo.IME_ACTION_DONE) {
                    resultado.setText(nombre.getText());
                    resultado.append("\n");
                    resultado.append(correo.getText());
                    resultado.append("\n");
                    resultado.append(telefono.getText());
                    resultado.setTextColor(Color.WHITE);
                    resultado.setTypeface(letra);
                    resultado.setTextSize(30);
                }
                return false;
            }
        });
        //para concatenar todos los resultados escritos y ponerlo todo en el mismo textView
        */

    }

}
