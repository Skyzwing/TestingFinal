package it.application.mobile.android.sleep.testingfinal.Weight;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import it.application.mobile.android.sleep.testingfinal.R;
import it.application.mobile.android.sleep.testingfinal.Weight.Weight;
import it.application.mobile.android.sleep.testingfinal.Weight.WeightAdapter;

public class ViewFragment extends Fragment {

    private ListView listView;
    private WeightAdapter weightAdapter;
    private SQLiteDatabase database;

    ArrayList<Weight> weights = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

//    this page is see every thing is date and weight

    void initSeeWeightAndDate(){
        listView = getView().findViewById(R.id.list_weight_addPage);
//        custom listview => weights = name is keep array lst of weight
        weightAdapter = new WeightAdapter(getActivity(), R.layout.fragment_weight_item, weights);
//        Open to use database
        database = getActivity().openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("name", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("username", "0");

        database.execSQL(
                "CREATE TABLE IF NOT EXISTS " + name + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, date VARCHAR(15), weight VARCHAR(15)"
        );

        String date;
        int weight;
//        query database
        Cursor cursor = database.rawQuery("SELECT * FROM  " + name , null);

        weightAdapter.clear();

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            date = cursor.getString(1);
            weight = cursor.getInt(2);

            weights.add(new Weight(date, weight));
        }

        listView.setAdapter(weightAdapter);
        weightAdapter.notifyDataSetChanged();

        cursor.close();
        database.close();
    }
}
