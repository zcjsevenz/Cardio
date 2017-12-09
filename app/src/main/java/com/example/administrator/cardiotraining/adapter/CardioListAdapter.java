package com.example.administrator.cardiotraining.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.cardiotraining.MainActivity;
import com.example.administrator.cardiotraining.Model.CardioItem;
import com.example.administrator.cardiotraining.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Administrator on 8/12/2560.
 */

public class CardioListAdapter extends ArrayAdapter<CardioItem> {

    private Context mContext;
    private int mLayoutResId;
    private ArrayList<CardioItem> mcardioitem;

    public CardioListAdapter(@NonNull MainActivity context, int layoutResId, @NonNull ArrayList<CardioItem> cardioItems) {
        super(context, layoutResId, cardioItems);

        this.mContext = context;
        this.mLayoutResId = layoutResId;
        this.mcardioitem = cardioItems;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId, null);

        CardioItem item =mcardioitem.get(position);

        ImageView cardioImageView = itemLayout.findViewById(R.id.cardio_image_view);
        TextView cardioTitleTextView = itemLayout.findViewById(R.id.cardio_title_text_view);

        cardioTitleTextView.setText(item.title);
        String pictureFileName = item.picture;

        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = am.open(pictureFileName);
            Drawable drawable = Drawable.createFromStream(stream, null);
            cardioImageView.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();

            File pictureFile = new File(mContext.getFilesDir(), pictureFileName);
            Drawable drawable = Drawable.createFromPath(pictureFile.getAbsolutePath());
            cardioImageView.setImageDrawable(drawable);
        }

        return itemLayout;
    }
}
