package com.example.demo03_prac02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    final String LOG = "ATHLETES";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editNumberOfAthletes = findViewById(R.id.editNumOfAthle);
        final Spinner spinner1 = findViewById(R.id.spinnerEntity);
        final TextView txtResult = findViewById(R.id.txtResult);
        final Button btnResult = findViewById(R.id.btnMain);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(editNumberOfAthletes.getText().toString().equals("")) {
                  Toast.makeText(MainActivity.this,
                          "Number of Athletes cannot be empty",
                          Toast.LENGTH_SHORT).show();
                  Log.w(LOG,"Number of Athletes required");
              } else{
                  try {
                      int numOfAth = Integer.parseInt(editNumberOfAthletes.getText().toString());
                      int index = spinner1.getSelectedItemPosition();
                      double cost = 0;
                      switch (index){
                          case 0:
                              cost = numOfAth * 72.99;
                              break;
                          case 1:
                              cost = numOfAth * 48.99;
                              break;
                          case 2:
                              cost = numOfAth * 58.99;
                              break;
                          default:
                              cost = 0;
                      }
                      DecimalFormat df = new DecimalFormat("$#.##");
                      String outputStr = "Ticket Type: "
                              +spinner1.getSelectedItem() +"\n";
                      outputStr += "Number of Tickets: "+ numOfAth +"\n";
                      outputStr += "Total Cost: "+ df.format(cost);

                      txtResult.setText(outputStr);
                  } catch (Exception e) {
                      Log.w(LOG, e.getMessage());
                  }
              }
            }
        });


    }
}
