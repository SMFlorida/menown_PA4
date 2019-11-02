/* Shelby Menown
 * October 19, 2019
 * COP3330 - Object Oriented Programming
 *
 * Assignment 4 (IntelliJ) - Problem 1
 */

import java.io.IOException;

public class Application {
    //Main function
    public static void main(String[] args) throws IOException{
        //Declaring variables
        DuplicateRemover blorp = new DuplicateRemover();

        //Calling method to remove all duplicate words from passed text file
        //Function will simply use HashSet.add() function on each word, which naturally skips duplicates
        blorp.remove("problem1.txt");

        //Calling method to write all unique words into output file
        blorp.write();

    }
}
