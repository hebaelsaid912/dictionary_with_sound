package com.example.android.multiactivites;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);

        final ArrayList<words> words = new ArrayList<words>();
        words.add(new words("father" , "әpә" , R.drawable.family_father, R.raw.family_father));
        words.add(new words("mother" , "әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new words("son" , "angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new words("daughter" , "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new words("older brother" , "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new words("younger brother" , "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new words("older sister" , "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new words("younger sister" , "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new words("grandmother " , "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new words("grandfather" , "paapa", R.drawable.family_grandfather, R.raw.family_grandmother));

        WordAdapter adapter = new WordAdapter(this, words,R.color.family);
        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FamilyMembers.this ,"Clicked" , Toast.LENGTH_LONG ).show();
                words word = words.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(FamilyMembers.this, word.getmMiwokSoundResourses());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(FamilyMembers.this,"Music is done !" , Toast.LENGTH_LONG).show();
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
