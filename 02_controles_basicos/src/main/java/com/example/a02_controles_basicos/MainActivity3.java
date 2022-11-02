package com.example.a02_controles_basicos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    //CheckBox op1, op2, op3, op4;

   // TextView resultado;
    RadioGroup grupo;
    TextView resultado;
    RadioButton op1, op2;
    int select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobutton_v2);
        grupo=findViewById(R.id.grupo);
        resultado=findViewById(R.id.textobox);
        op1=findViewById(R.id.verdadero);
        op2=findViewById(R.id.falso);

        String textoFijo=resultado.getText().toString();
        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                select =grupo.getCheckedRadioButtonId();

                switch (select)
                {
                    case R.id.verdadero:
                    {
                        resultado.setText(textoFijo+": "+op1.getText());
                        break;
                    }
                    case R.id.falso:
                    {
                        resultado.setText(textoFijo+": "+op2.getText());
                        break;
                    }
                }
            }
        });
    }

}
