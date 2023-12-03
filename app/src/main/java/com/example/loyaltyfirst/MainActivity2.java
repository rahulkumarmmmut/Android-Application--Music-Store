package com.example.loyaltyfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewPoints = findViewById(R.id.textViewPoints);
        ImageView imageView = findViewById(R.id.imageView);

        //b2=all txn
        Button button2 = findViewById(R.id.button2);
        //b3=txn details
        Button button3 = findViewById(R.id.button3);
        //b4=redemption details
        Button button4 = findViewById(R.id.button4);
        //b5 = add % to fam
        Button button5 = findViewById(R.id.button5);
        //b6=exit
        Button button6 = findViewById(R.id.buttonexit);

        String cid = intent.getStringExtra("cid");
        RequestQueue queue = Volley.newRequestQueue(MainActivity2.this);
        String url = "http://10.0.2.2:8080/loyaltyfirst/Info.jsp?cid=" + cid;
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                String[] output = s.trim().split("#");
                String cname = output[0];
                String rPoints = output[1];
                textViewName.setText(cname);
                textViewPoints.setText(rPoints);


            }
        }, null);
        queue.add(request);

        String img_url = "http://10.0.2.2:8080/loyaltyfirst/images/" + cid + ".jpg";
        ImageRequest request2 = new ImageRequest(img_url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);

            }
        }, 0, 0, null, null);
        queue.add(request2);

        //b2=all txn
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity2.this, MainActivity3.class);
                intent1.putExtra("cid",cid);
                startActivity(intent1);
            }

        });
        //b3=txn details
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity2.this, MainActivity4.class);
                intent2.putExtra("cid",cid);
                startActivity(intent2);
            }
        });
        //b4=redemption details
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity2.this, MainActivity5.class);
                intent3.putExtra("cid",cid);
                startActivity(intent3);
            }
        });
        //b5 = add % to fam
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity2.this, MainActivity6.class);
                intent4.putExtra("cid", cid);
                startActivity(intent4);
            }
        });
        // exit
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity2.this, MainActivity.class);
                intent5.putExtra("cid", cid);
                startActivity(intent5);

            }
        });

    }
}