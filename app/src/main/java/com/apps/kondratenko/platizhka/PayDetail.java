package com.apps.kondratenko.platizhka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PayDetail extends AppCompatActivity implements android.view.View.OnClickListener{

    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextName;
    EditText editTextgroupId;
    EditText editTextstdId;
    private int _Payment_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_detail);

        btnSave = findViewById(R.id.btnSave);
        btnDelete =  findViewById(R.id.btnDelete);
        btnClose =  findViewById(R.id.btnClose);

        editTextName =  findViewById(R.id.editTextName);
        editTextgroupId = findViewById(R.id.editTextgroupId);
        editTextstdId =  findViewById(R.id.editTextstdId);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);


        _Payment_Id =0;
        Intent intent = getIntent();
        _Payment_Id =intent.getIntExtra("payment_Id", 0);
        PayRepo repo = new PayRepo(this);
        Payment payment;
        payment = repo.getPaymentById(_Payment_Id);

        editTextstdId.setText(String.valueOf(payment.stdId));
        editTextName.setText(payment.name);
        editTextgroupId.setText(payment.groupId);
    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)){
            PayRepo repo = new PayRepo(this);
            Payment payment = new Payment();
            payment.stdId= editTextstdId.getText().toString();
            payment.groupId=editTextgroupId.getText().toString();
            payment.name=editTextName.getText().toString();
            payment.payment_ID=_Payment_Id;

            if (_Payment_Id==0){
                _Payment_Id = repo.insert(payment);

                Toast.makeText(this,"Елемент додано!",Toast.LENGTH_SHORT).show();
            }else{

                repo.update(payment);
                Toast.makeText(this,"Дані оновлено!",Toast.LENGTH_SHORT).show();
            }
        }else if (view== findViewById(R.id.btnDelete)){
            PayRepo repo = new PayRepo(this);
            repo.delete(_Payment_Id);
            Toast.makeText(this, "Дані видалено!", Toast.LENGTH_SHORT).show();
            finish();
        }else if (view== findViewById(R.id.btnClose)){
            finish();
        }


    }

}