package se.iths.viggo.dicegame;

public class Main {
    static void main() {
        String playAgainInput = "";
        while (true) {
            Game game = new Game();
            game.play();

            // Play again?
            while (true) {
                try {
                    playAgainInput = IO.readln("Do you want to play again? y/n: ").toLowerCase();
                    Game.checkValidChoiceInput(playAgainInput);
                    break;
                } catch (IllegalArgumentException e) {
                    IO.println(e.getMessage());
                }
            }

            // Exit game
            if (playAgainInput.equals("n")) {
                break;
            }
        }
    }
}
