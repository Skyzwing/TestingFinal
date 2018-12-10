package it.application.mobile.android.sleep.testingfinal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class LoadImageFragment extends Fragment{
    private String url;
    private ImageView imageView;
    private EditText urlField;
    private Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_loadimage, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initBtnProcessed();
    }

    void initBtnProcessed(){
        imageView = getView().findViewById(R.id.image_loadImage);
        urlField = getView().findViewById(R.id.url_loadimage);
        button = getView().findViewById(R.id.button_loadImage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = urlField.getText().toString();
                Picasso.with(getActivity()).load(url).into(imageView);
            }
        });
    }
}
