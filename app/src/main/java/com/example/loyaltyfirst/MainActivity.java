package com.example.loyaltyfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "http://10.0.2.2:8080/loyaltyfirst/login?user="+username+"&pass="+password;
                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        String response = s.trim();

                        String[] output = response.split(":");
                        //Toast.makeText(MainActivity.this, output[1], Toast.LENGTH_LONG).show();


                        if(output[0].equals("Yes")){
                            String cid = output[1];
                            //Toast.makeText(MainActivity.this, "okok", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            intent.putExtra("cid", cid);
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(MainActivity.this, "invalid username or password", Toast.LENGTH_LONG).show();

                        }



                    }
                },null);
                queue.add(request);
            }
        });

    }
}