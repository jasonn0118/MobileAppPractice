package com.example.demo03_prac01;

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
    final String TAG = "CONCERT TICKETS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextNumOfTickets = findViewById(R.id.inputTxt);
        final Spinner spinner = findViewById(R.id.spinnerGroup);
        final TextView result = findViewById(R.id.txtResult);

        Button cost = (Button)findViewById(R.id.btnCost);

        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNumOfTickets.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this,
                            "Number of Tickets cannot be empty.",
                            Toast.LENGTH_SHORT).show();
                    Log.w(TAG, "Number of Tickets is empty");
                } else {
                    try {
                        int numOfTickets = Integer.parseInt(editTextNumOfTickets.getText().toString());
                        int index = spinner.getSelectedItemPosition();
                        double cost = 0;

                        switch (index) {
                            case 0:
                                cost = numOfTickets * 79.99;
                                break;
                            case 1:
                                cost = numOfTickets * 39.99;
                                break;
                            case 2:
                                cost = numOfTickets * 59.99;
                                break;
                            default:
                                cost = 0;
                        }
                        DecimalFormat df = new DecimalFormat("$#.##");
                        String outPutStr = "Ticket Type: "
                                + spinner.getSelectedItem()+" \n";
                        outPutStr += "Number of Tickets: "+numOfTickets+"\n";
                        outPutStr += "Total Cost: " + df.format(cost);
                        result.setText(outPutStr);

                    } catch(Exception e){
                        Log.w(TAG, e.getMessage());
                    }
                }
            }
        });
    }
}
