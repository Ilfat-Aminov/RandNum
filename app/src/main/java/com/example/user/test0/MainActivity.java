package com.example.user.test0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
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

    public void onClick(View view) {
        Random random = new Random();
        Integer number = Integer.parseInt((editText3.getText().toString()));
        int[] numbers = new int[number];
        for (int i = 0; i < number; i++) {
            numbers[i] = Integer.parseInt(editText1.getText().toString()) + random.nextInt(Integer.parseInt(editText2.getText().toString()) + 1 - Integer.parseInt(editText1.getText().toString()));
        }
        Arrays.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++){
            sb.append(Integer.toString(numbers[i]));
            sb.append("  ");
        }
        textView.setText(sb);
     }
}
