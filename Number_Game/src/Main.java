import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int randomNumber = random.nextInt(100) +1;

            int attemptsLeft = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nA number between 1 and 100 has been generated. Can you guess it?");
            System.out.println("You have " + attemptsLeft + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess;

                if (scanner.hasNextInt()) {
                    userGuess = scanner.nextInt();

                    if (userGuess < 1 || userGuess > 100) {
                        System.out.println("Please enter a number between 1 and 100.");
                        continue;
                    }
                } else {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    scanner.next();
                    continue;
                }

                attemptsLeft--;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += 10;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! You have " + attemptsLeft + " attempts left.");
                } else {
                    System.out.println("Too high! You have " + attemptsLeft + " attempts left.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNumber + ".");
            }

            System.out.print("\nWould you like to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\nGame over! Your final score is: " + score);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}