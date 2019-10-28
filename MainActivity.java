package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int DIVIDE = 0;
    private final int ADD = 1;
    private final int SUBTRACT = 2;
    private final int REMAINDER = 3;
    private final int MULTIPLY = 4;
    private final int EXPONENT = 5;


    private TextView answerTextview;

    private float answerValue = 0.0f;
    private float firstValue = 0.0f;
    private float secondValue = 0.0f;
    private int operator = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerTextview = findViewById(R.id.main_textview);
    }

    private void clearField(){
        answerTextview.setText("0");
        secondValue = 0f;
        firstValue = 0f;
        operator = 0;
        answerValue = 0f;
    }

    private void setOperator(int operator){
        this.operator = operator;
        firstValue = Float.parseFloat(answerTextview.getText().toString());
        answerTextview.setText("0");
    }

    private void calculate(){
        secondValue = Float.parseFloat(answerTextview.getText().toString());

        switch (operator){
            case ADD:
                answerValue = firstValue + secondValue;
                break;
            case SUBTRACT:
                answerValue = firstValue - secondValue;
                break;
            case DIVIDE:
                answerValue = firstValue / secondValue;
                break;
            case REMAINDER:
                answerValue = firstValue % secondValue;
                break;

            case MULTIPLY:
                answerValue = firstValue * secondValue;
                break;

            case EXPONENT:
                answerValue= (float)Math.pow(firstValue,secondValue);
                break;


        }

        answerTextview.setText(answerValue+"");
    }


    private void addNumber(int value){
        if(answerTextview.getText().equals("0"))
            answerTextview.setText("");

        answerTextview.setText(answerTextview.getText().toString() + value);
    }

    private void removeNumber(){
        if(answerTextview.getText().toString().trim().length() > 0 && !answerTextview.getText().toString().equals("0"))
            answerTextview.setText(answerTextview.getText().toString().substring(0, answerTextview.length()-1));
    }



    public void onClick(View view) {
        float temp = 0;
        switch (view.getId()) {
            case R.id.clear_button:
                clearField();
                break;

            case R.id.addition_button:
                setOperator(ADD);
                break;

            case R.id.subtract_button:
                setOperator(SUBTRACT);
                break;

            case R.id.zero_button:
                addNumber(0);
                break;

            case R.id.one_button:
                addNumber(1);
                break;

            case R.id.two_button:
                addNumber(2);
                break;

            case R.id.three_button:
                addNumber(3);
                break;

            case R.id.four_button:
                addNumber(4);
                break;

            case R.id.five_button:
                addNumber(5);
                break;

            case R.id.six_button:
                addNumber(6);
                break;

            case R.id.seven_button:
                addNumber(7);
                break;

            case R.id.eight_button:
                addNumber(8);
                break;

            case R.id.nine_button:
                addNumber(9);
                break;

            case R.id.back_button:
                removeNumber();
                break;

            case R.id.division_button:
                setOperator(DIVIDE);
                break;

            case R.id.equals_button:
                calculate();
                break;

            case R.id.multiply_button:
                setOperator(MULTIPLY);
                break;

            case R.id.exponent_button:
                setOperator(EXPONENT);
                break;

            case R.id.sqrt_button:
                 temp = Float.parseFloat(answerTextview.getText().toString());
                 temp = (float)Math.sqrt(temp);
                answerTextview.setText(temp+"");
                break;

            case R.id.cosine_button:
                temp = Float.parseFloat(answerTextview.getText().toString());
                temp = (float)Math.cos(temp);
                answerTextview.setText(temp+"");
                break;

            case R.id.sine_button:
                temp = Float.parseFloat(answerTextview.getText().toString());
                temp = (float)Math.sin(temp);
                answerTextview.setText(temp+"");
                break;

            case R.id.tangent_button:
                temp = Float.parseFloat(answerTextview.getText().toString());
                temp = (float) Math.tan(temp);
                answerTextview.setText(temp+"");
                break;

            case R.id.cosh_button:
                temp = Float.parseFloat(answerTextview.getText().toString());
                temp = (float)Math.cosh(temp);
                answerTextview.setText(temp+"");
                break;

            case R.id.sinh_button:
                temp = Float.parseFloat(answerTextview.getText().toString());
                temp = (float)Math.sinh(temp);
                answerTextview.setText(temp+"");
                break;

            case R.id.tanh_button:
                temp = Float.parseFloat(answerTextview.getText().toString());
                temp =(float)Math.tanh(temp);
                answerTextview.setText(temp+"");
                break;

            case R.id.ln_button:
                temp = Float.parseFloat(answerTextview.getText().toString());
                temp =(float)Math.log(temp);
                answerTextview.setText(temp+"");
                break;

            case R.id.log_button:
                temp = Float.parseFloat(answerTextview.getText().toString());
                temp =(float)Math.log10(temp);
                answerTextview.setText(temp+"");
                break;

            case R.id.pi_button:
                temp = (float)Math.PI;
                answerTextview.setText(temp+"");
                break;

            case R.id.fraction_button:
                temp = Float.parseFloat(answerTextview.getText().toString());
                temp = (float)Math.pow(temp, -1);
                answerTextview.setText(temp+"");
                break;

            case R.id.factorial_button:
                temp = Float.parseFloat(answerTextview.getText().toString());
                int result = 0;
                for(int i = 1; i <= temp; i++){
                    result *= i;

                }
                answerTextview.setText(result+"");
                break;

            case R.id.absValue_button:
                temp = Float.parseFloat(answerTextview.getText().toString());
                temp = (float)Math.abs(temp);
                answerTextview.setText(temp+"");
                break;


            case R.id.posneg_button:
                temp = Float.parseFloat(answerTextview.getText().toString());
                temp = temp * -1;
                answerTextview.setText(temp+"");
                break;
        }
    }
}