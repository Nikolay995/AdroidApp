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
import android.widget.Toast;

public class Calculate extends AppCompatActivity {
    final double priceGas = 6.96;
    final double priceLight = 1.68;
    final double priceWater = 8.22;
    private double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btn = findViewById(R.id.buttonCalc);
        final RadioButton tarif1 = (RadioButton) findViewById(R.id.tarif1);
        final RadioButton tarif2 = (RadioButton) findViewById(R.id.tarif2);

        final EditText data =  (EditText) findViewById(R.id.editText3);
        Spinner spn = (Spinner) findViewById(R.id.serviceSpinner);
        final String spnValue =spn.getSelectedItem().toString();

        tarif1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double input=Double.parseDouble(data.getText().toString());
                if (spnValue.equals("Газ")){
                if(tarif1.isChecked()){
                    tarif2.setEnabled(false);
                    result = input*priceGas;
                    Toast.makeText(Calculate.this,""+result, Toast.LENGTH_LONG).show();
                }else if(tarif2.isChecked()){
                    tarif1.setEnabled(false);
                    result = input*priceGas - 0.2*(input*priceGas);
                    Toast.makeText(Calculate.this,""+result, Toast.LENGTH_LONG).show();
                }

                }}
        });




        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(TextUtils.isEmpty(data.getText()) ){
                    data.setError("Введіть спожитий обсяг!");
                    return;
                }else {
                    //double input=Double.parseDouble(data.getText().toString());


                    Toast.makeText(Calculate.this,""+result, Toast.LENGTH_LONG).show();

                }}});




}}
