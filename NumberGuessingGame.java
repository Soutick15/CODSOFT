import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int min = 1, max = 100;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        // Generate a random number within the specified range
        int randomNumber = min + random.nextInt(max - min + 1);
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("A random number between " + min + " and " + max + " has been generated.");

        while (true) {
            System.out.print("Guess the number: ");
            int guess = scanner.nextInt();

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed it correctly.");
                break;
            } else if (guess < randomNumber) {
                System.out.println("The number is greater than your guess.");
            } else {
                System.out.println("The number is smaller than your guess.");
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
