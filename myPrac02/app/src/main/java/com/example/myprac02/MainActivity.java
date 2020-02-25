
package com.example.myprac02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewRecipeButton = findViewById(R.id.buttonForMain);

        viewRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewRecipeIntent = new Intent(MainActivity.this, recipe.class);
                startActivity(viewRecipeIntent);
            }
        });

    }
}
