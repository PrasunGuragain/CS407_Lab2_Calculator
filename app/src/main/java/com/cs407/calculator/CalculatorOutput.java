package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculatorOutput extends AppCompatActivity {
    TextView textView;
    public void backFunction(View view){
        goToActivity();
    }
    public void goToActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_output);

        textView = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        Double d = intent.getDoubleExtra("message", 0);
        textView.setText(String.valueOf(d));
    }
}