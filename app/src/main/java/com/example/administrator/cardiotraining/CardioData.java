package com.example.administrator.cardiotraining;

import com.example.administrator.cardiotraining.Model.CardioItem;

import java.util.ArrayList;

/**
 * Created by Administrator on 8/12/2560.
 */

public class CardioData {

    private  static CardioData sInstance;
    public ArrayList<CardioItem> cadioList;

    public static CardioData getsInstance(){
        if(sInstance==null){
            sInstance=new CardioData();
        }
        return sInstance;
    }
}
