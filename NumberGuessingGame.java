import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame  
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerLimit = 1;
        int upperLimit = 100;
        int attempts = 0;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("I've picked a number between " + lowerLimit + " and " + upperLimit);

        while (attempts < maxAttempts) {
            int targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed it right!");
                score++;
                System.out.println("Your score: " + score);
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next();
                if (!playAgain.equalsIgnoreCase("yes")) {
                    System.out.println("Thanks for playing!");
                    break;
                }
            }

            attempts++;
            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        if (attempts == maxAttempts) {
            System.out.println("Out of attempts! The number was: " + (random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit));
        }

        scanner.close();
    }
}
