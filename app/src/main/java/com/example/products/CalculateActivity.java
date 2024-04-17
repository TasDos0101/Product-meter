package com.example.products;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateActivity extends AppCompatActivity {
    ImageView backButton;
    ImageView imageViewProduct;
    EditText editTextProduct;
    Button buttonCalculate;
    TextView textViewGlass;
    TextView textViewTablespoon;
    TextView textViewTeaspoon;
    TextView textViewProduct;
    ScrollView scrollView;
    RadioButton gramMode;
    RadioButton millilitreMode;
    RadioGroup radioGroupMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        initViews();
        changeAndCalculate();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mode();
        if (savedInstanceState != null) {
            int glassVisibility = savedInstanceState.getInt("textViewGlassVisibility");
            textViewGlass.setVisibility(glassVisibility);

            int tablespoonVisibility = savedInstanceState.getInt("textViewTablespoonVisibility");
            textViewTablespoon.setVisibility(tablespoonVisibility);

            int teaspoonVisibility = savedInstanceState.getInt("textViewTeaspoonVisibility");
            textViewTeaspoon.setVisibility(teaspoonVisibility);

            int checkedRadioButtonId = savedInstanceState.getInt("checkedRadioButtonId");
            radioGroupMode.check(checkedRadioButtonId);

            String editTextContent = savedInstanceState.getString("editTextContent");
            editTextProduct.setText(editTextContent);

            String strSum1 = savedInstanceState.getString("strSum1");
            String strSum2 = savedInstanceState.getString("strSum2");
            String strSum3 = savedInstanceState.getString("strSum3");
            textViewGlass.setText(strSum1);
            textViewTablespoon.setText(strSum2);
            textViewTeaspoon.setText(strSum3);
        }

    }


    private void initViews() {
        backButton = findViewById(R.id.backButton);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewGlass = findViewById(R.id.textViewGlass);
        textViewTablespoon = findViewById(R.id.textViewTablespoon);
        textViewTeaspoon = findViewById(R.id.textViewTeaspoon);
        textViewProduct = findViewById(R.id.textViewProduct);
        scrollView = findViewById(R.id.scrollView);
        editTextProduct = findViewById(R.id.editTextProduct);
        imageViewProduct = findViewById(R.id.imageViewProduct);
        gramMode = findViewById(R.id.gramMode);
        millilitreMode = findViewById(R.id.millilitreMode);
        radioGroupMode = findViewById(R.id.radioGroupMode);
    }
    private float sum1, sum2, sum3;

    private void mode() {
        radioGroupMode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (gramMode.isChecked()) {
                    editTextProduct.setHint(getResources().getString(R.string.write_in_gram));
                } else if (millilitreMode.isChecked()) {
                    editTextProduct.setHint(getResources().getString(R.string.write_in_milligram));
                }
            }
        });
    }

    private void changeAndCalculate() {
        int sit = getIntent().getIntExtra("sit", 0);
        switch (sit) {
            case 1:
                textViewProduct.setText(getResources().getString(R.string.product));
                imageViewProduct.setImageResource(R.drawable.water_icon);
                calculateForProduct(200, 18, 5);
                radioGroupMode.setVisibility(View.VISIBLE);
                break;
            case 2:
                textViewProduct.setText(getResources().getString(R.string.milk));
                imageViewProduct.setImageResource(R.drawable.milk_icon);
                radioGroupMode.setVisibility(View.VISIBLE);
                calculateForProduct(200, 15, 5);
                break;
            case 3:
                textViewProduct.setText(getResources().getString(R.string.cream));
                imageViewProduct.setImageResource(R.drawable.cream_icon);
                calculateForProduct(208, 25, 10);
                break;
            case 4:
                textViewProduct.setText(getResources().getString(R.string.honey));
                imageViewProduct.setImageResource(R.drawable.honey_icon);
                calculateForProduct(263, 35, 12);
                break;
            case 5:
                textViewProduct.setText(getResources().getString(R.string.kefir));
                imageViewProduct.setImageResource(R.drawable.kefir_icon);
                radioGroupMode.setVisibility(View.VISIBLE);
                calculateForProduct(200, 18, 5);
                break;
            case 6:
                textViewProduct.setText(getResources().getString(R.string.sugar));
                imageViewProduct.setImageResource(R.drawable.sugar_icon);
                calculateForProduct(178, 25, 10);
                break;
            case 7:
                textViewProduct.setText(getResources().getString(R.string.salt));
                imageViewProduct.setImageResource(R.drawable.salt_icon);
                calculateForProduct(222, 30, 10);
                break;
            case 8:
                textViewProduct.setText(getResources().getString(R.string.rice));
                imageViewProduct.setImageResource(R.drawable.rice_icon);
                calculateForProduct(222, 20, 4);
                break;
            case 9:
                textViewProduct.setText(getResources().getString(R.string.curd));
                imageViewProduct.setImageResource(R.drawable.curd_icon);
                calculateForProduct(250, 20, 7);
                break;
            case 10:
                textViewProduct.setText(getResources().getString(R.string.soda));
                imageViewProduct.setImageResource(R.drawable.soda_icon);
                calculateForProduct(200, 25, 8);
                break;
            case 11:
                textViewProduct.setText(getResources().getString(R.string.flour));
                imageViewProduct.setImageResource(R.drawable.flour_icon);
                calculateForProduct(149, 15, 5);
                break;
            case 12:
                textViewProduct.setText(getResources().getString(R.string.icingSugar));
                imageViewProduct.setImageResource(R.drawable.icing_sugar_icon);
                calculateForProduct(178.5f, 25, 10);
                break;
            case 13:
                textViewProduct.setText(getResources().getString(R.string.semolina));
                imageViewProduct.setImageResource(R.drawable.semolina_icon);
                calculateForProduct(166.6f, 25, 6);
                break;
            case 14:
                textViewProduct.setText(getResources().getString(R.string.hercules));
                imageViewProduct.setImageResource(R.drawable.hercules_icon);
                calculateForProduct(90, 1.8f, 3.5f);
                break;
            case 15:
                textViewProduct.setText(getResources().getString(R.string.starch));
                imageViewProduct.setImageResource(R.drawable.starch_icon);
                calculateForProduct(130, 8, 2.5f);
                break;
            case 16:
                textViewProduct.setText(getResources().getString(R.string.buckwheat));
                imageViewProduct.setImageResource(R.drawable.buckwheat_icon);
                calculateForProduct(208, 25, 3.5f);
                break;
            case 17:
                textViewProduct.setText(getResources().getString(R.string.cacao));
                imageViewProduct.setImageResource(R.drawable.cocao_icon);
                calculateForProduct(166.6f, 25, 9);
                break;
            case 18:
                textViewProduct.setText(getResources().getString(R.string.vegetable_oil));
                imageViewProduct.setImageResource(R.drawable.vegetable_oil_icon);
                calculateForProduct(188.6f, 17, 5);
                break;
            case 19:
                textViewProduct.setText(getResources().getString(R.string.butter));
                imageViewProduct.setImageResource(R.drawable.butter_icon);
                calculateForProduct(250, 15, 5);
                break;
            case 20:
                textViewProduct.setText(getResources().getString(R.string.clarified_butter));
                imageViewProduct.setImageResource(R.drawable.clarified_butter_icon);
                calculateForProduct(200, 20, 8);
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    private void calculateForProduct(float x1, float x2, float x3) {
        goDown();
        buttonCalculate.setOnClickListener(v -> {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            String textEditText = editTextProduct.getText().toString();
            if (textEditText.isEmpty()) {
                Toast.makeText(this, getResources().getString(R.string.info_for_toast), Toast.LENGTH_SHORT).show();
            } else {
                textViewGlass.setVisibility(View.VISIBLE);
                textViewTablespoon.setVisibility(View.VISIBLE);
                textViewTeaspoon.setVisibility(View.VISIBLE);
                int n = Integer.parseInt(textEditText);
                // Вычисляем и сохраняем значения sum1, sum2 и sum3
                sum1 = n / x1;
                sum2 = n / x2;
                sum3 = n / x3;
                String strSum1 = String.format("%.1f", sum1);
                String strSum2 = String.format("%.1f", sum2);
                String strSum3 = String.format("%.1f", sum3);
                textViewGlass.setText(strSum1 + " " + getResources().getString(R.string.cups));
                textViewTablespoon.setText(strSum2 + " " + getResources().getString(R.string.tablespoon));
                textViewTeaspoon.setText(strSum3 + " " + getResources().getString(R.string.teaspoon));

                int sit = getIntent().getIntExtra("sit", 0);
                if (sit == 8 || sit == 9 || sit == 14 || sit == 15 || sit == 16 || sit == 17 || sit == 19 || sit == 20) {
                    textViewGlass.setText(strSum1 + " " + getResources().getString(R.string.glass));
                }
            }
        });
        editTextProduct.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                goDown();
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextProduct.getWindowToken(), 0);
                    String textEditText = editTextProduct.getText().toString();
                    if (textEditText.isEmpty()) {
                        Toast.makeText(CalculateActivity.this, getResources().getString(R.string.info_for_toast), Toast.LENGTH_SHORT).show();
                    } else {
                        textViewGlass.setVisibility(View.VISIBLE);
                        textViewTablespoon.setVisibility(View.VISIBLE);
                        textViewTeaspoon.setVisibility(View.VISIBLE);
                        int n = Integer.parseInt(textEditText);
                        float sum1 = n / x1;
                        float sum2 = n / x2;
                        float sum3 = n / x3;
                        String strSum1 = String.format("%.1f", sum1);
                        String strSum2 = String.format("%.1f", sum2);
                        String strSum3 = String.format("%.1f", sum3);
                        textViewGlass.setText(strSum1 + " " + getResources().getString(R.string.cups));
                        textViewTablespoon.setText(strSum2 + " " + getResources().getString(R.string.tablespoon));
                        textViewTeaspoon.setText(strSum3 + " " + getResources().getString(R.string.teaspoon));

                        int sit = getIntent().getIntExtra("sit", 0);
                        if (sit == 8 || sit == 9 || sit == 14 || sit == 15 || sit == 16 || sit == 17 || sit == 19 || sit == 20) {
                            textViewGlass.setText(strSum1 + " " + getResources().getString(R.string.glass));
                        }
                    }
                        return true;
                }
                return false;
            }
        });
    }
    private void goDown() {
        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                scrollView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_DOWN));
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        int checkedRadioButtonId = radioGroupMode.getCheckedRadioButtonId();
        outState.putInt("checkedRadioButtonId", checkedRadioButtonId);
        String editTextContent = editTextProduct.getText().toString();
        outState.putString("editTextContent", editTextContent);
        outState.putInt("textViewGlassVisibility", textViewGlass.getVisibility());
        outState.putInt("textViewTablespoonVisibility", textViewTablespoon.getVisibility());
        outState.putInt("textViewTeaspoonVisibility", textViewTeaspoon.getVisibility());
        outState.putString("strSum1", textViewGlass.getText().toString());
        outState.putString("strSum2", textViewTablespoon.getText().toString());
        outState.putString("strSum3", textViewTeaspoon.getText().toString());
    }

}