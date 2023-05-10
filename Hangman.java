import java.util.ArrayList;
import java.util.Scanner;


public class Hangman {
    private final Scanner s = new Scanner(System.in);
    private final String word = RandomWordSelector.getWord();
    private final char[] wordArray = word.toCharArray();
    private final ArrayList<Character> guessed = new ArrayList<>();
    private int wrong = 0;


    public void play() {
        int dashes = countDashes();
        String guess;
        //while win or lose conditions are wrong
        while (wrong < 6 && !(dashes==0)) {
            clear();
            drawMan(wrong);
            displayGuessed();
            System.out.println("Incorrect Guesses: " + wrong);
            System.out.println(getWordView());
            System.out.print("Guess Letter:");
            guess = s.nextLine();
            while (guess.length() != 1) {
                System.out.print("Only enter one letter: ");
                guess = s.nextLine();
            }
            guessed.add(guess.charAt(0));
            if (dashes==countDashes()) {
                wrong++;
            } else {
                dashes = countDashes();
            }
        }
        endGame();
    }

    private void clear() {
        for (int i = 0 ; i <= 50 ; i++) {
            System.out.println("\n");
        }
    }

    private String getWordView() {
        StringBuilder ret = new StringBuilder();
        for (char c : wordArray) {
            if (guessed.contains(c)) {
                ret.append(c);
            } else {
                ret.append("_");
            }
        }
        return ret.toString();
    }

    private void displayGuessed() {
        StringBuilder g = new StringBuilder();
        for (int c = 0 ; c < guessed.size() ; c++) {
            g.append(guessed.get(c));
            if (!(c==guessed.size()-1)) {
                g.append(", ");
            }
        }
        System.out.println("Guessed: " + g);
    }

    private int countDashes() {
        int count = 0;
        for (char c : getWordView().toCharArray()) {
            if (c=='_'){
                count++;
            }
        }
        return count;
    }

    private void endGame() {
        clear();
        if (countDashes()==0) {
            drawMan(wrong);
            System.out.println("YOU WIN!");
            System.out.println("WORD WAS: " + word);
        } else {
            drawMan(wrong);
            System.out.println("YOU LOSE!");
            System.out.println("WORD WAS: " + word);
        }
    }

    private void drawMan(int incorrect) {
        switch (incorrect) {
            case 6 -> {
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  0   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                System.out.println("      |");
                System.out.println("=========");
            }
            case 5 -> {
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  0   |");
                System.out.println(" /|\\  |");
                System.out.println(" /    |");
                System.out.println("      |");
                System.out.println("=========");
            }
            case 4 -> {
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  0   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
            }
            case 3 -> {
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  0   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
            }
            case 2 -> {
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  0   |");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
            }
            case 1 -> {
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  0   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
            }
            default -> {
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
            }
        }
    }
}