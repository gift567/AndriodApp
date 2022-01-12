package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity_main2();
            }
        });
    }

    public void openactivity_main2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }

    @Override
    protected void onStart(){
        super.onStart();
        myFirstRequest();
    }
    void myFirstRequest(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://root.zeecoder.tech/test/simple.php";

        StringRequest StringRequest = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>(){
            @Override
                    public void onResponse(String response){

                Toast.makeText(getApplicationContext(),"Response is"+ response, Toast.LENGTH_SHORT).show();

            }

                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "That didnt work!", Toast.LENGTH_SHORT).show();

            }
        }
        );
        queue.add(StringRequest);
    }
}