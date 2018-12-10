package it.application.mobile.android.sleep.testingfinal.Weight;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import it.application.mobile.android.sleep.testingfinal.R;

public class WeightAdapter extends ArrayAdapter<Weight> {

    List<Weight> weights = new ArrayList<Weight>();
    Context context;
    private View view;
    private TextView weight, date;

    public WeightAdapter(Context context, int resource, List<Weight> obj){
        super(context, resource, obj);
        this.weights = obj;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.fragment_weight_item, parent, false);
        weight = view.findViewById(R.id.weight_item);
        date = view.findViewById(R.id.date_item);
        weight.setText(weights.get(position).getWeight());
        date.setText(weights.get(position).getDate());
        return view;
    }
}
