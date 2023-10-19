import java.util.Scanner;

public class HangmanGame {
    private String wordToGuess;
    private StringBuilder currentGuess;
    private int maxTries;
    private int remainingTries;
    private final Scanner scanner;


    public  void start(){
        while (!isGameOver()) {
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            guessLetter(guess);
            displayGameStatus();
        }

        if (currentGuess.toString().equals(wordToGuess)) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Game over! The word was: " + wordToGuess);
        }
        menu();
    }

    private void menu(){
        while (true) {
            System.out.println("If you wanna change word press 1");
            System.out.println("If you wanna change maxTries press 2");
            System.out.println("If you wanna keep playing press 3");
            System.out.println("If you wanna exit press 4");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Choice secret word: ");
                String secretWord = scanner.next();
                setSecretWord(secretWord);
            } else if (choice == 2) {
                System.out.print("Choice maximum tries: ");
                String maxTries = scanner.next();
                try {
                    int maxTriess = Integer.parseInt(maxTries);
                    setMaxTries(maxTriess);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == 3) {
                start();
            }
            else if(choice == 4){
                return;
            }
        }
    }
    public HangmanGame(){
        wordToGuess = "hangman";
        currentGuess = new StringBuilder("_".repeat(wordToGuess.length()));
        maxTries = 6;
        remainingTries = maxTries;
        scanner = new Scanner(System.in);

    }

    public void setSecretWord(String wordToGuess) {
        this.wordToGuess = wordToGuess.toLowerCase();
        this.currentGuess = new StringBuilder("_".repeat(wordToGuess.length()));
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
        this.remainingTries = maxTries;
    }

    public boolean isGameOver() {
        return remainingTries <= 0 || !currentGuess.toString().contains("_");
    }

    public void guessLetter(char letter) {
        letter = Character.toLowerCase(letter);
        if (wordToGuess.contains(String.valueOf(letter))) {
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == letter) {
                    currentGuess.setCharAt(i, letter);
                }
            }
        } else {
            remainingTries--;
        }
    }

    public void displayGameStatus() {
        System.out.println("Current Guess: " + currentGuess);
        System.out.println("Remaining Tries: " + remainingTries);
    }

}
