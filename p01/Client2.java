package p01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("Duplicates")

public class Client2 {
    public static void main(String[] args){
        WSGenerator jumbleMaker = new WSGenerator();

        ArrayList<Integer[]> occupiedPositions = new ArrayList<>();
        ArrayList<Integer[]> currentPosition = new ArrayList<>();


        try {

            Scanner inputTaker = new Scanner(System.in);
            System.out.println("Name of file with words:\n");
            String fileName = inputTaker.nextLine();


            File wordFile = new File("src/aula01/"+fileName);
            ArrayList<String> wordList = jumbleMaker.readWords(wordFile);
            //System.out.println(wordList);
            Character[][] wordJumble = jumbleMaker.createJumble(wordList);

            for(int i = 0 ; i<wordJumble.length ; i++) {
                for (int j = 0; j < wordJumble.length; j++)
                    System.out.print(wordJumble[i][j]);
                System.out.println();
            }

            System.out.println("Write name of file:\n");
            fileName = inputTaker.nextLine();
            jumbleMaker.writeToFile(fileName,wordJumble,wordList);

            inputTaker.close();

            ///////////////////////////////////////////////////////////
            //Solver:

            File soupFile = new File("src/aula01/" + fileName);
            Scanner fileScanner = new Scanner(soupFile);
            int soupSize = fileScanner.nextLine().length();

            WSSolver solver = new WSSolver();

            ArrayList<String> words = solver.getWordList(soupFile,soupSize);
            System.out.println(words.toString());
            for(int i = 0 ; i < words.size() ; i++){
                for(int j = i+1 ; j<words.size() ; j++){
                    if(words.get(i).contains(words.get(j)) || words.get(j).contains(words.get(i))){
                        System.out.println("ERROR: Word list contains duplicate or redundant words");
                        System.exit(1);
                    }
                }
            }

            Character[][] soup = solver.getSoupList(soupFile,soupSize);

            for(String word : words){
                word = word.toUpperCase();
                String[] returnValues = solver.findWord(soup,word);
                System.out.printf("%-10s %-5d %-8s %s\n",word,word.length(),returnValues[0],returnValues[1]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
