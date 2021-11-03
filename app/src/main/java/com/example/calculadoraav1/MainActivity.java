package com.example.calculadoraav1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    EditText av1, av2, av3;
    TextView textViewMedia;
    Intent intent1;
    static final int ACTIVITY_REQUEST_MEDIA = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        av1 = (EditText) findViewById(R.id.editTextNumber);
        av2 = (EditText) findViewById(R.id.editTextNumber2);
        av3 = (EditText) findViewById(R.id.editTextNumber3);
        //textViewMedia = (TextView) findViewById(R.id.textView2);
        getSupportActionBar().hide();

    }

    public void calcular (View V){

        double av1d = Double.parseDouble(av1.getText().toString());
        double av2d = Double.parseDouble(av2.getText().toString());
        double av3d = Double.parseDouble(av3.getText().toString());
        double nfp = 0;
        String resultado = "";
        if(av1d > 0 && (av2d >= 5 ||av3d >= 5  )){
            if(av2d > av3d ){
                nfp = (av1d * 0.4)+ (av2d * 0.6);
            }else{
                nfp = (av1d * 0.4)+ (av3d * 0.6);
            }

        }else if (av1d == 0 || (av2d < 5 || av3d <5)){
            if(av2d > av3d){
                nfp = (av1d * 0.4)+ (av2d * 0.6)/2;
            }else{
                nfp = (av1d * 0.4)+ (av3d * 0.6)/2;
            }

        }

        if(nfp >= 6){
            resultado = "Aprovado";
        }else{
            resultado = "Reprovado";
        }


       // double resultado = (Double.parseDouble(av1.getText().toString())+ Double.parseDouble(av2.getText().toString())  + Double.parseDouble(av3.getText().toString()) )/ 3;


        DecimalFormat twoDForm = new DecimalFormat("#.##");

        String retorno =  "Sua Media é : "+ Double.valueOf(twoDForm.format(nfp));
        intent1 = new Intent(getApplicationContext(), Calcula_Media.class);
        // Envia o nome para a segunda atividade
        intent1.putExtra("media", retorno);
        intent1.putExtra("aprovado", resultado);
        startActivityForResult(intent1,ACTIVITY_REQUEST_MEDIA);

    }

    @Override
    protected void onResume() {
        av1.setText("");
        av2.setText("");
        av3.setText("");

        super.onResume();
    }
}