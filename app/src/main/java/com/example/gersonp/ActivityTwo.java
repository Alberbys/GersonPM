
package com.example.gersonp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTwo extends AppCompatActivity {

    Button btncreate, btnlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        btncreate = (Button)findViewById(R.id.btncreate);
        btnlist = (Button)findViewById(R.id.btnlist);

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcreate = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentcreate);



            }
        });

        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentcreate = new Intent(getApplicationContext(), ActivityList.class);
                startActivity(intentcreate);

            }
        });


    }
}