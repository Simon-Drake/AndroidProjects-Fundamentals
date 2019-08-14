package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score1;
    private int score2;
    private TextView viewScore1;
    private TextView viewScore2;
    static final String score1State = "Team 1 Score";
    static final String score2State = "Team 2 Score";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewScore1 = findViewById(R.id.score1);
        viewScore2 = findViewById(R.id.score2);

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt(score1State);
            score2 = savedInstanceState.getInt(score2State);

            //Set the score text views
            viewScore1.setText(String.valueOf(score1));
            viewScore2.setText(String.valueOf(score2));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the scores.
        outState.putInt(score1State, score1);
        outState.putInt(score2State, score2);
        super.onSaveInstanceState(outState);
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.decreaseTeam1:
                score1--;
                viewScore1.setText(String.valueOf(score1));
                break;
            case R.id.decreaseTeam2:
                score2--;
                viewScore2.setText(String.valueOf(score2));
                break;
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }}
// Recreate the activity for the theme change to take effect.
            recreate();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    public void increaseScore(View view) {
        //Get the ID of the button that was clicked
        int viewID = view.getId();
        switch (viewID){
            //If it was on Team 1
            case R.id.increaseTeam1:
                //Increment the score and update the TextView
                score1++;
                viewScore1.setText(String.valueOf(score1));
                break;
            //If it was Team 2
            case R.id.increaseTeam2:
                //Increment the score and update the TextView
                score2++;
                viewScore2.setText(String.valueOf(score2));
        }
    }
}
