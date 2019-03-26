package com.example.student4.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Birzha_Thread t1 = new Birzha_Thread ("ttt");
    int money = 100000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        t1.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);
        final EditText editText2 = findViewById(R.id.editText2);
        Button button = (Button)findViewById(R.id.Button);
        button.setOnClickListener( new View.OnClickListener() {
            double a;
            @Override
            public void onClick(View v) {
                money += t1.getID();
                textView.setText("Tvoi den'gi: \n" + money); }
        });


    }
}

