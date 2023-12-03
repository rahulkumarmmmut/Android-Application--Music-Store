package com.example.loyaltyfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.privacysandbox.tools.core.model.Method;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView textViewRef = findViewById(R.id.textViewRef);
        TextView textViewDate = findViewById(R.id.textViewDate);
        TextView textViewPts = findViewById(R.id.textViewPts);
        TextView textViewTotal = findViewById(R.id.textViewTotal);
        Intent intentTxn = getIntent();
        String cid = intentTxn.getStringExtra("cid");
        String url5 = "http://10.0.2.2:8080/loyaltyfirst/Transactions.jsp?cid="+cid;

        RequestQueue queue = Volley.newRequestQueue(MainActivity3.this);
        StringRequest request = new StringRequest(Request.Method.GET, url5, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                String[] output = s.trim().split("#");


                for( int i =0; i< output.length; i +=4){
                    String ref = output[i];
                    String date = output[i+1].split(" ")[0];
                    String pts = output[i+2];
                    String total = output[i+3];

                    textViewRef.append(ref + "\n");
                    textViewDate.append(date + "\n");
                    textViewPts.append(pts + "\n");
                    textViewTotal.append(total + "\n");

                }
            }
        }, null);
        queue.add(request);

    }
}