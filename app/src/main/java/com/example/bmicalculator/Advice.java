package com.example.bmicalculator;
/**
 * @FaresElkhouli
 * @ZhiyuFeng
 */

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

public class Advice extends AppCompatActivity {

    ImageView imageOut;
    TextView adviceOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adviceOut = findViewById(R.id.adviceOut);
        imageOut = findViewById(R.id.imageOut);
        double defaultVal = -1;
        double bmiThresh1 = 18.5;
        double bmiThresh2 = 24.9;
        double bmiThresh3 = 29.9;

        double bmi = getIntent().getDoubleExtra("bmi",defaultVal);
        if(bmi == defaultVal){
            Toast toast = Toast.makeText(Advice.this, "Error please go back and try again",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (bmi<bmiThresh1){
            adviceOut.setText("Under Weight");
            imageOut.setImageResource(R.drawable.bmichart);
        } else if (bmi >= bmiThresh1 && bmi < bmiThresh2){
            adviceOut.setText("Normal");
            imageOut.setImageResource(R.drawable.bmichart2);
        } else if (bmi >= bmiThresh2 && bmi < bmiThresh3){
            adviceOut.setText("Over Weight");
            imageOut.setImageResource(R.drawable.bmichart3);
        } else if (bmi>=bmiThresh3){
            adviceOut.setText("Obese");
            imageOut.setImageResource(R.drawable.bmichart4);
        }
    }

}
