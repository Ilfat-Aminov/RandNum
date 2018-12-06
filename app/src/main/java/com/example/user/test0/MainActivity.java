package com.example.user.test0;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onClick(View view) {
        InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(),  InputMethodManager.HIDE_NOT_ALWAYS);
        }
        Random random = new Random();
        try {
            Integer number = Integer.parseInt((editText3.getText().toString()));
            int[] numbers = new int[number];
            for (int i = 0; i < number; i++) {
                numbers[i] = Integer.parseInt(editText1.getText().toString()) + random.nextInt(Integer.parseInt(editText2.getText().toString()) + 1 - Integer.parseInt(editText1.getText().toString()));
            }
            Arrays.sort(numbers);
            StringBuilder sb = new StringBuilder();
            int colorInt;
            String colorCode;
            for (int i = 0; i < number; i++){
                colorInt = random.nextInt(0xffffff + 1);
                colorCode = String.format("#%06x", colorInt);
                sb.append("<font color=").append(colorCode).append(">").append(Integer.toString(numbers[i])).append("  </font>");
            }
            textView.setText(Html.fromHtml(sb.toString()));
        } catch (Exception e) {
            textView.setText(Html.fromHtml("<font color=#ff0000> Произошёл еггог! </font>"));
        }
     }
}
