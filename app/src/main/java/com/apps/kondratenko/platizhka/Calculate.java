package com.apps.kondratenko.platizhka;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Calculate extends AppCompatActivity {
    final double priceGas = 6.96;
    final double priceLight = 1.68;
    final double priceWater = 8.22;
    private double result = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btn = findViewById(R.id.buttonCalc);
        final RadioButton tarif1 = findViewById(R.id.tarif1);
        final RadioButton tarif2 = findViewById(R.id.tarif2);
        final RadioButton tarif3 = findViewById(R.id.tarif3);
        final TextView resultField = findViewById(R.id.textView14);

        final EditText data =  findViewById(R.id.editText3);
        final EditText price = findViewById(R.id.editText4);

        price.setVisibility(View.GONE);
        Spinner spn = findViewById(R.id.serviceSpinner);
        final String spnValue =spn.getSelectedItem().toString();

        tarif1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tarif2.setChecked(false);
                tarif3.setChecked(false);
                price.setVisibility(View.GONE);
                    Toast.makeText(Calculate.this,"ok1", Toast.LENGTH_LONG).show();
                }
        });

        tarif2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                price.setVisibility(View.GONE);
                //double price2=Double.parseDouble(price.getText().toString()); // ЭТО В КНОПКУ
                tarif1.setChecked(false);
                tarif3.setChecked(false);
                Toast.makeText(Calculate.this,"ok2", Toast.LENGTH_LONG).show();
            }
        });

        tarif3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                price.setVisibility(View.VISIBLE);
                tarif1.setChecked(false);
                tarif2.setChecked(false);
                Toast.makeText(Calculate.this,"ok3", Toast.LENGTH_LONG).show();

            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(TextUtils.isEmpty(data.getText()) ){
                    data.setError("Введіть спожитий обсяг!");
                    return;
                }else {
                    double input=Double.parseDouble(data.getText().toString());
                    if (spnValue.equals("Газ")){

                        if(tarif1.isChecked()){
                            result = input*priceGas;
                            resultField.setText(result+" грн.");
                        } else if(tarif2.isChecked()){
                            result = input*priceGas - 0.2*input*priceGas;
                            resultField.setText(result+" грн.");
                        } else if (tarif3.isChecked()){
                            double inputPrice=Double.parseDouble(price.getText().toString());
                            result = input * inputPrice;
                            resultField.setText(result+" грн.");
                        }
                    }



                    Toast.makeText(Calculate.this,""+result, Toast.LENGTH_LONG).show();

                }}});




}}
