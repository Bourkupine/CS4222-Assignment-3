import java.io.File;
import java.io.IOException;
import java.util.*;

public class Dictionary {

    private ArrayList<String> words ;


    public Dictionary(String filepath, int shortest, int longest) {


        try {
            File f = new File(filepath);
            Scanner data = new Scanner(f);

            while (data.hasNextLine()) {
                String[] words = data.nextLine().split(",");

                assert this.words != null;
                for (String word : this.words) {
                    String currentWord = word.toUpperCase();
                    currentWord.replace(" ", "");
                    if (currentWord.length() >= shortest && currentWord.length() <= longest) {
                        if (!this.words.contains(currentWord)) { //TODO check to see if it will check subwords
                            this.words.add(currentWord);
                        }
                    }

                }

            }
            assert this.words != null; //might not be required, wait for dermots response
            Collections.sort(this.words);
        } catch (IOException e) {
            System.out.println("Houston we have a problem");
        }


        // have something like [if (word >= shortest && word <= longest) add to list]
        // !make uppercase! - just use .toUpperCase() when adding to list
        // !trim words! - should probably be first
        // !remove duplicates!
        // !store in alphabetical order! - Collections.sort(this.words); (something like this)

    }


    public boolean add(String word) {

        int shortest = this.words.get(0).length();
        int longest = this.words.get(this.words.size() -1).length();

        if (this.words.contains(word) && word.length() >= shortest && word.length() <= longest) { //contains might count subwords
            this.words.add(word);
            Collections.sort(this.words);
            return true;
        }
        return false;

        //scan to see if it exists
        //if not, add it, resort it, return true
        //if it does, return false
        //make sure its between shortest and longest
    }


    public String nextWord() {
        if (this.words.size() == 0) {return "";}
        return this.words.get((int)(Math.random() * this.words.size()));
    }


    public boolean inDictionary(String word) {
        return this.words.contains(word.toUpperCase());
    }

}

