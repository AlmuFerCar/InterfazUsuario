package com.example.a02_controles_basicos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity2 extends AppCompatActivity {
    //CheckBox op1, op2, op3, op4;

   // TextView resultado;
   RadioGroup grupo;
    TextView resultado;
    RadioButton op1, op2, op3, op4;
    int select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobutton);
        grupo=findViewById(R.id.grupo);
        resultado=findViewById(R.id.textobox);
        op1=findViewById(R.id.tenis);
        op2=findViewById(R.id.ajedrez);
        op3=findViewById(R.id.baloncesto);
        op4=findViewById(R.id.natacion);

        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                select =grupo.getCheckedRadioButtonId();
                switch (select)
                {
                    case R.id.tenis:
                    {
                        resultado.setText(op1.getText());
                        break;
                    }
                    case R.id.ajedrez:
                    {
                        resultado.setText(op2.getText());
                        break;
                    }
                    case R.id.baloncesto:
                    {
                        resultado.setText(op3.getText());
                        break;
                    }
                    case R.id.natacion:
                    {
                        resultado.setText(op4.getText());
                        break;
                    }
                }
            }
        });
        /*op1=findViewById(R.id.tenis);
        op2=findViewById(R.id.ajedrez);
        op3=findViewById(R.id.baloncesto);
        op4=findViewById(R.id.natatacion);
        resultado=findViewById(R.id.textobox);
        op1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    resultado.append(op1.getText() + "\n");
                }
            }
        });
        op2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    resultado.append(op2.getText() + "\n");
                }
            }
        });
        op3.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    resultado.append(op3.getText() + "\n");
                }
            }
        });
        op4.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    resultado.append(op4.getText() + "\n");
                }
            }
        });*/


    }

}
