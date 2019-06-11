package p01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WSSolver {
    //Returns: List of words to be searched in the Letter Soup
    //Receives: A text file AND AN int with the size of the soup
    public ArrayList<String> getWordList(File thisFile, int soupSize) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(thisFile);

        ArrayList<String> words = new ArrayList<>();

        for(int i = 0 ; i<soupSize ; i++)
            fileScanner.nextLine();

        while (fileScanner.hasNextLine()) {
            String currentLine = fileScanner.nextLine();

            String[] currentWords = currentLine.split("[,; ]");
            for (int i = 0; i < currentWords.length; i++){
                if(currentWords[i].length()<3)
                    continue;

                boolean ignoreWord=false;
                for(int testChar = 0 ; testChar < currentWords[i].length() ; testChar++)
                    if(!Character.isAlphabetic(currentWords[i].charAt(testChar))){
                        System.out.printf("Warning: Word %s will be ignored for containing non Alphabetical characters\n",currentWords[i]);
                        ignoreWord=true;
                        break;
                    }
                if(!ignoreWord){
                    words.add(currentWords[i]);
                }
            }
        }

        fileScanner.close();
        return words;
    }

    //Returns: Matrix of Soup Contents
    //Receives: A text file AND AN int with the size of the soup
    public Character[][] getSoupList(File thisFile,int soupSize) throws FileNotFoundException{
        Scanner fileScanner = new Scanner(thisFile);

        Character[][] soup = new Character[soupSize][soupSize];

        for(int i = 0 ; i < soupSize ; i++) {
            String currentLine = fileScanner.nextLine();
            for (int j = 0; j < soupSize; j++)
                soup[i][j] = currentLine.charAt(j);
        }

        fileScanner.close();
        return soup;
    }


    //Returns a String Array with [position,direction]
    //Receives A char array containing the soup AND A word to be searched
    public String[] findWord(Character[][] soup,String word){
        int soupSize = soup.length;
        word = word.toUpperCase();

        String[] returnValues = new String[2];

        int dir = -1;

        for(int i = 0 ; i<soupSize ; i++){
            for(int j = 0 ; j < soupSize ; j++){
                if (soup[i][j] == word.charAt(0)) {
                    dir = checkAllDirs(soup, word, i, j);
                    if(dir!=-1)
                        return new String[]{++i + "," + ++j, Direction.values()[dir].toString()};
                }
            }
        }

        System.out.printf("ERROR: Word %s not found\n",word);
        System.exit(1);
        return null;
    }

    private int checkAllDirs(Character[][] wordJumble,String word,  int startX, int startY)
    {
        int[] xDirs = {  0,  0,-1, 1, -1, -1,  1, 1}; //In order: UP DOWN LEFT RIGHT UPLEFT DOWNLEFT UPRIGHT DOWNRIGHT
        int[] yDirs = { -1,  1, 0, 0, -1,  1, -1, 1}; //In order: UP DOWN LEFT RIGHT UPLEFT DOWNLEFT UPRIGHT DOWNRIGHT


        for (int dir = 0; dir < 8; dir++) //Search the 8 cardinal directions
        {

            int charCounter, nextX = startX + xDirs[dir], nextY = startY + yDirs[dir];

            for (charCounter = 1; charCounter < word.length(); charCounter++) //NOTE: We already checked the first letter before calling this function ; Check all other chars in the same direction
            {
                // If out of bound
                if (nextX >= wordJumble.length || nextX < 0 || nextY >= wordJumble.length || nextY < 0)
                    break;

                // If not matched
                if (wordJumble[nextX][nextY] != word.charAt(charCounter))
                    break;

                //Continue moving
                nextX += xDirs[dir];
                nextY += yDirs[dir];
            }

            if (charCounter == word.length())
                return dir;
        }
        return -1;
    }

}
