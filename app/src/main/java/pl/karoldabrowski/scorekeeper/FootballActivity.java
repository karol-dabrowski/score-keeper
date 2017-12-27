package pl.karoldabrowski.scorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FootballActivity extends AppCompatActivity {

    private int homeGoals = 0;
    private int awayGoals = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);
    }

    public void displayScoreForHomeTeam(String score) {
        TextView scoreView = (TextView) findViewById(R.id.home_score);
        scoreView.setText(score);
    }

    public void displayScoreForAwayTeam(String score) {
        TextView scoreView = (TextView) findViewById(R.id.away_score);
        scoreView.setText(score);
    }

    public void incrementScore(View view) {
        String tag = view.getTag().toString();
        if(tag.equals("home")) {
            homeGoals ++;
            displayScoreForHomeTeam(String.valueOf(homeGoals));
        } else if (tag.equals("away")) {
            awayGoals ++;
            displayScoreForAwayTeam(String.valueOf(awayGoals));
        }
    }

    public void back(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void reset(View view) {
        homeGoals = awayGoals = 0;
        displayScoreForHomeTeam(String.valueOf(homeGoals));
        displayScoreForAwayTeam(String.valueOf(awayGoals));
    }
}
