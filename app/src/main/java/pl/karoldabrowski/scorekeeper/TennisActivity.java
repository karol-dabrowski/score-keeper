package pl.karoldabrowski.scorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TennisActivity extends AppCompatActivity {

    private Player playerA = new Player('A');
    private Player playerB = new Player('B');
    private int currentSet = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tennis);
    }

    public void addPoints(View view) {
        Player pointWinner;
        Player pointLoser;

        String tag = view.getTag().toString();
        if (tag.equals("A")) {
            pointWinner = playerA;
            pointLoser = playerB;
        } else {
            pointWinner = playerB;
            pointLoser = playerA;
        }

        if (gameCanBeFinished(pointWinner, pointLoser)) {
            finishGame(pointWinner, pointLoser);
            return;
        }

        if (pointLoser.points().equals(Points.ADVANTAGE)) {
            pointLoser.removeAdvantage();
        } else {
            pointWinner.addPoint();
        }

        displayPoints();
    }

    private boolean gameCanBeFinished(Player lastPointWinner, Player lastPointLoser) {
        return lastPointWinner.points().compareTo(Points.FORTY) >= 0 && lastPointWinner.points().compareTo(lastPointLoser.points()) > 0;
    }

    private boolean setCanBeFinished(Player lastGameWinner, Player lastGameLoser) {
        if(lastGameWinner.games() == 7) {
            return true;
        }

        if (lastGameWinner.games() == 6 && lastGameLoser.games() < 5) {
            return true;
        }

        return false;
    }

    private boolean matchCanBeFinished(Player lastSetWinner) {
        return lastSetWinner.sets() == 2;
    }

    private void finishGame(Player winner, Player loser) {
        winner.addGame();
        displayPlayerGames(winner);

        winner.resetPoints();
        loser.resetPoints();
        displayPoints();

        if(setCanBeFinished(winner, loser)) {
            finishSet(winner, loser);
        }
    }

    private void finishSet(Player winner, Player loser) {
        winner.addSet();
        winner.resetGames();
        loser.resetGames();
        currentSet++;

        if(matchCanBeFinished(winner)) {
            finishMatch(winner.id());
        } else {
            showNextSetRow();
        }
    }

    public void back(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void reset(View view) {
        recreate();
    }

    private void finishMatch(char winnerId) {
        TextView winnerField = (TextView) findViewById(R.id.winner_text_field);
        winnerField.setText("Player " + String.valueOf(winnerId));

        LinearLayout playersSpace = (LinearLayout) findViewById(R.id.players_space);
        playersSpace.setVisibility(View.GONE);

        LinearLayout winnerSpace = (LinearLayout) findViewById(R.id.winner_space);
        winnerSpace.setVisibility(View.VISIBLE);

        Button resetButton = (Button) findViewById(R.id.reset_button);
        resetButton.setVisibility(View.GONE);

        Button playAgainButton = (Button) findViewById(R.id.play_again_button);
        playAgainButton.setVisibility(View.VISIBLE);

        TableLayout scoreSpace = (TableLayout) findViewById(R.id.score_space);
        scoreSpace.setVisibility(View.GONE);
    }

    private void displayPoints() {
        TextView playerAPointsView = (TextView) findViewById(R.id.first_player_points);
        playerAPointsView.setText(playerA.points().label());

        TextView playerBPointsView = (TextView) findViewById(R.id.second_player_points);
        playerBPointsView.setText(playerB.points().label());
    }

    private void displayPlayerGames(Player winner) {
        int winnerGames = winner.games();
        char winnerId = Character.toLowerCase(winner.id());
        String textViewName = "player_" + winnerId + "_set_" + currentSet;
        int textViewId = getResources().getIdentifier(textViewName, "id", getPackageName());

        TextView setField = (TextView) findViewById(textViewId);
        setField.setText(String.valueOf(winnerGames));
    }

    private void showNextSetRow() {
        String setRowName = "set_" + currentSet + "_row";
        int setRowId = getResources().getIdentifier(setRowName, "id", getPackageName());
        TableRow setRow = (TableRow) findViewById(setRowId);
        setRow.setVisibility(View.VISIBLE);

        String setBorderName = "set_" + currentSet + "_border";
        int setBorderId = getResources().getIdentifier(setBorderName, "id", getPackageName());
        View setBorder = (View) findViewById(setBorderId);
        setBorder.setVisibility(View.VISIBLE);
    }
}
