package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id for Grade calculator and Result
        TextView Calculator = findViewById(R.id.Gradecal);
        TextView Result = findViewById(R.id.result);

        //id for the input(quizes,hw etc)
        EditText quizes = findViewById(R.id.Quizes);
        EditText homework = findViewById(R.id.HW);
        EditText Midterms = findViewById(R.id.MT);
        EditText Finals = findViewById(R.id.Final);

        //id for the buttons
        Button Calcualte = findViewById(R.id.bttnCalculate);
        Button Reset = findViewById(R.id.bttnReset);

        //id for the confetti gif
        pl.droidsonroids.gif.GifImageView Gif = findViewById(R.id.gif);
        Gif.animate().alpha(0).setDuration(3000);



        //set on click for the calculate button
        Calcualte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(quizes.getText().toString());
                int n2 = Integer.parseInt(homework.getText().toString());
                int n3 = Integer.parseInt(Midterms.getText().toString());
                int n4 = Integer.parseInt(Finals.getText().toString());
                int results = n1 + n2 + n3 + n4;
                Result.setText(String.valueOf(results)+"%");
                System.out.println(appear( n1, n2, n3, n4));



                /*if statment to change the color of the results if they passed or not
                + (confetti appears if they get 90+)
                 */
                int x = 50;
                int y = 90;
                if (results > y) {
                    Result.setTextColor(getResources().getColor(R.color.Passed));
                    Gif.animate().alpha(1).setDuration(3000);


                }else if (results > x){
                    Result.setTextColor(getResources().getColor(R.color.Passed));
                }
                else{

                    Result.setTextColor(getResources().getColor(R.color.failed));

                }

            }
        });


        //set on click for Reset button (طلعته من youtube)
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Reset for the Edittexts
                quizes.setText(null);
                quizes.dispatchDisplayHint(view.VISIBLE);
                homework.setText(null);
                homework.dispatchDisplayHint(view.VISIBLE);
                Midterms.setText(null);
                Midterms.dispatchDisplayHint(view.VISIBLE);
                Finals.setText(null);
                Finals.dispatchDisplayHint(view.VISIBLE);

                //Reset for the Result button
                Result.setText("Result");

                //Reset for the color of the Result button
                Result.setTextColor(getResources().getColor(R.color.original));

                //Reset for the confetti gif
                Gif.animate().alpha(0).setDuration(3000);

            }
        });


    };


    //function for the calculate button
    public static int appear(int number1,int number2, int number3, int number4){
        int percent = number1*15/100 + number2*25/100 + number3*30/100 +number4*30/100;
        return percent ;

    }




}
