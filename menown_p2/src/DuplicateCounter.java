/*
 * Shelby Menown
 * November 2, 2019
 * COP3330 - Object Oriented Programming
 *
 * Assignment 4 (IntelliJ) - Problem 2
 *
 * Create a class called DuplicateCounter. Create an instance method called count that takes a single parameter called
 * dataFile (representing the path to a text file) and uses a Map of Strings to count how many times each word occurs
 * in dataFile. The counts should be stored in an instance variable called wordCounter. Create an instance method called
 * write that takes a single parameter called outputFile (representing the path to a text file) and writes the contents
 * of wordCounter to the file pointed to by outputFile. The output file should be overwritten if it already exists, and
 * created if it does not exist.
 * Create a separate class called Application that contains a main method which illustrates the use of DuplicateCounter
 * by calling both the remove and write methods. Your input file must be called problem2.txt and your output file must
 * be called unique_word_counts.txt. You will not receive credit if you use different file names, as my graders will not
 * modify your code to make it work with their test files.
 * Your program should work on any text file. The TA's will provide their own version of problem1.txt when they run your code.
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Map.Entry;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

class DuplicateCounter {
    //Declaring variables
    private HashMap<String, Integer> wordCounter = new HashMap<>();

    //Counts duplicate words in passed file
    void count(String dataFile) throws IOException{
        //Opening file
        FileInputStream fileByteStream = new FileInputStream(dataFile);
        Scanner inFS = new Scanner(fileByteStream);

        //Reading from file, creating or updating existing keys and values
        while (inFS.hasNext()) {
            wordCounter.merge(inFS.next(), 1, Integer::sum);
        }

        //Closing file
        fileByteStream.close();
    }

    //Writes word and word counts into new file
    void write() throws IOException {
        //Opening file
        FileOutputStream fileByteStream2 = new FileOutputStream("unique_word_counts.txt");
        PrintWriter outFS = new PrintWriter(fileByteStream2);
        Iterator<Entry<String, Integer>> i = wordCounter.entrySet().iterator();

        //Writing to file
        while (i.hasNext()){
            outFS.println(i.next());
        }
        outFS.flush();

        //Closing file
        fileByteStream2.close();
    }
}