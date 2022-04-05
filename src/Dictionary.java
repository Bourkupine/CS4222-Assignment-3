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
                String[] wordArray = data.nextLine().split(",");

                for (String word : wordArray) {
                    String currentWord = word.toUpperCase().trim();
                    if (currentWord.length() >= shortest && currentWord.length() <= longest) {
                        if (!this.words.contains(currentWord)) { //TODO check to see if it will check subwords
                            this.words.add(currentWord);
                        }
                    }
                }
            }
            assert this.words != null; //might not be required
            Collections.sort(this.words);
        } catch (IOException e) {
            System.out.println("Houston we have a problem" + e);
        }


        // have something like [if (word >= shortest && word <= longest) add to list]
        // !make uppercase! - just use .toUpperCase() when adding to list
        // !trim words! - should probably be first
        // !remove duplicates!
        // !store in alphabetical order! - Collections.sort(this.words); (something like this)

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
        if (this.words.size() == 0) {return "";}
        return this.words.get((int)(Math.random() * this.words.size()));
    }


    public boolean inDictionary(String word) {
        String trimmedWord = word.trim();
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

