package p07.ex02;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

class TextReader implements TextReaderInterface{
    private File file;
    private int paragraphIndex;
    private boolean resetScanner = true; //Used to choose whether to reset the scanner after we have no more paragraphs to read

    TextReader(String filePath){
        try{
            this.file = new File(filePath);
            this.paragraphIndex = 0;
        }catch(Exception e){
            this.file = null;
            this.paragraphIndex = 0;
            System.out.println("Error! File couldn't be found so file was set to null");
        };
    }


    //File Setter
    public boolean setFile(String filePath){
        try{
            this.file = new File(filePath);
            this.paragraphIndex = 0;

            return true;
        }catch(Exception e){
            return false;
        }
    }
    

    //Reset Setting Setter (Toggler)
    public void setReset(){
        if(this.resetScanner == false){
            this.resetScanner = true;
        }else{
            this.resetScanner = false;
        }
    }


    //Checks if there are more paragraphs
    public boolean hasNext(){

        //First check if file has been initialzied//
        if(file == null){
            System.out.println("File not initialized");
            return false;
        };

        //Check if file has nextLine//
        try{
            Scanner testReader = new Scanner(this.file);

            //Get testReader to point to our current paragraph
            for(int i = 0 ; i<this.paragraphIndex ; i++){
                testReader.nextLine();
            }

            //Check next paragraph
            if(testReader.nextLine() != null){
                testReader.close();
                return true;
            };

            testReader.close();

            //Since we have nothing else to read, check whether the scanner should be reset
            if(this.resetScanner){
                this.paragraphIndex = 0;
            }

            return false;
        }catch(FileNotFoundException e){
            System.out.println("Error! Scanner unable to read file");
            return false;
        }
    }

    //Returns a paragraph
    public String next(){
        if(hasNext()){
            try{
            Scanner fileReader = new Scanner(this.file);
            for(int i = 0 ; i<this.paragraphIndex ; i++){
                fileReader.nextLine();
            }
            this.paragraphIndex++;

            return fileReader.nextLine();
            }catch(FileNotFoundException e){
                System.out.println("Error! Unable to read file");
            }
        }

        return null;
    }
}