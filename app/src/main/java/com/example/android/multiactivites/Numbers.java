package com.example.android.multiactivites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //    using ArrayList
        final ArrayList<words> words = new ArrayList<words>();
        words.add(new words("one" , "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new words("two" , "otiiko", R.drawable.number_two,R.raw.number_two));
        words.add(new words("three" , "tolookous", R.drawable.number_three, R.raw.number_three));
        words.add(new words("four" , "oyyisa", R.drawable.number_four , R.raw.number_four));
        words.add(new words("five" , "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new words("six" , "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new words("seven" , "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new words("eight" , "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new words("nine" , "we'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new words("ten" , "na'aacha", R.drawable.number_ten, R.raw.number_ten));




//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//        int index = 0 ;
//        while (index<10){
//            TextView wordView0 = new TextView(this);
//            wordView0.setText(words.get(index));
//            rootView.addView(wordView0);
//            index++;
//        }
       // ArrayAdapter<words> wordsArrayAdapter = new ArrayAdapter<>(this,R.layout.list_item,words);
        WordAdapter adapter = new WordAdapter(this ,words,R.color.numbers);
        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Numbers.this ,"Clicked" , Toast.LENGTH_LONG ).show();
                words word = words.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(Numbers.this, word.getmMiwokSoundResourses());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(Numbers.this, "Music is Done !" ,Toast.LENGTH_LONG).show();
                        releaseMediaPlayer();
                    }
                });
            }
        });


//        TextView wordView1 = new TextView(this);
//        wordView1.setText(words.get(1));
//        rootView.addView(wordView1);
//        TextView wordView2 = new TextView(this);
//        wordView2.setText(words.get(2));
//        rootView.addView(wordView2);
//        TextView wordView3 = new TextView(this);
//        wordView3.setText(words.get(3));
//        rootView.addView(wordView3);

    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    private void releaseMediaPlayer(){
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
//    using normal Array
//    String [] word = {"one","two","three", "four" , "five" , "six" , "seven" , "eight" , "nine" , "ten"};






}
