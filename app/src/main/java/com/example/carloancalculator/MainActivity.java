package com.example.carloancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView editPrice;
    private TextView editDPAmount;
    private TextView editIRate;
    private TextView editLoanLength;
    private TextView button;


//P = mr*L/(1-(1+mr)-n)
//P is the monthly payment
//mr is the monthly interest rate (which is the annual interest rate/12)
// L is the size of the loan or lease
// n is the number of payments (i.e. the number of months)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrice = findViewById(R.id.editPrice);
        editDPAmount = findViewById(R.id.editDPAmount);
        editIRate = findViewById(R.id.editIRate);
        editLoanLength = findViewById(R.id.editLoanLength);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

                if(toggleButton.isChecked()) {
                    //Lease

                    float ir = Float.parseFloat(editIRate.getText().toString());
                    float L = (Float.parseFloat(editPrice.getText().toString())/3)-Float.parseFloat(editDPAmount.getText().toString());
                    float mr = (ir/100/12);
                    int n = 36;

                    float mp1 = (mr)*(L);
                    float mp2 = (1+mr);
                    float mp3 = -n;
                    double p = Math.pow(mp2,mp3);
                    double q = 1-p;
                    double P = mp1/q;
                    button.setText("Your monthly lease payment is $"+String.format("%.2f",P)+".");

                } else {
                    //Loan
                    float ir = Float.parseFloat(editIRate.getText().toString());
                    float L = (Float.parseFloat(editPrice.getText().toString())-Float.parseFloat(editDPAmount.getText().toString()));
                    float mr = (ir/100)/12;
                    float n = Float.parseFloat(editLoanLength.getText().toString());

                    float mp1 = (mr)*(L);
                    float mp2 = (1+mr);
                    float mp3 = -n;
                    double p = Math.pow(mp2,mp3);
                    double q = 1-p;
                    double P = mp1/q;
                    button.setText("Your monthly lease payment is $"+String.format("%.2f",P)+".");


                }

            }
        });
    }}
