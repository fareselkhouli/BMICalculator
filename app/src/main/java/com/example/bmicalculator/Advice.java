/**
 * @FaresElkhouli
 * @ZhiyuFeng
 */
package com.example.bmicalculator;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Advice extends AppCompatActivity {
    //instantiate objects
    ImageView bmiPicture;
    Button BackButton;
    TextView AdviceBmiout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);

        AdviceBmi = findViewById(R.id.adviceOutput);
        BackButton = findViewById(R.id.BackButton);
        bmiPicture = findViewById(R.id.imageOutput);

    }

    public void GetAdviceclicked(View view){
        double bmi = Double.parseDouble(bmiOut.getText().toString());
        if (bmi<18){
            AdviceBmiout.setText("Under Weight");
            bmiPicture.setImageResource(R.id.bmichart);
        } else if (18<=bmi<23){
            AdviceBmiout.setText("Normal");
            bmiPicture.setImageResource(R.id.bmichart2);
        } else if (23<=bmi<27){
            AdviceBmiout.setText("Over Weight");
            bmiPicture.setImageResource(R.id.bmichart3);
        } else if (bmi>=27){
            AdviceBmiout.setText("Obesity");
            bmiPicture.setImageResource(R.id.bmichart4);
        }
    }

    public void BackButtonclicked(View view){
        TransitionManager.go(activity_main);
    }



}
