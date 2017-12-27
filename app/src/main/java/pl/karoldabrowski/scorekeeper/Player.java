package pl.karoldabrowski.scorekeeper;

public class Player {
    private Points points = Points.ZERO;
    private int games = 0;
    private int sets = 0;
    private char id;

    Player(char id) {
        this.id = id;
    }

    public char id() {
        return this.id;
    }

    public Points points() {
        return this.points;
    }

    public void addPoint() {
        this.points = points.next();
    }

    public void resetPoints() {
        this.points = Points.ZERO;
    }

    public void removeAdvantage() {
        this.points = Points.FORTY;
    }

    public void addGame() {
        this.games++;
    }

    public int games() {
        return this.games;
    }

    public void resetGames() {
        this.games = 0;
    }

    public void addSet() {
        this.sets++;
    }

    public int sets() {
        return this.sets;
    }
}
