package com.example.administrator.cardiotraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menupage extends AppCompatActivity {
    private Button mStartbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupage);

        mStartbutton = findViewById(R.id.Startbutton);

        mStartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menupage.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
