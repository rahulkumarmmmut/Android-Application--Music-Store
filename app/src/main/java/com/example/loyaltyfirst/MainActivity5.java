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

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Spinner spinner2 = findViewById(R.id.spinner2);
        TextView textViewPrizeDesc = findViewById(R.id.textViewPrizeDesc);
        TextView textViewPointsNeeded = findViewById(R.id.textViewPointNeeded);
        TextView textViewRedemptionDetails = findViewById(R.id.textViewRedemptionDetails);
        TextView textViewExchangeCenter = findViewById(R.id.textViewExchangeCenter);

        Intent redemptionIntent = getIntent();
        String cid = redemptionIntent.getStringExtra("cid");

        String url9 =  "http://10.0.2.2:8080/loyaltyfirst/PrizeIds.jsp?cid="+cid;

        RequestQueue queue4 = Volley.newRequestQueue(MainActivity5.this);
        StringRequest request4 = new StringRequest(Request.Method.GET, url9, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                String[] output = s.trim().split("#");
                List<String> Prize_id = new ArrayList<>();
                for( int i=0 ; i < output.length ; i++){
                    Prize_id.add(output[i]);
                }
                ArrayAdapter<String> PidAdapter = new ArrayAdapter<>(MainActivity5.this, android.R.layout.simple_spinner_dropdown_item, Prize_id);
                PidAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinner2.setAdapter(PidAdapter);
            }
        }, null);
        queue4.add(request4);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String Prizes = adapterView.getSelectedItem().toString();
                String url10 = "http://10.0.2.2:8080/loyaltyfirst/RedemptionDetails.jsp?prizeid="+Prizes+"&cid="+cid;
                RequestQueue queue5 = Volley.newRequestQueue(MainActivity5.this);
                StringRequest request5 = new StringRequest(Request.Method.GET, url10, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        String[] output2 = s.trim().split("#");
                        String PrizeDesc = output2[0];
                        String TotalPtz = output2[1];
                        String PrizeDate = output2[2].split(" ")[0];
                        String ECenter = output2[3];

                        textViewPrizeDesc.setText(PrizeDesc);
                        textViewPointsNeeded.setText(TotalPtz);
                        textViewRedemptionDetails.setText(PrizeDate);
                        textViewExchangeCenter.setText(ECenter);
                    }
                }, null);
                queue5.add(request5);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }







        });










    }
}