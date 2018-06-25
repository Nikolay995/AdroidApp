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
    final double priceGas = 6.96;       //немножко хардкода
    final double priceLight = 1.68;
    final double priceWater = 8.22;
    private double result = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate2);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btn = findViewById(R.id.buttonCalc);
        final RadioButton tarif1 = findViewById(R.id.tarif1);
        final RadioButton tarif2 = findViewById(R.id.tarif2);
        final RadioButton tarif3 = findViewById(R.id.tarif3);
        final TextView resultField = findViewById(R.id.textView14);
        resultField.setVisibility(View.INVISIBLE);

        final EditText data =  findViewById(R.id.editText3);
        final EditText price = findViewById(R.id.editText4);

        price.setVisibility(View.GONE);
        final Spinner spn = findViewById(R.id.serviceSpinner);

        tarif1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tarif2.setChecked(false);
                tarif3.setChecked(false);
                price.setVisibility(View.GONE);
                resultField.setVisibility(View.GONE);
                }
        });

        tarif2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                price.setVisibility(View.GONE);
                resultField.setVisibility(View.GONE);
                tarif1.setChecked(false);
                tarif3.setChecked(false);
            }
        });

        tarif3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                price.setVisibility(View.VISIBLE);
                resultField.setVisibility(View.GONE);
                tarif1.setChecked(false);
                tarif2.setChecked(false);

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(TextUtils.isEmpty(data.getText()) ){
                    data.setError("Введіть спожитий обсяг!");
                    return;
                }else {
                    final String spnValue =spn.getSelectedItem().toString();
                    resultField.setVisibility(View.VISIBLE);
                    double input=Double.parseDouble(data.getText().toString());
                    if (spnValue.equals("Газ")){                        // дальше - жесть, уберите детей от экрана
                        if(tarif1.isChecked()){
                            result = input*priceGas;
                            resultField.setText(result+" грн.\nза "+input+"м³");
                        } else if(tarif2.isChecked()){
                            result = (input*priceGas)/2;
                            resultField.setText(result+" грн.\nза "+input+"м³");
                        } else if (tarif3.isChecked()){
                            double inputPrice=Double.parseDouble(price.getText().toString());
                            result = input * inputPrice;
                            resultField.setText(result+" грн.\nза "+input+"м³");
                        } else Toast.makeText(Calculate.this,"Оберіть тариф", Toast.LENGTH_SHORT).show();

                    } if (spnValue.equals("Вода")){

                        if(tarif1.isChecked()){
                            result = input*priceWater;
                            resultField.setText(result+" грн.\nза "+input+"м³");
                        } else if(tarif2.isChecked()){
                            result = (input*priceWater)/2;
                            resultField.setText(result+" грн.\nза "+input+"м³");
                        } else if (tarif3.isChecked()){
                            double inputPrice=Double.parseDouble(price.getText().toString());
                            result = input * inputPrice;
                            resultField.setText(result+" грн.\nза "+input+"м³");
                        } else Toast.makeText(Calculate.this,"Оберіть тариф", Toast.LENGTH_SHORT).show();

                    } if (spnValue.equals("Світло")){

                        if(tarif1.isChecked()){
                            result = input*priceLight;
                            resultField.setText(result+" грн.\nза "+input+" кВт⋅год");
                        } else if(tarif2.isChecked()){
                            result = (input*priceLight)/2;
                            resultField.setText(result+" грн.\nза "+input+" кВт⋅год");
                        } else if (tarif3.isChecked()){
                            double inputPrice=Double.parseDouble(price.getText().toString());
                            result = input * inputPrice;
                            resultField.setText(result+" грн.\nза "+input+" кВт⋅год");
                        } else Toast.makeText(Calculate.this,"Оберіть тариф", Toast.LENGTH_SHORT).show();
                    }
                }}});

}}
