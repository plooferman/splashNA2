package com.example.splashna;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Locale;

public class VozATextoActivity extends AppCompatActivity {

    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView textViewEntradaVoz;
    private FloatingActionButton botonHablar;
    private Button vozATextoBotonSiguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voz_a_texto);

        textViewEntradaVoz = findViewById(R.id.textViewTextoIngresado);
        botonHablar = findViewById(R.id.botonMicrofono);
        vozATextoBotonSiguiente = findViewById(R.id.vozATextoBotonSiguiente);

        botonHablar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarEntradaVoz();
            }
        });

        vozATextoBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTextAVoz = new Intent(VozATextoActivity.this, TextAVozActivity.class);
                startActivity(intentTextAVoz);
            }
        });
    }

    private void iniciarEntradaVoz(){

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-AR");
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "es-AR");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Diga su búsqueda");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Acción no disponible", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode==RESULT_OK && data != null){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textViewEntradaVoz.setText(result.get(0));
                }
            }break;
        }
    }
}
