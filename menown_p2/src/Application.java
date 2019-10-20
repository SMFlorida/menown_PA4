/* Shelby Menown
 * October 19, 2019
 * COP3330 - Object Oriented Programming
 *
 * Assignment 3 (IntelliJ) - Problem 2
 */

public class Application {
    //Main function
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        //Setting balances for both users
        saver1.setSavingsBalance(2000);
        saver2.setSavingsBalance(3000);

        //Setting interest rate for both users
        saver1.modifyInterestRate(4);

        //Adding monthly compounded interest over 12 months to user accounts
        for (int i = 0; i < 12; i++){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }

        //Printing current user balances
        System.out.println("---User Balances after 1 year of an annual 4% interest compounded monthly---");
        System.out.println("User 1 Balance\t  User 2 Balance");
        saver1.printUserBalance();
        saver2.printUserBalance();

        //Changing interest rate for both users
        saver1.modifyInterestRate(5);

        //Adding one month of interest to user accounts
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        //Printing current user balances
        System.out.println("\n\n---User Balances after 1 month of an annual 5% interest compounded monthly---");
        System.out.println("User 1 Balance\t  User 2 Balance");
        saver1.printUserBalance();
        saver2.printUserBalance();
    }
}
