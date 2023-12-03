package com.example.loyaltyfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Spinner spinner = findViewById(R.id.spinner);

        TextView textViewTxnDate = findViewById(R.id.textViewTxnDate);
        TextView textViewTxnPoints = findViewById(R.id.textViewTxnPoints);
        TextView textViewProductName = findViewById(R.id.textViewProductName);
        TextView textViewProdQuantity = findViewById(R.id.textViewProdQuantity);
        TextView textViewProdPoints = findViewById(R.id.textViewProdPoints);

        Intent intentTxn = getIntent();
        String cid = intentTxn.getStringExtra("cid");
        String url6 = "http://10.0.2.2:8080/loyaltyfirst/Transactions.jsp?cid="+cid;

        RequestQueue queue1 = Volley.newRequestQueue(MainActivity4.this);
        StringRequest request1 = new StringRequest(Request.Method.GET, url6, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                String[] output = s.trim().split("#");

                List<String> TrexValue = new ArrayList<>();

                for( int i=0 ; i < output.length ; i += 4){
                    TrexValue.add(output[i]);
                }
                ArrayAdapter<String> TrexAdapter = new ArrayAdapter<>(MainActivity4.this, android.R.layout.simple_spinner_dropdown_item, TrexValue);
                TrexAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinner.setAdapter(TrexAdapter);

            }
        }, null);
        queue1.add(request1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String TransactionDetails = adapterView.getSelectedItem().toString();
                String url7 = "http://10.0.2.2:8080/loyaltyfirst/Transactions.jsp?cid="+cid;
                RequestQueue queue2 = Volley.newRequestQueue(MainActivity4.this);
                StringRequest request2 = new StringRequest(Request.Method.GET, url7, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        String[] output2 = s.trim().split("#");

                        for(int i=0; i< output2.length ; i +=4){
                            if( output2[i].equals(TransactionDetails)){
                                String Txndate = output2[i+1].split(" ")[0];
                                String TxnPoints = output2[i+2];

                                textViewTxnDate.setText(Txndate);
                                textViewTxnPoints.setText(TxnPoints);
                                break;
                            }
                        }
                    }
                }, null);
                queue2.add(request2);

                String url8 = "http://10.0.2.2:8080/loyaltyfirst/TransactionDetails.jsp?tref="+TransactionDetails;
                RequestQueue queue3 = Volley.newRequestQueue(MainActivity4.this);
                StringRequest request3 = new StringRequest(Request.Method.GET, url8, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        String[] output3 = s.trim().split("#");

                        textViewProductName.setText(" ");
                        textViewProdQuantity.setText(" ");
                        textViewProdPoints.setText(" ");

                        for ( int i = 0; i < output3.length ; i += 5){

                            String Pname = output3[i+2];
                            String Ppoints = output3[i+3];
                            String Pquantity = output3[i+4];

                            textViewProductName.append(Pname + "\n");
                            textViewProdQuantity.append(Pquantity+ "\n");
                            textViewProdPoints.append(Ppoints+ "\n");


                        }
                    }
                }, null);
                queue3.add(request3);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}