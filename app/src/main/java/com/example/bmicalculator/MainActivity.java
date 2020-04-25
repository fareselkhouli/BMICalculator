/**
 * @FaresElkhouli
 * @ZhiyuFeng
 */
package com.example.bmicalculator;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //instantiate objects
    TextView weightIn;
    TextView heightIn;
    TextView bmiOut;
    RadioButton imperialButton;
    RadioButton metricButton;
    Button bmiButton;
    Button adviceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightIn = findViewById(R.id.weightInput);
        heightIn =  findViewById(R.id.heightInput);
        bmiOut = findViewById(R.id.bmiOutput);
        imperialButton = findViewById(R.id.imperialButton);
        metricButton = findViewById(R.id.metricButton);
        bmiButton =findViewById(R.id.bmiButton);
        adviceButton = findViewById(R.id.adviceButton);

    }

    public void calcBMI(View v){

        int weight = Integer.parseInt(weightIn.getText().toString());
        double height = Integer.parseInt(heightIn.getText().toString());
        if(weight == 0 || height == 0){
            Toast toast = Toast.makeText(MainActivity.this, "Invalid Input",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if(imperialButton.isChecked()){
            double bmi = imperialBMI(weight,height);
            bmiOut.setText(String.format("%.2f",bmi));
            return;
        }
        if(metricButton.isChecked()){
            double bmi = metricBMI(weight,height);
            bmiOut.setText(String.format("%.2f",bmi));
            return;
        }

        Toast toast = Toast.makeText(MainActivity.this, "Invalid Input Please Select a Measurement System",Toast.LENGTH_SHORT);
        toast.show();
    }

    private double imperialBMI(int height, double weight){
        int formulaMult = 703;
        double bmi = 0;
        bmi = (double) (weight*formulaMult) / (height*height);

        return bmi;
    }

    private double metricBMI(int height, double weight){
        double bmi = 0;
        bmi =(double) weight / (height * height);
        return bmi;
    }

    public void getAdv(View view){

    }

    public void imperialHint(View view) {
        weightIn.setHint("enter weight in lb");
        heightIn.setHint("enter height in inches");
    }

    public void metricHint(View v){
        weightIn.setHint("enter weight in kg");
        heightIn.setHint("enter height in meters");
    }
}
