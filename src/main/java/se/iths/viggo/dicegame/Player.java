package se.iths.viggo.dicegame;

public class Player {

    private final String firstName;
    private final String lastName;
    private int score;

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = 0;
    }

    public void addToScore(int score) {
        if (score > 0) {
            this.score += score;
        }
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public int getScore() {
        return this.score;
    }
}
