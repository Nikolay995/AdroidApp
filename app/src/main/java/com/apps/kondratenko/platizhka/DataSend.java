package com.apps.kondratenko.platizhka;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class DataSend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_send);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText account = findViewById(R.id.editText);
        final EditText counter = findViewById(R.id.editText2);
        final Spinner spn = findViewById(R.id.spinner);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button infoButton =(Button) findViewById(R.id.button2);
        Button btn = findViewById(R.id.button);
        final String sendGasNumber = "7104";
        final String sendLightNumber = "+380674606077";
        final String sendWaterNumer = "+380483123486";

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TextUtils.isEmpty(account.getText())) {
                    account.setError("Введіть особовий рахунок!");
                    return;
                } else if (TextUtils.isEmpty(counter.getText())) {
                    counter.setError("Введіть показання!");
                    return;
                } else {
                    final String spnValue1 =spn.getSelectedItem().toString();
                    String strAccount = account.getEditableText().toString();
                    String strCounter = counter.getText().toString();
                    if (spnValue1.equals("Газ")) {
                        String messageGas = strAccount + " " + strCounter;
                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + sendGasNumber));
                        smsIntent.putExtra("sms_body", messageGas);
                        startActivity(smsIntent);
                    } else if (spnValue1.equals("Вода")) {
                        final String messageWater = strAccount + " " + strCounter;
                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + sendWaterNumer));
                        smsIntent.putExtra("sms_body", messageWater);
                        startActivity(smsIntent);
                    } else if (spnValue1.equals("Світло")) {
                        final String messageLight = "1*" + strAccount + "*" + strCounter;
                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + sendLightNumber));
                        smsIntent.putExtra("sms_body", messageLight);
                        startActivity(smsIntent);
                    }
                }
            }});

        infoButton.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                startActivity(new Intent(DataSend.this, AboutApp.class) );
            }
        });
    }




}
