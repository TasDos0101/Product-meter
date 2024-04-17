package com.example.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CrumblyActivity extends AppCompatActivity {
    private ImageView backButton;
    private ConstraintLayout sugarButton;
    private ConstraintLayout saltButton;
    private ConstraintLayout riceButton;
    private ConstraintLayout curdButton;
    private ConstraintLayout sodaButton;
    private ConstraintLayout icingSugarButton;
    private ConstraintLayout flourButton;
    private ConstraintLayout semolinaButton;
    private ConstraintLayout herculesButton;
    private ConstraintLayout starchButton;
    private ConstraintLayout buckwheatButton;
    private ConstraintLayout cacaoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String currentLanguage = getIntent().getStringExtra("currentLanguage");
        LocaleManager.setLocale(this, currentLanguage);
        setContentView(R.layout.activity_crumbly);
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
        sugarButton = findViewById(R.id.sugar);
        saltButton = findViewById(R.id.salt);
        riceButton = findViewById(R.id.rice);
        curdButton = findViewById(R.id.curd);
        sodaButton = findViewById(R.id.soda);
        icingSugarButton = findViewById(R.id.icingSugar);
        flourButton = findViewById(R.id.flour);
        semolinaButton = findViewById(R.id.semolina);
        herculesButton = findViewById(R.id.hercules);
        starchButton = findViewById(R.id.starch);
        buckwheatButton = findViewById(R.id.buckwheat);
        cacaoButton = findViewById(R.id.cacao);
    }

    private void setButtonListeners() {
        sugarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrumblyActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 6);
                startActivity(intent);
            }
        });

        saltButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrumblyActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 7);
                startActivity(intent);
            }
        });

        riceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrumblyActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 8);
                startActivity(intent);
            }
        });

        curdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrumblyActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 9);
                startActivity(intent);
            }
        });

        sodaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrumblyActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 10);
                startActivity(intent);
            }
        });
        flourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrumblyActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 11);
                startActivity(intent);
            }
        });

        icingSugarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrumblyActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 12);
                startActivity(intent);
            }
        });

        semolinaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrumblyActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 13);
                startActivity(intent);
            }
        });

        herculesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrumblyActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 14);
                startActivity(intent);
            }
        });

        starchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrumblyActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 15);
                startActivity(intent);
            }
        });
        buckwheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrumblyActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 16);
                startActivity(intent);
            }
        });
        cacaoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrumblyActivity.this, CalculateActivity.class);
                intent.putExtra("sit", 17);
                startActivity(intent);
            }
        });
    }
}
