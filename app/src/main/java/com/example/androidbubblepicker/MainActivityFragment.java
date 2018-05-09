package com.example.androidbubblepicker;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    BubblePicker bubblePicker;

    //use arraylist to add new objects
    String[] name = {
            "Neith",
            "Artemis",
            "Jing Wei",
            "Izanami",
            "Skadi"
    };

    int[] images = {
            R.mipmap.neith_round,
            R.mipmap.artemis_round,
            R.mipmap.jing_wei_round,
            R.mipmap.izanami_round,
            R.mipmap.skadi_round
    };

    int[] colors = {
            Color.parseColor("#8B4513"),
            Color.parseColor("#4B0082"),
            Color.parseColor("#CCCC00"),
            Color.parseColor("#8B0000"),
            Color.parseColor("#F0FFFF")
    };

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        bubblePicker = (BubblePicker)view.findViewById(R.id.picker);
        ArrayList<PickerItem> listItems = new ArrayList<>();

        for (int i = 0; i < name.length; ++i) {
            PickerItem item = new PickerItem(name[i], colors[i], Color.WHITE, ContextCompat.getDrawable(getContext(), images[i]));
            listItems.add(item);
        }

        bubblePicker.setItems(listItems);

        bubblePicker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(PickerItem pickerItem) {
                Toast.makeText(getActivity().getApplicationContext(), "" + pickerItem.getTitle() + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBubbleDeselected(PickerItem pickerItem) {
                Toast.makeText(getActivity().getApplicationContext(), "" + pickerItem.getTitle() + " deselected", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
