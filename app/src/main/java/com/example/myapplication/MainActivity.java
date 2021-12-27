package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populatelistview();
        addlensbutton();


    }

    private void addlensbutton() {
        Button addlensbtn = (Button) findViewById(R.id.addlensbutton);
        addlensbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Addlens.Launch(MainActivity.this, "Addlens");
                startActivityForResult(intent, 42);


            }
        });
    }


    private void populatelistview() {
        ALensManager manager = ALensManager.getInstance();
        int managersize = manager.getlistsize();
        String[] x1 = new String[managersize];
        int count = 0;
        for (ALens lense : manager) {
            x1[count] = lense.toString();
            count++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.da_item, x1);
        ListView list = (ListView) findViewById(R.id.listviewid);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent1 = new Intent(MainActivity.this, Depthfield.class);
                    intent1.putExtra("Lensname", 0);
                    startActivity(intent1);

                }
                if (position == 1) {
                    Intent intent2 = new Intent(MainActivity.this, Depthfield.class);
                    intent2.putExtra("Lensname", 1);
                    startActivity(intent2);
                }
                if (position == 2) {
                    Intent intent3 = new Intent(MainActivity.this, Depthfield.class);
                    intent3.putExtra("Lensname", 2);
                    startActivity(intent3);

                }


                if (position == 3) {
                    Intent intent4 = new Intent(MainActivity.this, Depthfield.class);
                    intent4.putExtra("Lensname", 3);
                    startActivity(intent4);

                } if(position==4){
                    Intent intent5 =new Intent(MainActivity.this,Depthfield.class);
                    intent5.putExtra("Lensname",4);
                    startActivity(intent5);

                }if(position==5) {
                    Intent intent6=new Intent(MainActivity.this,Depthfield.class);
                    intent6.putExtra("Lensname",5);
                    startActivity(intent6);

                }if(position==6){
                    Intent intent7=new Intent(MainActivity.this,Depthfield.class);
                    intent7.putExtra("Lensname",6);
                    startActivity(intent7);

                }




            }
        });













    }


        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            switch (requestCode) {
                case 42:
                    int answer = data.getIntExtra("result", 0);
                    if (answer == 1)
                        populatelistview();
                    break;

            }
        }




    }



