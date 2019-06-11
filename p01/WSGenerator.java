package p01;

import java.io.*;
import java.util.*;
@SuppressWarnings("Duplicates")

public class WSGenerator {
    //Methodology:
    /*
        Functions (in order of use):
            -Function 1 (parameters = file):
                -- Read words files
                -- Return words

            *-DONE-*

            -Function 2 (parameters = word array):
                -Get words
                -Determine size
                -Create 2d array with random letters
                -Create occupied positions array (create class position ?)
                    (Each position is defined by an x and y coordinate)
                -For each word:
                    --Call Function 3 with current word and wordJumble (assign return to variable)
                    --Substitute letters at tempArray positions in the Jumble with each letter from the word
                    --Add tempArray positions to occupiedPositions
               -Return Word jumble

            -Function 3 (word,occupiedPositions array,wordJumble)
                -Pick a direction
                -Pick a starting position (currentPosition)
                -Create tempArray (with available positions)
                -For each letter:
                   --If positions are occupied (in array)
                       --If letter at position in the wordJumble is NOT the same as letter were putting in the jumble
                           ---Erase tempArray
                           --Go back to step 1
                   --Add position to tempArray
                   --Advance currentPosition in accordance to direction
                -Return tempArray

              -Function 4 (parameters = 2d array)
                -Create new file from input
                -Write 2d array (line per line)

     */

    public boolean writeToFile(String name,Character[][] wordJumble, ArrayList<String> words){

        try {
            FileWriter writer = new FileWriter("src/aula01/"+name);
            PrintWriter printWriter = new PrintWriter(writer);

            for(int i = 0 ; i<wordJumble.length ;i++){
                StringBuilder lineBuilder = new StringBuilder();
                for(int j = 0 ; j<wordJumble.length ; j++)
                    lineBuilder.append(wordJumble[i][j]);
                printWriter.println(lineBuilder.toString());
            }

            StringBuilder wordLineBuilder = new StringBuilder();

            int counter = 0;
            for(String word : words){
                counter++;
                if(counter==words.size())
                    wordLineBuilder.append(word);
                else
                    wordLineBuilder.append(word + ", ");
            }
            printWriter.print(wordLineBuilder.toString());


            printWriter.close();
            writer.close();

        } catch (IOException e) {
            return false;
        }


        return true;
    }

    public ArrayList<String> readWords(File wordFile) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(wordFile);
        ArrayList<String> words = new ArrayList<>();

