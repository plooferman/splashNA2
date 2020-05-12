package com.example.splashna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TextAVozActivity extends AppCompatActivity {

    private Button hablarAhoraBoton;
    private EditText editText;
    TTSManager ttsManager=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_a_voz);

        ttsManager=new TTSManager();
        ttsManager.init(this);

        editText =findViewById(R.id.textoAVozEditText);
        hablarAhoraBoton=findViewById(R.id.textoAVozButton);

        hablarAhoraBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=editText.getText().toString();
                ttsManager.initQueue(text);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}
