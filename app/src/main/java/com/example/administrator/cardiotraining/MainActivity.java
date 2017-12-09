package com.example.administrator.cardiotraining;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.cardiotraining.Model.CardioItem;
import com.example.administrator.cardiotraining.adapter.CardioListAdapter;
import com.example.administrator.cardiotraining.db.CardioDb;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  ListView mListView;

    private CardioDb mHelper;
    private SQLiteDatabase mDb;



    private ArrayList<CardioItem> mCardioItemList = new ArrayList<>();
    private CardioListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new CardioDb(this);
        mDb = mHelper.getReadableDatabase();

        loadDataFromDb();

        mAdapter = new CardioListAdapter(
                this,
                R.layout.item,
                mCardioItemList
        );

        ListView lv = findViewById(R.id.list_view);
        lv.setAdapter(mAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, CardioDetailActivity.class);
                intent.putExtra("position", i);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 123) {
            if (resultCode == RESULT_OK) {
                loadDataFromDb();
                mAdapter.notifyDataSetChanged();
            }
        }
    }

    private void loadDataFromDb() {
        Cursor cursor = mDb.query(
                CardioDb.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        mCardioItemList.clear();


        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(CardioDb.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(CardioDb.COL_TITLE));
            String picture = cursor.getString(cursor.getColumnIndex(CardioDb.COL_PICTURE));
            String detail = cursor.getString(cursor.getColumnIndex(CardioDb.COL_ID));


            CardioItem item = new CardioItem(id, title, picture,detail);
            mCardioItemList.add(item);

        }

    }

}