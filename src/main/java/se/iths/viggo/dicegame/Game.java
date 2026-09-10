package se.iths.viggo.dicegame;

public class Game {
    public void play() {
        final Player[] players = createPlayers();
        final int rollCount = 2;
        String continueMatchInput = "";

        // Game loop
        while (true) {
            for (Player player : players) {
                for (int i = 0; i < rollCount; i++) {
                    rollDice(player);
                }
            }

            // Continue match?
            while (true) {
                try {
                    continueMatchInput = IO.readln("Do you want to continue the match? y/n : ");
                    checkValidChoiceInput(continueMatchInput);
                    break;
                } catch (IllegalArgumentException e) {
                    IO.println(e.getMessage());
                }
            }

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
        IO.println("----------------------------------------");
        IO.println(player.getFullName() + " rolled a " + roll);
        IO.println("----------------------------------------");


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
            try {
                String input = IO.readln(prompt);
                checkValidNameInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                IO.println(e.getMessage());
            }
        }
    }

    private static void checkValidNameInput(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException("It can not be blank.");
        }
    }

    private static void checkValidChoiceInput(String input) throws IllegalArgumentException {
        if (!input.equals("y") && !input.equals("n")) {
            throw new IllegalArgumentException("(y/n)");
        }
    }
}

