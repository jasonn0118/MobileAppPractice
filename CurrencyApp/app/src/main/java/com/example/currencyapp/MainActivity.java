package com.example.currencyapp;

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

    double usDollarsEntered;
    double convertedCurrency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_lauchar_weight);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText editTextCurrency = findViewById(R.id.editCurrencyInput);
        final RadioButton rdbUsToEuro = findViewById(R.id.rdbUstoEu);
        final RadioButton rdbUsToPeso = findViewById(R.id.rdbUstoPeso);
        final RadioButton rdbUsToCa = findViewById(R.id.rdbUstoCa);
        final Button btnResult = findViewById(R.id.btnResult);
        final TextView txtResult = findViewById(R.id.textViewResult);

        btnResult.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                usDollarsEntered = Double.parseDouble(editTextCurrency.getText().toString());
                DecimalFormat df = new DecimalFormat("#.##");

                if(rdbUsToEuro.isChecked()) {
                    if(usDollarsEntered <= 100000){
                        convertedCurrency = usDollarsEntered * 0.92;
                        txtResult.setText(df.format(convertedCurrency));
                    } else {
                        Toast.makeText(MainActivity.this, "US dollars must be less than $100,000", Toast.LENGTH_LONG).show();
                    }
                } else if(rdbUsToPeso.isChecked()) {
                    if(usDollarsEntered <= 100000) {
                        convertedCurrency = usDollarsEntered * 19.03;
                        txtResult.setText(df.format(convertedCurrency));
                    } else{
                        Toast.makeText(MainActivity.this, "US dollars must be less than $100,000", Toast.LENGTH_LONG).show();
                    }
                } else if(rdbUsToCa.isChecked()){
                    if(usDollarsEntered <= 100000) {
                        convertedCurrency = usDollarsEntered * 1.33;
                        txtResult.setText(df.format(convertedCurrency));
                    } else {
                        Toast.makeText(MainActivity.this, "US dollars must be less than $100,000", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
