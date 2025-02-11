//import java.util.Scanner;
//import java.util.Random;
//
//public class Main{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Random rn = new Random();
//
//        int score = 0;
//        boolean playAgain;
//        int attemptsLeft = 5;
//
//        System.out.println("Welcome to the number guessing game");
//
//            int generatedNumber = rn.nextInt(100) + 1;
//            System.out.println("A random number from 1 to 100 has been generated... Can you guess it ?");
//
//            System.out.println("Enter your number");
//            int guessedNumber = sc.nextInt();
//
//            if (generatedNumber == guessedNumber){
//                System.out.println("Congratulations... You made it correct");
//                score += 10;
//            }
//            else if(guessedNumber > 100 || guessedNumber < 1){
//                System.out.println("Invalid... Please enter a number between 1 to 100");
//            }
//            else{
//                System.out.println("Sorry... You Lose !");
//            }
//    }
//}


class ATM{
     int Pin;
     float balance;
}

public class Main{
    public static void main(String[] args) {
        System.out.println("Enter your pin");
        int Pin = 1234;
        float balance = 1000;

        do {
            if (Pin == 1234) {
                System.out.println("Your pin is correct");
                System.out.println("What operations you wanna perform ? 1.Check Balance  2.Withdraw money  3.Deposit money  4.Exit  ");

            } else {
                System.out.println("Please enter a valid pin");
            }
        }

    }
}











