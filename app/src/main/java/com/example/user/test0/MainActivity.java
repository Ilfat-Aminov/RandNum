package com.example.user.test0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
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
        try {
            Integer number = Integer.parseInt((editText3.getText().toString()));
            int[] numbers = new int[number];
            for (int i = 0; i < number; i++) {
                numbers[i] = Integer.parseInt(editText1.getText().toString()) + random.nextInt(Integer.parseInt(editText2.getText().toString()) + 1 - Integer.parseInt(editText1.getText().toString()));
            }
            Arrays.sort(numbers);
            StringBuilder sb = new StringBuilder();
            int color = 0;
            int colorMultiplier = 1;
            sb.append("<font color=#0000ff>");
            for (int i = 0; i < number; i++){
                if ((numbers[i] > 100 * colorMultiplier) && (color < 1)) {
                    sb.append("</font> <font color=#00ff00>");
                    color++;
                }
                if ((numbers[i] > 100 + 100 * colorMultiplier) && (color < 2)) {
                    sb.append("</font> <font color=#800080>");
                    color++;
                }
                if ((numbers[i] > 200 + 100 * colorMultiplier) && (color < 3)) {
                    sb.append("</font> <font color=#ff0000>");
                    color++;
                }
                if ((numbers[i] > 300 + 100 * colorMultiplier) && (color < 4)) {
                    sb.append("</font> <font color=#0000ff>");
                    color = 0;
                    colorMultiplier += 4;
                }
                sb.append(Integer.toString(numbers[i]));
                sb.append("  ");
            }
            sb.append("</font>");
            textView.setText(Html.fromHtml(sb.toString()));
        } catch (Exception e) {
            textView.setText(Html.fromHtml("<font color=#ff0000> SOMETHING WRONG, BLET(((</font>"));
        }
     }
}
