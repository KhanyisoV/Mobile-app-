package com.example.practical41;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
double fees = 25000.00;
double perc = 0.30;
double minPayment;
double feespaid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        final TextView output = (TextView) findViewById(R.id.textOutput);
        final EditText input = (EditText) findViewById(R.id.inputTxt);
        final Button calculate = (Button) findViewById(R.id.button2);
        final RadioButton radio = (RadioButton) findViewById(R.id.radioButton);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feespaid = Double.parseDouble(input.getText().toString());
                DecimalFormat rounded = new DecimalFormat("R ###.##");

                minPayment =fees - (fees * perc);
                output.setText(rounded.format(minPayment));

                if(feespaid < minPayment)
                {
                    Toast.makeText(MainActivity.this, "Not allowed to register!, pay a minimum of 30% of 25000 fee",Toast.LENGTH_LONG).show();
                }
                else
                {
                    radio.setChecked(true);
                    Toast.makeText(MainActivity.this, "Successfully Registered!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}