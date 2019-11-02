/*
 * Shelby Menown
 * November 2, 2019
 * COP3330 - Object Oriented Programming
 *
 * Assignment 4 (IntelliJ) - Problem 1
 *
 * Create a class called DuplicateRemover. Create an instance method called remove that takes a single parameter called
 * dataFile (representing the path to a text file) and uses a Set of Strings to eliminate duplicate words from dataFile.
 * The unique words should be stored in an instance variable called uniqueWords. Create an instance method called write
 * that takes a single parameter called outputFile (representing the path to a text file) and writes the words contained
 * in uniqueWords to the file pointed to by outputFile. The output file should be overwritten if it already exists, and
 * created if it does not exist.
 *
 * Create a separate class called Application that contains a main method which illustrates the use of DuplicateRemover
 * by calling both the remove and write methods. Your input file must be called problem1.txt and your output file must
 * be called unique_words.txt. You will not receive credit if you use different file names, as my graders will not
 * modify your code to make it work with their test files.
 *
 * Your program should work on any text file. The TA's will provide their own version of problem1.txt when they run your code.
 */

import java.io.IOException;

public class Application {
    //Main function
    public static void main(String[] args) throws IOException{
        //Declaring variables
        DuplicateRemover testApplication = new DuplicateRemover();

        //Calling method to remove all duplicate words from passed text file
        //Function will simply use HashSet.add() function on each word, which naturally skips duplicates
        testApplication.remove("problem1.txt");

        //Calling method to write all unique words into output file
        testApplication.write();

    }
}
