package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Depthfield extends AppCompatActivity {
    String apertureinput, distanceinput;
    ADepthofFeildCalculator newobj;

    ALensManager manager = ALensManager.getInstance();


    ALens lense1;

    EditText distancetosubject;
    EditText newaperture;


    double outnearfocal, outfarfocal, outdepthoffield, outhyperfocal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depthfield);
        Intent intent = getIntent();
        int igloo = intent.getIntExtra("Lensname", 0);
        lense1 = manager.getobjbyindex(igloo);

        distancetosubject = (EditText) findViewById(R.id.distanceinputid);
        newaperture = (EditText) findViewById(R.id.apertureinputid);
        distancetosubject.addTextChangedListener(editwatcher2);
        newaperture.addTextChangedListener(editwatcher2);
        calculatedepthoffield();


    }


    private TextWatcher editwatcher2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            distanceinput = distancetosubject.getText().toString().trim();
            apertureinput = newaperture.getText().toString().trim();


        }

        @Override
        public void afterTextChanged(Editable s) {


        }
    };

    private void calculatedepthoffield() {
        Button btn = (Button) findViewById(R.id.depthbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newobj=new ADepthofFeildCalculator(lense1,(1000*Double.valueOf(distanceinput)),(1000*Double.valueOf(apertureinput)));
                outnearfocal=newobj.getnearfocalpoint();
                TextView t1=(TextView) findViewById(R.id.textView11);
                t1.setText(""+(outnearfocal/1000));
                outfarfocal=newobj.getfarfocalpoint();
                TextView t2=(TextView) findViewById(R.id.textView12);
                t2.setText(""+(outfarfocal/1000));
                outdepthoffield=newobj.getdepthoffield();
                TextView t3=(TextView) findViewById(R.id.textView13);
                t3.setText(""+(outdepthoffield)/1000);

                outhyperfocal=newobj.gethyperfocaldistance();
                TextView t4=(TextView) findViewById(R.id.textView14);
                t4.setText(""+(outhyperfocal));




            }
        });


    }
}