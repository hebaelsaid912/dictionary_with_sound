package com.example.android.multiactivites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

class WordAdapter extends ArrayAdapter<words> {
    private  int colorID ;
    public WordAdapter(Context context, ArrayList<words> words , int colorID) {
        super(context, 0, words);
        this.colorID = colorID;
    }
/*
    public WordAdapter(Numbers numbers, ArrayList<words> words) {
        super(numbers, 0, words);
    }

    public WordAdapter(Phrases phrases, ArrayList<words> words) {
        super(phrases, 0, words);
    }

    public WordAdapter(FamilyMembers family, ArrayList<words> words) { super(family,0,words); }

    public WordAdapter(Colors colors, ArrayList<words> words) { super(colors,0,words); }*/

    @NonNull
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position

        words words = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }

        // Lookup view for data population
        ImageView mMiwokImageResourses = (ImageView) convertView.findViewById(R.id.mMiwokImageResourses) ;
        TextView mDefualtTranslation = (TextView) convertView.findViewById(R.id.DefualtTranslation);
        TextView mMiwokTranslation = (TextView) convertView.findViewById(R.id.MiwokTranslation);

        // Populate the data into the template view using the data object
        if (words.hasNOImage()==true) {
            mMiwokImageResourses.setImageResource(words.getmMiwokImageResourses());
        }else {
            mMiwokImageResourses.setVisibility(View.GONE);
        }
        mDefualtTranslation.setText(words.getmDefualtTranslation());
        mMiwokTranslation.setText(words.getmMiwokTranslation());
        //colors
        View textContainer = convertView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),colorID);
        textContainer.setBackgroundColor(color);

        return convertView;

    }
}
