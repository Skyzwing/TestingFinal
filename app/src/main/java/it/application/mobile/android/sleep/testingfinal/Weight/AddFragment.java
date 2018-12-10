package it.application.mobile.android.sleep.testingfinal.Weight;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import it.application.mobile.android.sleep.testingfinal.MenuFragment;
import it.application.mobile.android.sleep.testingfinal.R;

public class AddFragment extends Fragment{

    private SQLiteDatabase database;
    private EditText weight_add, date_add;
    private Weight itemWeight;
    private Button button;

    ContentValues contentValues;
    public AddFragment(){
        contentValues = new ContentValues();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initSaveBtn();
    }

    void initSaveBtn(){
        button = getView().findViewById(R.id.add_weight_form);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_add = getView().findViewById(R.id.date_form);
                weight_add = getView().findViewById(R.id.weight_form);
                String date_add_string = date_add.getText().toString();
                String weight_add_string = weight_add.getText().toString();
                int weight_add_int = Integer.parseInt(weight_add_string);
                database = getActivity().openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);

                SharedPreferences ssShow = getContext().getSharedPreferences("name", Context.MODE_PRIVATE);
                String name = ssShow.getString("username", "0");

                database.execSQL("DROP TABLE IF EXISTS " + name);

                database.execSQL("CREATE TABLE IF NOT EXISTS " + name + "(_id INTEGER PRIMARY KEY AUTOINCREMENT , date VARCHAR(15), weight VARCHAR(15))");

                Weight item = new Weight();

                item.setContent(date_add_string, weight_add_int);

                contentValues = item.getContent();

                Log.d("test", "INSERT ALREADY");
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_view, new MenuFragment()).addToBackStack(null)
                        .commit();
            }
        });
    }
}
