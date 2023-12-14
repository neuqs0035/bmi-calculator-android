package com.example.bmi_calculator_android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the Button inside the onCreate method
        Button myButton = findViewById(R.id.submit);

        // Set an OnClickListener for the Button
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText ed1 = findViewById(R.id.height);
                EditText ed2 = findViewById(R.id.weight);

                String strheight = ed1.getText().toString();
                String strweight = ed2.getText().toString();

                if(strheight.equals("") || strweight.equals("")){
                    Toast.makeText(MainActivity.this, "Please Enter Values", Toast.LENGTH_SHORT).show();
                }
                else{
                    String message = "";
                    double height = Double.parseDouble(strheight);
                    double weight = Double.parseDouble(strweight);

                    double bmi = weight / ( (height / 100) * 2);

                    if(bmi<18.5){
                        message = "You Are Underweight , Your BMI Is " + bmi;
                    }
                    else if(bmi<24.9 && bmi>18.5){
                        message = "You Are Normal , Your BMI Is " + bmi;
                    }
                    else{
                        message = "You Are Overweight , Your BMI Is " + bmi;
                    }

                    TextView output = findViewById(R.id.output);
                    output.setText(message);
                }
            }
        });
    }

}
