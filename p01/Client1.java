package p01;

import java.io.*;
import java.util.*;

@SuppressWarnings("Duplicates")

public class Client1 {

    public static void main(String[] args) throws FileNotFoundException {
        File soupFile = new File("src/aula01/words1.txt");

        Scanner fileScanner = new Scanner(soupFile);
        int soupSize = fileScanner.nextLine().length();
        fileScanner.close();

        if (soupSize > 60) {
            System.out.println("ERROR: Size of Soup too big (>60)");
            return;
        }

        WSSolver solver = new WSSolver();

        List<String> words = solver.getWordList(soupFile, soupSize);

        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(i).contains(words.get(j)) || words.get(j).contains(words.get(i))) {
                    System.out.println("ERROR: Word list contains duplicate or redundant words");
                    System.exit(1);
                }
            }
        }

        Character[][] soup = solver.getSoupList(soupFile, soupSize);

        for (String word : words) {
            word = word.toUpperCase();
            String[] returnValues = solver.findWord(soup, word);
            System.out.printf("%-10s %-5d %-4s %s\n", word, word.length(), returnValues[0], returnValues[1]);
        }

    }
}
