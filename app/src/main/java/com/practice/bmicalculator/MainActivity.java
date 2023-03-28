package com.practice.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView result = findViewById(R.id.BMI_Result);
        TextInputEditText height= findViewById(R.id.Height_Id);
        TextInputEditText weight = findViewById(R.id.Weight_Id);
        Button calc= findViewById(R.id.Calculate);
        Button reset = findViewById(R.id.Reset);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bmi=0.0;
                if (isInputValid(height, weight)) {
                    double h = Double.parseDouble(height.getText().toString());
                    double w = Double.parseDouble(weight.getText().toString());
                    bmi = w / (h * h);

                } else {
                    Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_SHORT).show();
                }

                result.setText(Double.toString(bmi));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height.setText("");
                weight.setText("");
                result.setText("");
            }
        });
    }
    private boolean isInputValid(EditText height, EditText weight) {
        return (!height.getText().toString().trim().isEmpty()) && (!weight.getText().toString().trim().isEmpty()) ;
    }
}