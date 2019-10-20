/* Shelby Menown
 * October 19, 2019
 * COP3330 - Object Oriented Programming
 *
 * Assignment 3 (IntelliJ) - Problem 1
 */

import java.util.Scanner;
import java.security.SecureRandom;

public class mathPractice {
    //Main function
    public static void main(String[] args){
        //Declaring variables
        char choice; //Stores user input to decide if program restarts or closes entirely

        do {
            //Printing program head
            System.out.println("-----Basic Arithmetic Practice Program-----");

            //Declaring variables
            Scanner in = new Scanner(System.in);
            int difficultyLevel = getDifficultyLevel(); //stores user-chosen difficulty type
            int arithmeticType = getArithmeticType(); //stores user-chosen arithmetic type
            double[] solutionArray = new double[10]; //stores solutions to each problem
            double answer;
            int numCorrect = 0;

            //Iterating through 10 random problems
            for (int i = 0; i < 10; i++){
                //Generating problem
                solutionArray[i] = generateProblem(arithmeticType, difficultyLevel, solutionArray);

                //Taking user input
                answer = in.nextDouble();

                //Checking answer
                numCorrect += checkAnswer(answer, solutionArray[i]);
            }

            //Reviewing results
            System.out.println("Results: " + numCorrect + "/10\n  Grade: " + ((double)numCorrect/10)*100 + "%");
            if (((float)numCorrect / 10) >= .75){
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            else {
                System.out.println("Please ask your teacher for extra help.");
            }

            //Restarting or terminating program
            System.out.println("Would you like to restart the program? Enter (y/n).");
            choice = in.next().charAt(0);

        } while (choice == 'y');
    }

    //Function for user to select type of arithmetic to practice
    private static int getArithmeticType(){
        //Declaring variables
        Scanner in = new Scanner(System.in);
        int arithmeticType;

        //Printing menu
        System.out.println("\nEnter the number next to the type of math you'd like to practice.");
        System.out.println("\t1 --- Addition\n\t2 --- Multiplication\n\t3 --- Subtraction\n\t4 --- Division\n" +
                "\t5 --- Random (Mixed)");

        //Getting user input
        arithmeticType = in.nextInt();

        //Returning result
        return arithmeticType;
    }

    //Function for user to select difficulty of problems
    private static int getDifficultyLevel(){
        //Declaring variables
        Scanner in = new Scanner(System.in);
        int difficultyLevel;

        //Printing menu
        System.out.println("\nEnter the number next to the level of difficulty you'd like to practice at.");
        System.out.println("\t1 --- Single-Digit Numbers\n\t2 --- Two-Digit Numbers\n\t" +
                "3 --- Three-Digit Numbers\n\t4 --- Four-Digit Numbers");

        //Getting user input
        difficultyLevel = in.nextInt();

        return difficultyLevel;
    }

    //Function to generate problems
    private static double generateProblem(int arithmeticType, int difficultyLevel, double[] solutionArray){
        //Declaring variables
        SecureRandom rand = new SecureRandom();
        int[] randomIntegers; //stores random integers used for problem generation

        //Assigning new temporary arithmetic type for users who selected random types
        if (arithmeticType == 5) arithmeticType = rand.nextInt(4) + 1;

        //Generating random integers
        randomIntegers = getRandomIntegers(difficultyLevel, arithmeticType, solutionArray);

        //Generates random numbers again if necessary to avoid duplicate questions
        for (int i = 0; i < 10; i++){
            if (Math.abs(getSolution(randomIntegers, arithmeticType) - solutionArray[i]) < .01){
                randomIntegers = getRandomIntegers(difficultyLevel, arithmeticType, solutionArray);
            }
        }

        //Printing problem
        printProblem(randomIntegers, arithmeticType);

        //Returning solution
        return getSolution(randomIntegers, arithmeticType);
    }

    //Function to generate random integers depending on difficulty level
    private static int[] getRandomIntegers(int difficultyLevel, int arithmeticType, double[] solutionArray){
        //Declaring variables
        SecureRandom rand = new SecureRandom();
        int[] randomIntegers = new int[2];
        for (int i = 0; i < 2; i++){
            randomIntegers[i] = 0;
        }

        //Switch statement to generate random numbers based on selected difficulty
        switch (difficultyLevel){
            //Case for level 1 difficulty --- generates single-digit integers
            case 1:
                for (int i = 0; i < 2; i++) {
                    randomIntegers[i] = rand.nextInt(10);
                }
                break;
            //Case for level 2 difficulty --- generates two-digit integers
            case 2:
                for (int i = 0; i < 2; i++) {
                    randomIntegers[i] = rand.nextInt(90) + 10;
                }
                break;
            //Case for level 3 difficulty --- generates three-digit integers
            case 3:
                for (int i = 0; i < 2; i++) {
                    randomIntegers[i] = rand.nextInt(900) + 100;
                }
                break;
            //Case for level 4 difficulty --- generates four-digit integers
            case 4:
                for (int i = 0; i < 2; i++) {
                    randomIntegers[i] = rand.nextInt(9000) + 1000;
                }
                break;
            default:
                for (int i = 0; i < 2; i++) {
                    randomIntegers[i] = -1;
                }
                throw new IllegalStateException("Unexpected value: " + difficultyLevel);
        }

        //Returning array of two random integers
        return randomIntegers;
    }

    //Function to print problem for user, returns (does not print) solution to question
    private static void printProblem(int[] randomIntegers, int arithmeticType){
        switch (arithmeticType){
            //Case for addition problems
            case 1:
                System.out.println("How much is " + randomIntegers[0] + " plus " + randomIntegers[1] + "?");
                break;
            //Case for multiplication problems
            case 2:
                System.out.println("How much is " + randomIntegers[0] + " times " + randomIntegers[1] + "?");
                break;
            //Case for subtraction problems
            case 3:
                System.out.println("How much is " + randomIntegers[0] + " minus " + randomIntegers[1] + "?");
                break;
            //Case for addition problems
            case 4:
                //Loop to ensure no division by zero
                if (randomIntegers[1] == 0){
                    randomIntegers[1] = 1;
                }
                System.out.println("How much is " + randomIntegers[0] + " divided by " + randomIntegers[1] + "? " +
                        "(If the answer is not a whole number, answer to the 2nd decimal place)");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + arithmeticType);
        }
    }

