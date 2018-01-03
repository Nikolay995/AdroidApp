package com.apps.kondratenko.platizhka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView icon = (ImageView) findViewById(R.id.imageView2);
        Animation icon_scale = AnimationUtils.loadAnimation(this,R.anim.moving);
        icon.startAnimation(icon_scale);

        TextView textUnder = (TextView) findViewById(R.id.textView2);
        Animation textScale = AnimationUtils.loadAnimation(this,R.anim.moving);
        textUnder.startAnimation(textScale);

        ImageView iconClose = (ImageView) findViewById(R.id.imageView6);
        Animation transp = AnimationUtils.loadAnimation(this,R.anim.transparency);
        iconClose.startAnimation(transp);

        ImageView iconAbout = (ImageView) findViewById(R.id.imageView7);
        Animation transp2 = AnimationUtils.loadAnimation(this,R.anim.transparency);
        iconAbout.startAnimation(transp);

        RelativeLayout relative1 = (RelativeLayout) findViewById(R.id.relative1);
        relative1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, MyPay.class) );
            }
        });
        RelativeLayout relative2 = (RelativeLayout) findViewById(R.id.relative2);
        relative2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Calculate.class) );
            }
        });


        RelativeLayout relative3 = (RelativeLayout) findViewById(R.id.relative3);
        relative3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Tariffs.class) );
            }
        });

        RelativeLayout relative4 = (RelativeLayout) findViewById(R.id.relative4);
        relative4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, DataSend.class) );
            }
        });



    }



}
