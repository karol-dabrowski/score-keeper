package pl.karoldabrowski.scorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createFootballCounter(View view) {
        Intent myIntent = new Intent(this, FootballActivity.class);
        startActivity(myIntent);
    }

    public void createBasketballCounter(View view) {
        Intent myIntent = new Intent(this, BasketballActivity.class);
        startActivity(myIntent);
    }

    public void createTennisCounter(View view) {
        Intent myIntent = new Intent(this, TennisActivity.class);
        startActivity(myIntent);
    }
}
