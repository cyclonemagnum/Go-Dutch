package com.example.naruto.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String amount;
    EditText totalAmount,persNbr;
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalAmount = (EditText) findViewById(R.id.etAmount);
        persNbr = (EditText) findViewById(R.id.etNbr);
        display = (TextView) findViewById(R.id.tvAmountPerPerson);
    }

    public void btnCompute(View v){
        if(totalAmount.length()==0 || persNbr.length()==0)
            Toast.makeText(getBaseContext(), "Please enter the amount or the Number",Toast.LENGTH_SHORT).show();
        else{
            Double total = Double.parseDouble(totalAmount.getText().toString());
            if(total>0)
            {
                Double persons = Double.parseDouble(persNbr.getText().toString());
                if(persons>1)
                {
                    Double share = total/persons;
                    share = Double.valueOf(Math.round(share*100));
                    share = share / 100;

                    //Toast.makeText(getBaseContext(), "the amount to share is : "+ share ,Toast.LENGTH_SHORT).show();
                    amount=String.valueOf(share);
                    display.setText(amount);
                }
                else
                {
                    if(persons==1)
                        Toast.makeText(getBaseContext(), "Sorry! this app is not appropriate for Single! XD" ,Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getBaseContext(), "The number should be greater than 0." ,Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(getBaseContext(), "The amount should be greater than 0. ",Toast.LENGTH_SHORT).show();
            }
        }


    }

}
