package com.example.administrator.cardiotraining;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.cardiotraining.Model.CardioItem;

public class CardioDetailActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_detail);

        ImageView locationImageView = findViewById(R.id.cardioImageView);
        TextView detailTextView = findViewById(R.id.detailTextView);

        Intent intent = getIntent();
        int position = intent.getIntExtra("positon",0);
        CardioData cardioData = CardioData.getsInstance();
        CardioItem cardio = cardioData.cadioList.get(position);

        String name = cardio.title;
        String detail = cardio.detail;
        Drawable drawable = cardio.getPictureDrawable(this);

        locationImageView.setImageDrawable(drawable);
        detailTextView.setText(detail);

        getActionBar().setTitle(name);



    }
}