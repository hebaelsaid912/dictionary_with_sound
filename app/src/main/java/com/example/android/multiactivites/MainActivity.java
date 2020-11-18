package com.example.android.multiactivites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView numbers = (TextView) findViewById(R.id.Numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Open the list of numbers" , Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this,Numbers.class);
                startActivity(i);
            }
        });
//        Button button = (Button) findViewById(R.id.ze_button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                doSomeStuff();
//            }
//        });

    }
    public void PhrasesActivity(View view){
        Intent i = new Intent(this,Phrases.class);
        startActivity(i);
    }
    public void FamilyActivity(View view){
        Intent i = new Intent(this,FamilyMembers.class);
        startActivity(i);
    }
    public void ColorsActivity(View view){
        Intent i = new Intent(this,Colors.class);
        startActivity(i);
    }


}