        while (fileScanner.hasNextLine()) {
            String currentLine = fileScanner.nextLine();

            String[] currentWords = currentLine.split("[,; ]");
            for (int i = 0; i < currentWords.length; i++){
                if(currentWords[i].length()<3 || currentWords[i].length()>60)
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

        if (words.size()>(60*60)){
            System.out.println("ERROR: Too many words (max number of words = 3600");
            System.exit(1);
        }
        for(int i = 0 ; i < words.size() ; i++){
            for(int j = i+1 ; j<words.size() ; j++){
                if(words.get(i).contains(words.get(j)) || words.get(j).contains(words.get(i))){
                    System.out.println("ERROR: Word list contains duplicate or redundant words");
                    System.exit(1);
                }
            }
        }

        return words;
    }

    public Character[][] createJumble(ArrayList<String> wordList){
        String largestWord = wordList.get(0);
        Random randomGen = new Random();

        for(int i = 1 ; i<wordList.size() ; i++){
            if(largestWord.length()<wordList.get(i).length())
                largestWord = wordList.get(i);
        }


        int minSize =  largestWord.length()>Math.ceil(Math.sqrt(wordList.size())) ? largestWord.length() : (int) Math.ceil(Math.sqrt(wordList.size()));
        minSize = minSize>10 ? minSize : 10;
        int jumbleSize = randomGen.nextInt(61-minSize) + minSize;

        Character[][] wordJumble = new Character[jumbleSize][jumbleSize];
        for(int i = 0 ; i<jumbleSize ; i++)
            for(int j = 0 ; j<jumbleSize ; j++)
                wordJumble[i][j] = (char)(randomGen.nextInt(91-65)+65);


        ArrayList<Integer[]> occupiedPositions = new ArrayList<>();

        for(String word : wordList){
            ArrayList<Integer[]> tempArray = getInsertPositions(word,wordJumble,occupiedPositions);
            for(int i = 0 ; i<tempArray.size() ; i++) {
                int posX = tempArray.get(i)[0];
                int posY = tempArray.get(i)[1];

                wordJumble[posX][posY] = word.toUpperCase().charAt(i);
                //System.out.println(posX+" "+posY);
            }

            occupiedPositions.addAll(tempArray);
        }

        return wordJumble;
    }

    private  ArrayList<Integer[]> getInsertPositions(String word,Character[][]wordJumble, ArrayList<Integer[]> occupiedPositions){
        int tryCounter=0;
        Random randomGen = new Random();

        while(tryCounter < 500){
            boolean tryCounterIncremented = false;

            Direction currentDirection = Direction.getRandomDirection();
            int wordJumbleSize = wordJumble.length;

            int x = randomGen.nextInt(wordJumbleSize-0) + 0,y = randomGen.nextInt(wordJumbleSize-0) + 0;
            /*switch (currentDirection){
                case UP:
                    x = randomGen.nextInt(wordJumbleSize-0) + 0; //Any x position from 0 to wordJumble size (exclusive since we start at 0)
                    y = randomGen.nextInt(wordJumbleSize-(word.length()-1)) + (word.length()-1); //Y position from wordLength-1 to wordJumble size (exclusive since we start at 0)
                    break;
                case DOWN:
                    x = randomGen.nextInt(wordJumbleSize-0) + 0;  //Any x position from 0 to wordJumble size (exclusive since we start at 0)
                    y = randomGen.nextInt((wordJumbleSize-word.length())-0) + 0; //Y position from 0 to wordJumble-wordLength size (exclusive since we start at 0)
                    break;
                case LEFT:
                    x = randomGen.nextInt(wordJumbleSize-(word.length()-1)) + (word.length()-1);  //X position from wordSize-1 (cus we start at 0) until wordJumbleSize
                    y = randomGen.nextInt(wordJumbleSize-0) + 0; //Any Y position from 0 to wordJumble size
                    break;
                case RIGHT:
                    x = randomGen.nextInt((wordJumbleSize-word.length())-0) + 0;  //X position from 0 until wordJumbleSize-wordLength
                    y = randomGen.nextInt(wordJumbleSize-0) + 0; //Any Y position from 0 to wordJumble size
                    break;
                case UPLEFT:
                    x = randomGen.nextInt(wordJumbleSize-(word.length()-1)) + (word.length()-1); //X position from wordLength to wordJumbleSize
                    y = randomGen.nextInt(wordJumbleSize-(word.length()-1)) + (word.length()-1); //Y position from wordLength to wordJumbleSize
                    break;
                case UPRIGHT:
                    x = randomGen.nextInt((wordJumbleSize-word.length())-0) + 0; //X position from 0 to wordJumbleSize-wordLength
                    y = randomGen.nextInt(wordJumbleSize-(word.length()-1)) + (word.length()-1); //Y position from wordLength to wordJumbleSize
                    break;
                case DOWNLEFT:
                    x = randomGen.nextInt(wordJumbleSize-(word.length()-1)) + (word.length()-1); //X position from wordLength to wordJumbleSize
                    y = randomGen.nextInt((wordJumbleSize-word.length())-0) + 0; //Y position from 0 to wordJumbleSize-wordLength
                    break;
                case DOWNRIGHT:
                    x = randomGen.nextInt((wordJumbleSize-word.length())-0) + 0; //X position from 0 to wordJumbleSize-wordLength
                    y = randomGen.nextInt((wordJumbleSize-word.length())-0) + 0; //Y position from 0 to wordJumbleSize-wordLength
                    break;
            }*/

            ArrayList<Integer[]> tempOccupiedPositions = new ArrayList<>();
            for(int i = 0 ; i<word.length() ; i++){
                Integer[] currentPosition = {x,y};

                char currentChar = word.charAt(i);
                if(currentPosition[0]>=wordJumbleSize || currentPosition[1]>=wordJumbleSize || currentPosition[0]<0 || currentPosition[1]<0) {
                    tryCounterIncremented = true;
                    break;
                }

                for(Integer[] pos : occupiedPositions)
                    if(pos[0]==currentPosition[0] && pos[1]==currentPosition[1])
                        if(currentChar!=wordJumble[currentPosition[0]][currentPosition[1]]){
                            tryCounterIncremented = true;
                            break;
                        }

                tempOccupiedPositions.add(currentPosition);
                //System.out.println(currentDirection + " - " + currentPosition[0] + " - " + currentPosition[1]);
                //System.out.println(tempOccupiedPositions.toString());

                switch (currentDirection){
                    case UP:
                        y++;
                        break;
                    case DOWN:
                        y--;
                        break;
                    case LEFT:
                        x--;
                        break;
                    case RIGHT:
                        x++;
                        break;
                    case UPLEFT:
                        x--;
                        y--;
                        break;
                    case UPRIGHT:
                        x++;
                        y--;
                        break;
                    case DOWNLEFT:
                        x--;
                        y++;
                        break;
                    case DOWNRIGHT:
                        x++;
                        y++;
                        break;
                }

            }

            if(tryCounterIncremented){
                tryCounter++;
                continue;
            }

            return tempOccupiedPositions;
        }

        return null;
    }


}

