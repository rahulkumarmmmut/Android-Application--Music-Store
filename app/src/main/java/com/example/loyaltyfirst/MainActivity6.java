package com.example.loyaltyfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Spinner spinner3 = findViewById(R.id.spinner3);
        TextView textViewTXN = findViewById(R.id.textViewTXNPts);
        TextView textViewFamilyID = findViewById(R.id.textViewfamilyID);
        TextView textViewFamilyPercent = findViewById(R.id.textViewFamilyPercent);
        Button button = findViewById(R.id.button7);

        Intent FamilyIntent = getIntent();
        String cid = FamilyIntent.getStringExtra("cid");
        String url11 =  "http://10.0.2.2:8080/loyaltyfirst/Transactions.jsp?cid="+cid;

        RequestQueue queue6 = Volley.newRequestQueue(MainActivity6.this);
        StringRequest request6 = new StringRequest(Request.Method.GET, url11, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                String[] output = s.trim().split("#");
                List<String> FamilyValue = new ArrayList<>();

                for ( int i =0 ; i < output.length ; i+= 4){
                    FamilyValue.add(output[i]);
                }

                ArrayAdapter<String> FamilyAdapter = new ArrayAdapter<>(MainActivity6.this, android.R.layout.simple_spinner_dropdown_item, FamilyValue);
                FamilyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinner3.setAdapter(FamilyAdapter);

            }
        },null);
        queue6.add(request6);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String FamilyPointsDetails = adapterView.getSelectedItem().toString();
                String url12 = "http://10.0.2.2:8080/loyaltyfirst/SupportFamilyIncrease.jsp?cid="+cid+"&tref="+FamilyPointsDetails;
                RequestQueue queue7 = Volley.newRequestQueue(MainActivity6.this);
                StringRequest request7 = new StringRequest(Request.Method.GET, url12, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        String[] output2 = s.trim().split("#");
                        String TXN = output2[2];
                        String ID = output2[0];
                        String Percent = output2[1];

                        textViewTXN.setText(TXN);
                        textViewFamilyID.setText(ID);
                        textViewFamilyPercent.setText(Percent);



                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                double txn = Double.parseDouble(TXN);
                                double percent = Double.parseDouble(Percent);
                                double x = txn * percent / 100.0;
                                long roundedx = Math.round(x);


                                String url13 = "http://10.0.2.2:8080/loyaltyfirst/FamilyIncrease.jsp?fid=" + ID + "&cid=" + cid + "&npoints=" + roundedx;
                                RequestQueue queue8 = Volley.newRequestQueue(MainActivity6.this);
                                StringRequest request8 = new StringRequest(Request.Method.GET, url13, new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String s) {
                                        Toast.makeText(MainActivity6.this, roundedx + " Points added to the members of the family ID : " + ID, Toast.LENGTH_LONG).show();
                                    }
                                }, null);
                                queue8.add(request8);

                                    //Toast.makeText(MainActivity6.this, roundedx + " Points added to the members of the family ID : " + ID, Toast.LENGTH_LONG).show();






                            }
                        });
                    }
                }, null);
                queue7.add(request7);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });












    }
}