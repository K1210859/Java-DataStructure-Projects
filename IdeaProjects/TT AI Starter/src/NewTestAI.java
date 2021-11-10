import java.util.ArrayList;
import java.util.Random;

public class NewTestAI implements PlayerInt {
    private char letter;
    private char opponentLetter;
    private String name;

    // Pre:       receives a char letter
    // Post:   sets the name to "Random AI" and the letter to the letter received
    NewTestAI(char letter) {
        name = "New Test AI";
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }


    // Pre:       method is called
    // Post:   returns the Location where the player wants to move
    public Location getMove(Board board) {
        int max = -1;
        Location best = null;
        for (int s = 0; s < 4; s++) {
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    Location loc = new Location(c, r, s);
                    if(board.isEmpty(loc)) {
                        Counts counts = new Counts(board, loc, letter);
                        int score = counts.getMy1s() * 1 + counts.getMy2s() * 10 + counts.getMy3s() * 250 + counts.getMy4s() * 10000;
                        int oppScore = counts.getOpp1s() * 1 + counts.getOpp2s() * 50 + counts.getOpp3s() * 200 + counts.getOpp4s() * 5000;
                        //int score = counts.getMy1s() * 2 + counts.getMy2s() * 25 + counts.getMy3s() * 600 + counts.getMy4s() * 10000;
                        //int oppScore = counts.getOpp1s() * 1 + counts.getOpp2s() * 6 + counts.getOpp3s() * 300 + counts.getOpp4s() * 7000;

                        if (score >= max) {
                            max = score;
                            best = loc;
                        }
                        if (oppScore > max) {
                            max = oppScore;
                            best = loc;
                        }
                    }
                }
            }
        }
        return best;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public PlayerInt freshCopy () {
        return new NewTestAI(letter);
    }
}


