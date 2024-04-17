package com.example.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LiquidActivity extends AppCompatActivity {
    private ImageView backButton;
    private ConstraintLayout waterButton;
    private ConstraintLayout milkButton;
    private ConstraintLayout creamButton;
    private ConstraintLayout honeyButton;
    private ConstraintLayout kefirButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquid);
        initViews();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        goWater();
        goMilk();
        goCream();
        goHoney();
        goKefir();
    }
    private void initViews() {
        backButton = findViewById(R.id.backButton);
        waterButton = findViewById(R.id.water);
        milkButton = findViewById(R.id.milk);
        creamButton = findViewById(R.id.cream);
        honeyButton = findViewById(R.id.honey);
        kefirButton = findViewById(R.id.kefir);
    }
    private void goWater() {
        waterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiquidActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 1);
                startActivity(intent);
            }
        });
    }
    private void goMilk() {
        milkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiquidActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 2);
                startActivity(intent);
            }
        });
    }
    private void goCream() {
        creamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiquidActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 3);
                startActivity(intent);
            }
        });
    }
    private void goHoney() {
        honeyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiquidActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 4);
                startActivity(intent);
            }
        });
    }
    private void goKefir() {
        kefirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiquidActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 5);
                startActivity(intent);
            }
        });
    }
}