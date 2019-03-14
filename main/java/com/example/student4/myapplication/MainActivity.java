package com.example.student4.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int money = 100000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);
        final EditText editText2 = findViewById(R.id.editText2);

        Button button = (Button)findViewById(R.id.Button);
        button.setOnClickListener( new View.OnClickListener() {
            double a;
            @Override
            public void onClick(View v) {
                String S1 = editText2.getText().toString();
                a = Double.parseDouble(S1);
                money +=a;
                textView.setText("Tvoi den'gi: \n" + money); }
        });

    }
}

