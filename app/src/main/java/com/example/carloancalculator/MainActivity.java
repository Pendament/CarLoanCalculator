package com.example.carloancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void initToggleButton () {
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void setForEditing () {
        EditText  price= (findViewById(R.id.editPrice));
        EditText  dpAmount = (findViewById(R.id.editDPAmount));
        EditText  iRate = (findViewById(R.id.editIRate));
        EditText  loanLength= (findViewById(R.id.editLoanLength));


    }
}