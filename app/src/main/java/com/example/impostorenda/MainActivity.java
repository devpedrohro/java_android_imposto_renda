package com.example.impostorenda;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText contribuinte;
    private EditText base;
    private Button calcular;
    private TextView ir;
    private LinearLayout primeiro, segundo, terceiro, quarto, quinto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contribuinte = findViewById(R.id.edtContribuinte);
        base = findViewById(R.id.edtBase);
        calcular = findViewById(R.id.btnCalcular);
        ir = findViewById(R.id.txvIR);

        primeiro = findViewById(R.id.lnlPrimeiro);
        segundo = findViewById(R.id.lnlSegundo);
        terceiro = findViewById(R.id.lnlTerceiro);
        quarto = findViewById(R.id.lnlQuarto);
        quinto = findViewById(R.id.lnlQuinto);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular(base.getText().toString());
            }
        });
    }

    public void calcular(String base){
        double valorBase = Double.parseDouble(base);
        double calculo;
        limpar();

        if(valorBase <= 1903.98){
            calculo = 0;
            primeiro.setBackgroundColor(getResources().getColor(R.color.colorCaixa));
        } else if(valorBase <= 2826.65){
            calculo = (valorBase * 7.5/100) - 142.8;
            segundo.setBackgroundColor(getResources().getColor(R.color.colorCaixa));
        } else if(valorBase <= 3751.05){
            calculo = (valorBase * 15/100) - 354.8;
            terceiro.setBackgroundColor(getResources().getColor(R.color.colorCaixa));
        } else if(valorBase <= 4664.68){
            calculo = (valorBase * 22.5/100) - 636.13;
            quarto.setBackgroundColor(getResources().getColor(R.color.colorCaixa));
        } else {
            calculo = (valorBase * 27.5 / 100) - 869.36;
            quinto.setBackgroundColor(getResources().getColor(R.color.colorCaixa));
        }

        if (valorBase > 0)
            ir.setText("IR: PAGAR " + calculo);
        else
            ir.setText("IR: RECEBER " + Math.abs(calculo));
    }

    public void limpar(){
        primeiro.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        segundo.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        terceiro.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        quarto.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        quinto.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        contribuinte.setText(null);
        base.setText(null);
        contribuinte.requestFocus();
    }
}