    //Function to get solution for current problem
    private static double getSolution(int[] randomIntegers, int arithmeticType){
        //Declaring variables
        double solution;

        switch (arithmeticType){
            //Case for addition problems
            case 1:
                solution = randomIntegers[0] + randomIntegers[1];
                //System.out.println(solution);
                break;
            //Case for multiplication problems
            case 2:
                solution = randomIntegers[0] * randomIntegers[1];
                //System.out.println(solution);
                break;
            //Case for subtraction problems
            case 3:
                solution = randomIntegers[0] - randomIntegers[1];
                //System.out.println(solution);
                break;
            //Case for addition problems
            case 4:
                //Loop to ensure no division by zero
                if (randomIntegers[1] == 0){
                    randomIntegers[1] = 1;
                }
                solution = (double)randomIntegers[0] / randomIntegers[1];
                //System.out.println(solution);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + arithmeticType);
        }

        //Returning solution
        return solution;
    }

    //Function to check answers
    private static int checkAnswer(double answer, double solution){
        //Declaring variables
        SecureRandom rand = new SecureRandom();
        int isRight = 0;
        int randomResponse = rand.nextInt(4) + 1;

        if (Math.abs(answer - solution) < .01){
            isRight = 1;
        }

        switch (isRight){
            case 0:
                if (randomResponse == 1){
                    System.out.println("No. Please try again.");
                }
                else if (randomResponse == 2){
                    System.out.println("Wrong. Try once more.");
                }
                else if (randomResponse == 3){
                    System.out.println("Don’t give up!");
                }
                else if (randomResponse == 4){
                    System.out.println("No. Keep trying.");
                }
                break;
            case 1:
                if (randomResponse == 1){
                    System.out.println("Very good!");
                }
                else if (randomResponse == 2){
                    System.out.println("Excellent!");
                }
                else if (randomResponse == 3){
                    System.out.println("Nice work!");
                }
                else if (randomResponse == 4){
                    System.out.println("Keep up the good work!");
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + isRight);
        }

        //Returning if answer was correct or not
        return isRight;
    }
}


