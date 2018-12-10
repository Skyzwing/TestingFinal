package it.application.mobile.android.sleep.testingfinal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeFragment extends Fragment {
    private EditText name;
    private Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initNameBtn();
    }

    void initNameBtn(){
        name = getView().findViewById(R.id.home_name);

        button = getView().findViewById(R.id.button_name);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((name.getText().toString().length() < 3) && !(Character.isUpperCase(name.getText().toString().charAt(0)))){
                    Toast.makeText(getActivity(),"กรุณากรอกข้อมูลให้ถูกต้อง",Toast.LENGTH_SHORT).show();
                }
                else if (name.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Name isn't empty. Please tell your name.", Toast.LENGTH_SHORT).show();
                }
                else{
//                    เก็บ name ไว่ในความจำของเครื่องตัวเอง
                    SharedPreferences.Editor sp = getContext().getSharedPreferences("name", Context.MODE_PRIVATE).edit();
                    sp.putString("username", name.getText().toString());
                    sp.commit();

                    SharedPreferences spShow = getContext().getSharedPreferences("name", Context.MODE_PRIVATE);
                    getFragmentManager().beginTransaction().replace(R.id.main_view, new MenuFragment()).commit();
                }
            }
        });
    }
}
