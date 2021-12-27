package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class Addlens extends AppCompatActivity {
    String make,aperturestring,lastfocallength,lastaperture;
    String focalstring="300";
    int lengthfocal;
    double aperturemm;
    private ALensManager manager;
    private EditText editmake;
    private EditText editaperture;
    private EditText editlengthfocal;
    private static final String message="Extra_message";
    public static Intent Launch(Context c,String message2){
        Intent intent=new Intent(c,Addlens.class);
        intent.putExtra(message,message2);
        return intent;
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlens);

        editmake=(EditText) findViewById(R.id.editTextTextPersonName4);
        editaperture=(EditText) findViewById(R.id.editTextTextPersonName);
        editlengthfocal=(EditText) findViewById(R.id.editTextTextPersonName5);
        editmake.addTextChangedListener(editwatcher);
        editaperture.addTextChangedListener(editwatcher);
        editlengthfocal.addTextChangedListener(editwatcher);


        cancelbutton();
        saveButton();

    }
    private TextWatcher editwatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            make=editmake.getText().toString().trim();
            lastfocallength=editlengthfocal.getText().toString();
            lastaperture=editaperture.getText().toString();



        }

        @Override
        public void afterTextChanged(Editable s) {


        }
    };








    private void saveButton(){
        Button ss=(Button) findViewById(R.id.savebutton);
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ALens lense22=new ALens(make,(Double.valueOf(lastaperture)),(Integer.valueOf(lastfocallength)));
                manager=ALensManager.getInstance();
                manager.add(lense22);

                Intent intent=new Intent();
                intent.putExtra("result", 1);
                setResult(Activity.RESULT_OK, intent);
                finish();






            }
        });
    }

    private void cancelbutton(){
        Button cancel=(Button) findViewById(R.id.cancelnuttonid);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                setResult(Activity.RESULT_CANCELED,intent);
                finish();

            }
        });
    }





}