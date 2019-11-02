/*
 * Shelby Menown
 * October 19, 2019
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

import java.util.HashSet;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

class DuplicateRemover {
    //Declaring variables
    private HashSet<String> uniqueWords = new HashSet<>();

    //Removes duplicate words in passed file
    void remove(String dataFile) throws IOException{
        //Opening file
        FileInputStream fileByteStream = new FileInputStream(dataFile);
        Scanner inFS = new Scanner(fileByteStream);

        //Reading from file, adding words to hash set
        //hashset.add() will automatically skip duplicate words
        while (inFS.hasNext()) {
            uniqueWords.add(inFS.next());
        }

        //Closing file
        fileByteStream.close();
    }

    //Writes unique words into new file
    void write() throws IOException {
        //Opening file
        FileOutputStream fileByteStream2 = new FileOutputStream("unique_words.txt");
        PrintWriter outFS = new PrintWriter(fileByteStream2);
        //Iterator to iterate through hashSet

        //Writing to file
        for (String uniqueWord : uniqueWords) {
            outFS.println(uniqueWord);
            //System.out.println(i.next());
        }
        outFS.flush();

        //Closing file
        fileByteStream2.close();
    }
}
