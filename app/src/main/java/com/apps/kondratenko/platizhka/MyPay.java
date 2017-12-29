package com.apps.kondratenko.platizhka;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MyPay extends ListActivity  implements android.view.View.OnClickListener{

    ImageView btnGetAll;
    ImageView  btnAdd;
    TextView student_Id;

    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.btnAdd)){
            Intent intent = new Intent(this,PayDetail.class);
            intent.putExtra("payment_Id",0);
            startActivity(intent);
        }else {
            PayRepo repo = new PayRepo(this);
            ArrayList<HashMap<String, String>> studentList =  repo.getPaymentList();
            if(studentList.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        student_Id = (TextView) view.findViewById(R.id.student_Id);
                        String studentId = student_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),PayDetail.class);
                        objIndent.putExtra("payment_Id", Integer.parseInt( studentId));
                        startActivity(objIndent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter( MyPay.this,studentList, R.layout.payment_entry, new String[] { "id","name"}, new int[] {R.id.student_Id, R.id.student_name});
                setListAdapter(adapter);
            }else{
                Toast.makeText(this,"Список пустий!",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pay);

        btnAdd =  findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnGetAll = findViewById(R.id.btnGetAll);
        btnGetAll.setOnClickListener(this);

    }


}
