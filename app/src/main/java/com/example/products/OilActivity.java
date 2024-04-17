package com.example.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OilActivity extends AppCompatActivity {
    private ImageView backButton;
    private ConstraintLayout vegetableOilButton;
    private ConstraintLayout clarifiedButterButton;
    private ConstraintLayout butterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil);
        initViews();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setButtonListeners();
    }

    private void initViews() {
        backButton = findViewById(R.id.backButton);
        vegetableOilButton = findViewById(R.id.vegetableOil);
        clarifiedButterButton = findViewById(R.id.clarifiedButter);
        butterButton = findViewById(R.id.butter);
    }
    private void setButtonListeners() {
        vegetableOilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OilActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 18);
                startActivity(intent);
            }
        });
        clarifiedButterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OilActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 19);
                startActivity(intent);
            }
        });
        butterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OilActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 20);
                startActivity(intent);
            }
        });
    }
}