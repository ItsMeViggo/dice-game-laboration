package se.iths.viggo.dicegame;

import java.util.Random;

public class Game {
    Random random = new Random();

    public void play() {
        Player[] players = createPlayers();

        while (true) {
            // Roll dice twice
            for (int i = 0; i < 2; i++) {
                rollDice(players[0]);
            }

            for (int i = 0; i < 2; i++) {
                rollDice(players[1]);
            }

            // Continue match?
            String continueMatchInput = IO.readln("Do you want to continue the match? y/n : ");
            if (!continueMatchInput.toLowerCase().equals("y")) {
                getWinner(players);
                break;
            }
        }

    }

    private void rollDice(Player player) {
        IO.println(player.getFullName() + "'s turn to play");
        IO.readln("Press ENTER to roll!");

        int roll = Dice.roll();
        IO.println(player.getFullName() + " rolled a " + roll + "\n");

        player.addToScore(roll);
    }

    private static Player[] createPlayers() {
        String playerOneFirstName = handlePlayerNameInput("Player one's first name: ");
        String playerOneLastName = handlePlayerNameInput("Player one's last name: ");

        String playerTwoFirstName = handlePlayerNameInput("Player two's first name: ");
        String playerTwoLastName = handlePlayerNameInput("Player two's last name: ");


        Player playerOne = new Player(playerOneFirstName, playerOneLastName);
        Player playerTwo = new Player(playerTwoFirstName, playerTwoLastName);

        return new Player[]{playerOne, playerTwo};
    }

    private static void getWinner(Player[] players) {
        if (players[0].getScore() > players[1].getScore()) {
            IO.println(players[0].getFullName() + " won with " + players[0].getScore() + " score against " + players[1].getScore());
        } else if (players[0].getScore() < players[1].getScore()) {
            IO.println(players[1].getFullName() + " won with " + players[1].getScore() + " score against " + players[0].getScore());
        } else {
            IO.println("It's a tie!");
        }
    }

    private static String handlePlayerNameInput(String prompt) {
        while (true) {
            String input = IO.readln(prompt);
            if (input.isBlank()) {
                IO.println("Can not be blank.");
            } else {
                return input;
            }
        }
    }
}

