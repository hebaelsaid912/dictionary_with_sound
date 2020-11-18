package com.example.android.multiactivites;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NativeActivity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Colors extends AppCompatActivity {
private MediaPlayer mediaPlayer;
    private Context context;
    AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    AudioManager.OnAudioFocusChangeListener afChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

      final  ArrayList<words> words = new ArrayList<words>();
        words.add(new words("red" , "weṭeṭṭi", R.drawable.color_red , R.raw.color_red));
        words.add(new words("green" , "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new words("brown" , "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new words("gray" , "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new words("black" , "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new words("white" , "kelelli", R.drawable.color_white, R.raw.color_white ));
        words.add(new words("dusty yellow" , "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new words("mustard yellow" , "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this, words,R.color.colors);
        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(adapter);
        final TextView play = (TextView) findViewById(R.id.MiwokTranslation) ;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Colors.this ,"Clicked" , Toast.LENGTH_LONG ).show();
                words word = words.get(position);
                releaseMediaPlayer();
                int result = audioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback
                }

                mediaPlayer = MediaPlayer.create(Colors.this, word.getmMiwokSoundResourses());
                    mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(Colors.this, "Music is Done !" ,Toast.LENGTH_LONG).show();
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
