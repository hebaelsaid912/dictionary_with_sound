package com.example.android.multiactivites;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        final ArrayList<words> words = new ArrayList<words>();
        words.add(new words("Where are you going?" , "minto wuksus", 0 , R.raw.phrase_where_are_you_going));
        words.add(new words("What is your name?" , "tinnә oyaase'nә", 0 , R.raw.phrase_what_is_your_name));
        words.add(new words("My name is..." , "oyaaset...",0,R.raw.phrase_my_name_is));
        words.add(new words("How are you feeling?" , "michәksәs?",0,R.raw.phrase_how_are_you_feeling));
        words.add(new words("I’m feeling good." , "kuchi achit", 0 , R.raw.phrase_im_feeling_good));
        words.add(new words("Are you coming?" , "әәnәs'aa?",0,R.raw.phrase_are_you_coming));
        words.add(new words("Yes, I’m coming." , "hәә’ әәnәm",0,R.raw.phrase_yes_im_coming));
        words.add(new words("I’m coming." , "әәnәm",0,R.raw.phrase_im_coming));
        words.add(new words("Let’s go." , "yoowutis", 0, R.raw.phrase_lets_go));
        words.add(new words("Come here." , "әnni'nem",0,R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, words,R.color.phrases);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Phrases.this ,"Clicked" , Toast.LENGTH_LONG ).show();
                words word = words.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(Phrases.this, word.getmMiwokSoundResourses());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(Phrases.this, "Music is Done !" ,Toast.LENGTH_LONG).show();
                        releaseMediaPlayer();
                    }
                });
            }
        });
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
}
