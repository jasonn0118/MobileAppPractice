package com.example.demo04_prac01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double conversionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_weight);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText editWeight = findViewById(R.id.editTxtWeight);
        final RadioButton convertLtoK = findViewById(R.id.rdbLbToKilo);
        final RadioButton convertKtoL = findViewById(R.id.rdbKiloToLb);
        final TextView result = findViewById(R.id.txtViewResult);
        Button btnConvert = findViewById(R.id.btnConvert);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightEntered = Double.parseDouble(editWeight.getText().toString());
                DecimalFormat df = new DecimalFormat("#.#");

                if(convertLtoK.isChecked()){
                    if(weightEntered <= 500) {
                        convertedWeight = weightEntered/conversionRate;
                        result.setText(df.format(convertedWeight) + " kg");
                    } else {
                        Toast.makeText(MainActivity.this, "Pounds must be less than 500", Toast.LENGTH_LONG).show();
                    }
                } else if (convertKtoL.isChecked()) {
                    if(weightEntered <= 200){
                        convertedWeight = weightEntered * conversionRate;
                        result.setText(df.format(convertedWeight)+ " lb");
                    } else {
                        Toast.makeText(MainActivity.this, "Killogrms must be less than 200", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
