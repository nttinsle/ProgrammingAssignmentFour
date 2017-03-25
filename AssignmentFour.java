/**
 * Nick Tinsley
 * Programming Assignment 4
 * March 25, 2017
 */
package assignmentfour;

import java.io.*;//file
import java.util.*;//scanner

/** 
 * @author Nick Tinsley
 */
public class AssignmentFour {

    //instantiate 
    static int wordsFound = 0;
    static int wordsNotFound = 0;
    static long comparisonsFound = 0;
    static long comparisonsNotFound = 0;
    
    MyLinkedList[] list = new MyLinkedList[26];//make linked list of size 26

    /**
     * This method will read the dictionary and load each word into the correct
     * list index based on the first character of the word(alphabetically).
     */
    private void populateDictionary() {
        for (int i = 0; i < list.length; i++) {
            list[i] = new MyLinkedList<String>();//instantiate 26 linked lists
        }//for
        try {
            Scanner dictReader = new Scanner(new File("random_dictionary.txt"));//read file
            while (dictReader.hasNext()) {
                String word = dictReader.next().toLowerCase();//lowercase everything
                list[word.charAt(0) - 97].addFirst(word);//word to correct based off first letter(ASCII)
            }//while
            dictReader.close();
        }//try 
        catch (IOException e) {
            System.out.println(e + "populateDictionary");
        }//catch
    }//populateDictionary

    /**
     * This method will read the Oliver text and go through word by word checking if each
     * word is contained in the dictionary. If it is in the dictionary the word is found and assumed
     * to be spelled correctly. If it is not found in the dictionary it is assumed to be spelled 
     * incorrectly. The method will count the number of words found and the number of words not found.
     * It will also count the total number of comparisons for words found and not found.
     */
    private void readOliver() {
        try {
            Scanner bookReader = new Scanner(new File("oliver.txt"));//read file
            while (bookReader.hasNext()) {//go through words
                String words = bookReader.next().toLowerCase().replaceAll("[^a-z]", "");//replace all special characters
                while (words.isEmpty()) {//if hits a null reference 
                    words = bookReader.next().toLowerCase().replaceAll("[^a-z]", "");//replace all special characters
                }//while
                int[] count = new int[1];//integer array with 1 element
                    if (list[words.charAt(0) - 97].contains(words, count)) {//goes to correct linked list and checks if word is contained
                        wordsFound++;//add to found if it is there
                        comparisonsFound+=count[0];//number of comparisons to find words
                    }//if
                    else {
                        wordsNotFound++;//add to not found if it is not there
                        comparisonsNotFound+=count[0];//number of comparisons to not find words
                    }//else
            }//while
        }//try
        catch (IOException e) {
            System.out.println(e + "readOliver");
        }//catch
    }//readOliver

    /**
     * This method begins execution of all the testing. It will output the words found, words not
     * found, comparisons found, comparisons not found, and the averages for comparisons
     * per word found and not found.
     * 
     * @param args : the command line arguments
     */
    public static void main(String[] args) {
        AssignmentFour test = new AssignmentFour();
        test.populateDictionary();
        test.readOliver();
        System.out.println("Words found " + wordsFound);
        System.out.println("Words not found " + wordsNotFound);
        System.out.println("Comparisons found " + comparisonsFound);
        System.out.println("Comparisons not found " + comparisonsNotFound);
        System.out.println("Average number of comparisons per word found " + comparisonsFound/wordsFound);
        System.out.println("Average number of comparisons per word not found " + comparisonsNotFound/wordsNotFound);
    }//main
}//class
