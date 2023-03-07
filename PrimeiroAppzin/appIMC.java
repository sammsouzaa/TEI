package com.example.appimc;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText idadeid, pesoid, alturaid;
    private TextView resultadoid;
    private Button buttonid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idadeid = findViewById(R.id.idadeid);
        pesoid = findViewById(R.id.pesoid);
        alturaid = findViewById(R.id.alturaid);
        resultadoid = findViewById(R.id.resultadoid);
        buttonid = findViewById(R.id.buttonid);

        buttonid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //obtém a idade, o peso e a altura digitados pelo usuário
                int idade = Integer.parseInt(idadeid.getText().toString());
                double peso = Double.parseDouble(pesoid.getText().toString());
                double altura = Double.parseDouble(alturaid.getText().toString());

                //calcula o IMC
                double imc = peso / (altura * altura);

                //exibe o resultado na tela
                resultadoid.setText("Seu IMC é: " + String.format("%.2f", imc));

                //verifica se é adulto ou idoso e aplica as especificações de acordo com a idade

                if (idade <= 65) {
                    if (imc < 18.5) {
                        resultadoid.append("\nBaixo peso");}
                    if (imc >= 18.5 & imc <= 24.9 ) {
                         resultadoid.append("\nPeso normal");}
                    if (imc >= 25 & imc <= 29.9) {
                        resultadoid.append("\nExcesso de peso");}
                    if (imc >= 30 & imc <= 34.9) {
                        resultadoid.append("\nObesidade de classe 1");}
                    if (imc >= 35 & imc <= 39.9) {
                        resultadoid.append("\nObesidade de classe 2");}
                    else {
                        resultadoid.append("\nObesidade de classe 3");
                    }

                } else {
                    if (imc <= 22) {
                        resultadoid.append("\nBaixo peso");}
                    if (imc > 22 & imc < 27) {
                        resultadoid.append("\nAdequado ou eutrófico\n");}
                    else {
                        resultadoid.append("\nAlto peso para idosos");
                    }
                }
            }
        });
    }
}
