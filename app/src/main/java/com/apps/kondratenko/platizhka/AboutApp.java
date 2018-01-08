package com.apps.kondratenko.platizhka;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

public class AboutApp extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        ImageView git = (ImageView) findViewById(R.id.imageView8);
        git.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                WebView webView = new WebView(AboutApp.this);
                setContentView(webView);
                webView.loadUrl("https://github.com/Nikolay995/Platizhka");
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Служба підтримки: striker.kms@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Написати", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent email = new Intent(Intent.ACTION_SEND);
                                email.setType("message/rfc822");
                                email.putExtra(Intent.EXTRA_EMAIL, "striker.kms@gmail.com");
                                email.putExtra(Intent.EXTRA_SUBJECT, "HiT Assistant");
                                email.putExtra(Intent.EXTRA_TEXT, "*Текст повідомлення*");
                                startActivity(email);
                            }
                        }).show();
            }
        });
    }
}
