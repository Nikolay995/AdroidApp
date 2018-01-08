package com.apps.kondratenko.platizhka;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Tariffs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tariffs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        startActivity(new Intent(Tariffs.this, AboutApp.class) );

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String[] service = {"Електроенергія", "Опалення","Холодна вода", "Гаряча вода", "Газ"};
        ListAdapter serviceList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, service);
        ListView list = findViewById(R.id.listView);
        list.setAdapter(serviceList);


        list.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String serviceClicked = String.valueOf(adapterView.getItemAtPosition(i));
                        if (i==0){
                            WebView webView = new WebView(Tariffs.this);
                            setContentView(webView);
                            webView.loadUrl("http://tarifi.kiev.ua/tarify_na_elektroenergiyu.html");
                        }
                        if (i==1){
                            WebView webView = new WebView(Tariffs.this);
                            setContentView(webView);
                            webView.loadUrl("http://tarifi.kiev.ua/opalennya.html");
                        }else if (i==2){
                            WebView webView = new WebView(Tariffs.this);
                            setContentView(webView);
                            webView.loadUrl("http://tarifi.kiev.ua/holodnaya-voda.html");
                        }else if (i==3){
                            WebView webView = new WebView(Tariffs.this);
                            setContentView(webView);
                            webView.loadUrl("http://tarifi.kiev.ua/goryachaya-voda.html");
                        }else if (i==4){
                            WebView webView = new WebView(Tariffs.this);
                            setContentView(webView);
                            webView.loadUrl("http://tarifi.kiev.ua/gaz.html");
                        }
                }}
        );

    }

}
