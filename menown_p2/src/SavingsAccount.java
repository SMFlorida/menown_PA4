/* Shelby Menown
 * October 19, 2019
 * COP3330 - Object Oriented Programming
 *
 * Assignment 3 (IntelliJ) - Problem 2
 */

import java.util.Scanner;

public class SavingsAccount {
    //Declaring variables
    Scanner in = new Scanner(System.in);
    private static int annualInterestRate;
    private double savingsBalance;

    //Function to set user's balance
    public void setSavingsBalance(int balance){
        savingsBalance = balance;
    }

    //Function to calculate monthly interest rates
    public void calculateMonthlyInterest(){
        savingsBalance += savingsBalance * (((double)annualInterestRate/100)) / 12;
    }

    //Function to modify monthly interest rates
    public static void modifyInterestRate(int newInterestRate){
        annualInterestRate = newInterestRate;
    }

    public int getAnnualInterestRate(){
        return annualInterestRate;
    }

    //Function to print current balance
    public void printUserBalance(){
        System.out.printf("$%.2f   \t\t  ", savingsBalance);
    }
}



