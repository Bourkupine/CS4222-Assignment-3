import java.util.Arrays;

public class DictionaryDriver {

    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("error with args");
        }

        Dictionary wordlist = new Dictionary(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));

        System.out.println(wordlist.toString()); //print Dictionary
        System.out.println(wordlist.nextWord()); //return a random word
        System.out.println(wordlist.nextWord());
        System.out.println();

        System.out.println("dog: " + wordlist.add("dog")); //add some words
        System.out.println("cAt: " + wordlist.add("cAt")); //show its not case-sensitive
        System.out.println("    frog: " + wordlist.add("    frog")); //show trim
        System.out.println("Alligator: " + wordlist.add("Alligator")); //shouldn't add as length out of bounds
        System.out.println(wordlist.toString());
        System.out.println();

        System.out.println("dog: " + wordlist.add("dog")); //trying to add an already existing word
        System.out.println(wordlist.toString());
        System.out.println();

        System.out.println("contains ball? " + wordlist.inDictionary("ball")); //checking if exists in Dictionary
        System.out.println("contains dOG? " + wordlist.inDictionary("dOG")); //checking case sensitivity
        System.out.println("contains \"      frog    \"? " + wordlist.inDictionary("      frog    ")); //show trim




    }
}
