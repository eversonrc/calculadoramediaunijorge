package com.example.calculadoraav1;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calcula_Media extends AppCompatActivity {
    TextView txReturn,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula_media);
        txReturn = (TextView) findViewById(R.id.textViewMedia);
        textView2 = (TextView) findViewById(R.id.textView2);
        String media = getIntent().getExtras().getString("media");
        String resultado = getIntent().getExtras().getString("aprovado");
        txReturn.setText(media);
        textView2.setText("Você está " +  resultado);
        if(resultado.equals("Aprovado") ){
            textView2.setTextColor(Color.GREEN);
        }else{
            textView2.setTextColor(Color.RED);
        }
        getSupportActionBar().hide();

    }

    public void voltar(View v){
        Intent returnIntent = new Intent();
        setResult(RESULT_OK);
        finish();

    }
}