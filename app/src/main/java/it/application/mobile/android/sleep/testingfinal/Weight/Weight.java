package it.application.mobile.android.sleep.testingfinal.Weight;

import android.content.ContentValues;

public class Weight {
    private int weight;
    private String date;

    public Weight(){}

    public Weight(String date, int weight){
        this.date = date;
        this.weight = weight;
    }

//    ContentValue
    ContentValues row = new ContentValues();
    public ContentValues getContent() {
        return row;
    }

    public void setContent(String date, int weight){
        this.row.put("date", date);
        this.row.put("weight", weight);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
