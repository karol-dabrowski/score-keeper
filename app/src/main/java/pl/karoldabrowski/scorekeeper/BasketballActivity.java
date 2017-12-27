package pl.karoldabrowski.scorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BasketballActivity extends AppCompatActivity {

    private int homeGoals = 0;
    private int awayGoals = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);
    }

    public void displayScoreForHomeTeam(String score) {
        TextView scoreView = (TextView) findViewById(R.id.home_score);
        scoreView.setText(score);
    }

    public void displayScoreForAwayTeam(String score) {
        TextView scoreView = (TextView) findViewById(R.id.away_score);
        scoreView.setText(score);
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

    public void addPointsForHomeTeam(View view) {
        int tag = Integer.parseInt(view.getTag().toString());
        homeGoals = homeGoals + tag;
        displayScoreForHomeTeam(String.valueOf(homeGoals));
    }

    public void addPointsForAwayTeam(View view) {
        int tag = Integer.parseInt(view.getTag().toString());
        awayGoals = awayGoals + tag;
        displayScoreForAwayTeam(String.valueOf(awayGoals));
    }
}
