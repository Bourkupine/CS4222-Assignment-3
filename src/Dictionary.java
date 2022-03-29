import java.io.File;
import java.io.IOException;
import java.util.*;

public class Dictionary {

    private ArrayList<String> words ;

    private final int shortest;
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

        String trimmedWord = word.trim();

        if (this.words.contains(trimmedWord) && trimmedWord.length() >= this.shortest && trimmedWord.length() <= this.longest) { //contains might count subwords
            this.words.add(trimmedWord.toUpperCase());
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
        String trimmedWord = word.trim();
        return this.words.contains(trimmedWord.toUpperCase());
    }

}

