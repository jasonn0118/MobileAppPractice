package com.example.demo02_prac02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final String TAG = "SEGWAY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnForSegway = findViewById(R.id.btnMain);

        btnForSegway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myNewIntent = new Intent(MainActivity.this, segwayDetail.class);
                startActivity(myNewIntent);
                
            }
        });
    }
}
