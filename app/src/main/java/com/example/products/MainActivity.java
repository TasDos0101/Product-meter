package com.example.products;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    private TextView textViewQuotation;
    private ImageView nextButtonLiquid;
    private ImageView nextButtonCrumble;
    private ImageView nextButtonButter;
    private ImageView buttonWater;
    private ImageView buttonMilk;
    private ImageView buttonSugar;
    private ImageView buttonSalt;
    private ImageView buttonVegetableOil;
    private ImageView buttonButter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String currentLanguage = LocaleManager.getLanguage(this);
        LocaleManager.setLocale(this, currentLanguage);
        initViews();
        setRandomQuotation();
        nextButtonLiquid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LiquidActivity.class);
                startActivity(intent);
            }
        });
        nextButtonCrumble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CrumblyActivity.class);
                startActivity(intent);
            }
        });
        nextButtonButter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OilActivity.class);
                startActivity(intent);
            }
        });

        setButtonListeners();
    }
    private void initViews() {
        textViewQuotation = findViewById(R.id.textViewQuotation);
        nextButtonLiquid = findViewById(R.id.nextButtonLiquid);
        nextButtonCrumble = findViewById(R.id.nextButtonCrumble);
        nextButtonButter = findViewById(R.id.nextButtonButter);
        buttonWater = findViewById(R.id.imageViewProduct);
        buttonMilk = findViewById(R.id.imageViewMilk);
        buttonSugar = findViewById(R.id.imageViewSugar);
        buttonSalt = findViewById(R.id.imageViewSalt);
        buttonVegetableOil = findViewById(R.id.imageViewVegetableOil);
        buttonButter = findViewById(R.id.imageViewButter);
    }
    private void setRandomQuotation() {
        String[] myArray = getResources().getStringArray(R.array.quotations_array);

        int randomIndex = random.nextInt(myArray.length);

        textViewQuotation.setText(myArray[randomIndex]);
    }

    private void setButtonListeners() {
        buttonWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 1);
                startActivity(intent);
            }
        });

        buttonMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 2);
                startActivity(intent);
            }
        });

        buttonSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 6);
                startActivity(intent);
            }
        });

        buttonSalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 7);
                startActivity(intent);
            }
        });

        buttonVegetableOil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 18);
                startActivity(intent);
            }
        });

        buttonButter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 19);
                startActivity(intent);
            }
        });
    }
}
