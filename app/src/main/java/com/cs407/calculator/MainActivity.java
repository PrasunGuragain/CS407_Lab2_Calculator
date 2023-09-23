package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void addFunction(View view){
        double[] result = textToInt();
        if (result[2] != 1) {
            double addResult = result[0] + result[1];
            goToActivity(addResult);
        }
    }
    public void subFunction(View view){
        double[] result = textToInt();
        if (result[2] != 1) {
            double addResult = result[0] - result[1];
            goToActivity(addResult);
        }
    }
    public void mulFunction(View view){
        double[] result = textToInt();
        if (result[2] != 1) {
            double addResult = result[0] * result[1];
            goToActivity(addResult);
        }
    }
    public void divFunction(View view){
        double[] result = textToInt();
        if (result[2] != 1) {
            if (result[1] == 0) {
                Toast.makeText(MainActivity.this, "Can't divide by zero!", Toast.LENGTH_LONG).show();
            } else {
                double addResult = result[0] / result[1];
                goToActivity(addResult);
            }
        }
    }
    public void goToActivity(double i){
        Intent intent = new Intent(this, CalculatorOutput.class);
        intent.putExtra("message", i);
        startActivity(intent);
    }
    public double[] textToInt(){
        EditText firstNumber = (EditText) findViewById(R.id.editText1);
        EditText secondNumber = (EditText) findViewById(R.id.editText2);
        String firstNumberString = firstNumber.getText().toString();
        String secondNumberString = secondNumber.getText().toString();
        double[] result = new double[3];
        try {
            result[0] = Double.parseDouble(firstNumberString);
            result[1] = Double.parseDouble(secondNumberString);
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "One or both the characters were not a number!", Toast.LENGTH_LONG).show();
            result[2] = 1;
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}