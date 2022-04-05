//Name: Euan Bourke
//ID: 21332142

//CS4222 Assignment 3

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Dictionary {

    private ArrayList<String> words ;

    private final int shortest; //creating these so we can use it later on
    private final int longest;


    public Dictionary(String filepath, int shortest, int longest) {

        this.words = new ArrayList<>();

        this.shortest = shortest;
        this.longest = longest;

        try {
            File f = new File(filepath);
            Scanner data = new Scanner(f);

            while (data.hasNextLine()) {
                String[] wordArray = data.nextLine().split(","); //create an array of all the words on the line

                for (String word : wordArray) { //for each word in the array, we trim it and put to uppercase
                    String currentWord = word.toUpperCase().trim();
                    //checks if the word is between the shortest and longest variables
                    if (currentWord.length() >= shortest && currentWord.length() <= longest) {
                        if (!this.words.contains(currentWord)) {
                            this.words.add(currentWord); //adds the word if it is not already contained in the list
                        }
                    }
                }
            }
            Collections.sort(this.words); //sorts the list
        } catch (IOException e) {
            System.out.println("Houston we have a problem" + e);
        }
    }


    public boolean add(String word) {

        String trimmedWord = word.trim().toUpperCase(); //trim the word and put to upper case

        //we will check if it is not contained in the array list and then if it is between the shortest and longest varialbes
        if (!this.words.contains(trimmedWord) && trimmedWord.length() >= this.shortest && trimmedWord.length() <= this.longest) { //contains might count subwords
            this.words.add(trimmedWord); //add the word
            Collections.sort(this.words); //sort the list
            return true; //finally return true
        }
        return false; //otherwise return false
    }

    public String nextWord() {
        if (this.words.size() == 0) {return "";} //checks if word list is empty
        return this.words.get((int)(Math.random() * this.words.size())); //generates a random number between 0 and length of array nad returns the word at that index
    }


    public boolean inDictionary(String word) {
        String trimmedWord = word.trim(); //trim word
        return this.words.contains(trimmedWord.toUpperCase());
    }

    public String toString() { //custom toString() method

        //to do this, we create a StringBuilder and for each word we will add it to the StringBuilder
        //essentially we are creating a super long string of the words
        StringBuilder theString = new StringBuilder();
        this.words.forEach(word -> theString.append(word).append(" "));
        return theString.toString();

        //using this method as I wanted to learn StringBuilders and forEach loops
    }

}

