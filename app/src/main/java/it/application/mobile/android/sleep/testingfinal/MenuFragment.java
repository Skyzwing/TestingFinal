package it.application.mobile.android.sleep.testingfinal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import it.application.mobile.android.sleep.testingfinal.Weight.AddFragment;

public class MenuFragment extends Fragment {

    private Button button;
    private ArrayList<String> menu;
    private ListView listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public MenuFragment(){
        menu = new ArrayList<>();
        menu.add("Add");
        menu.add("View");
        menu.add("Theme");
        menu.add("Load image from url");
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, menu);
        listView = getView().findViewById(R.id.list_menu);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (menu.get(position) == "Add"){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new AddFragment()).commit();
                }
                else if(menu.get(position) == "View"){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new AddFragment()).commit();
                }
                else if (menu.get(position) == "Theme"){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new AddFragment()).commit();
                }
                else if (menu.get(position) == "Load image from url"){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_view, new AddFragment()).commit();
                }

            }
        });
    }
}
