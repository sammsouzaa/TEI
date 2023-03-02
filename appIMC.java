package com.example.appimc;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText pesoid, alturaid, idadeid;
    TextView resultadoid;
    Button buttonid;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesoid = findViewById(R.id.pesoid);
        alturaid = findViewById(R.id.alturaid);
        resultadoid = findViewById(R.id.resultadoid);

        idadeid = findViewById(R.id.idadeid);
        buttonid = findViewById(R.id.buttonid);

        buttonid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pesoDouble = Double.parseDouble(pesoid.getText().toString());
                double alturaDouble = Double.parseDouble(alturaid.getText().toString()) / 100.0;
                double imc;
                if (idadeid.getCheckedRadioButtonId() == R.id.adulto) {
                    imc = pesoDouble / (alturaDouble * alturaDouble);
                } else {
                    imc = 1.3 * pesoDouble / (alturaDouble * alturaDouble);
                }
                resultadoid.setText(String.format("Seu IMC é %.2f", imc));
                if (imc < 18.5) {
                    status.setText("Abaixo do peso");
                } else if (imc < 25) {
                    status.setText("Peso normal");
                } else {
                    status.setText("Acima do peso");
                }
            }
        });
    }}
