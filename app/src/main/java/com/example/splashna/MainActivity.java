package com.example.splashna;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    Animation animationGrupo;
    Animation animarionElipse;
    private ImageView elipse;
    private ImageView grupo;
    private TextView noticiasArgentinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elipse = findViewById(R.id.imageView2);
        grupo = findViewById(R.id.imageView);
        noticiasArgentinas = findViewById(R.id.textViewTitulo);


        rotarAnimacion();
        escalaAnimacion();
        YoYo.with(Techniques.FadeIn).duration(4000).playOn(noticiasArgentinas);

    }

    private void rotarAnimacion(){
        animationGrupo = AnimationUtils.loadAnimation(this, R.anim.rotate);
        animationGrupo.setDuration(6000);
        grupo.startAnimation(animationGrupo);
    }

    private  void escalaAnimacion(){
        animarionElipse= AnimationUtils.loadAnimation(this, R.anim.scale);
        animarionElipse.setDuration(3500);
        elipse.startAnimation(animarionElipse);
    }

    }

