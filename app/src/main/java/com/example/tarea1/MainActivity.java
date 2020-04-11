package com.example.tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nota1;
    private EditText nota2;
    private EditText nota3;
    private EditText nota4;
    private TextView promedio;
    private TextView notaPromedio;
    private Button enviar;
    private double calculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota1 = (EditText)findViewById(R.id.txtnota1);
        nota2 = (EditText)findViewById(R.id.txtnota2);
        nota3 = (EditText)findViewById(R.id.txtnota3);
        nota4 = (EditText)findViewById(R.id.txtnota4);
        promedio = (TextView)findViewById(R.id.lblpromedio);
        notaPromedio = (TextView)findViewById(R.id.lblnotapromedio);
        enviar = (Button)findViewById(R.id.btnenviar);

        nota1.requestFocus();
        promedio.setVisibility(View.INVISIBLE);
        notaPromedio.setVisibility(View.INVISIBLE);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                calculo = (Double.parseDouble(nota1.getText().toString()) + Double.parseDouble(nota2.getText().toString())
                        + Double.parseDouble(nota3.getText().toString()) + Double.parseDouble(nota4.getText().toString())) / 4;

                notaPromedio.setText(String.valueOf(calculo));

                promedio.setVisibility(View.VISIBLE);
                notaPromedio.setVisibility(View.VISIBLE);

                if(calculo >= 3.0 && calculo <= 5.0)
                {
                    Toast.makeText(MainActivity.this, "Aprobó la materia", Toast.LENGTH_LONG).show();
                }
                else if(calculo >= 0 && calculo <= 2.9)
                {
                    Toast.makeText(MainActivity.this, "Reprobo la materia", Toast.LENGTH_LONG).show();
                }
                else
                {
                    promedio.setVisibility(View.INVISIBLE);
                    notaPromedio.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "Datos ingresados incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
