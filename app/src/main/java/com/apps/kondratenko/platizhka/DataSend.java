package com.apps.kondratenko.platizhka;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DataSend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_send);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spn = (Spinner) findViewById(R.id.spinner);
        final String spnValue =spn.getSelectedItem().toString();


        final EditText account = (EditText) findViewById(R.id.editText);
        final String strAccount = account.getText().toString();

        final EditText counter = (EditText) findViewById(R.id.editText2);
        final String strCounter = counter.getText().toString();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btn = findViewById(R.id.button);
        final String sendGasNumber = "7104";
        final String sendLightNumber = "+380674606077";
        final String sendWaterNumer = "+380483123486";
        final String sendTESTNumber = "+380682361835";


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                 if(TextUtils.isEmpty(account.getText()) ){
                     account.setError("Введіть особовий рахунок!");

                }else if(TextUtils.isEmpty(counter.getText()) ){
                     counter.setError("Введіть показання!");

                }else if (spnValue.equals("Газ")){
                     final String messageGas = strAccount + " "+ strCounter;
                     sendSMS(sendGasNumber, messageGas);

                }else if (spnValue.equals("Вода")){
                     final String messageWater = strAccount + " "+ strCounter;
                     sendSMS(sendTESTNumber, messageWater);

                }else if (spnValue.equals("Світло")){
                     final String messageLight = "1*"+strAccount + "*"+ strCounter;
                     sendSMS(sendLightNumber, messageLight);
            }}
            private void sendSMS(String phoneNumber, String message)
            {
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(phoneNumber, null, message, null, null);
            }
        });}




}
