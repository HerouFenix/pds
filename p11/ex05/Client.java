package p11.ex05;

//Patterns used:
//  -Visitor Pattern (but the one given by java - FileVisitor)
//Other stuff used:
//  -ARGS OPTIONS!!


public class Client {
    private final static String USAGE_MESSAGE = "Usage:\n"+
                                                "java ex05.DirSize [-Option] PathName\n"+
                                                "Options:\n"+
                                                "   -h: Displays usage message\n"+
                                                "   -r: Gets size of directories inside given directory aswell\n";

    public static void main(String[] args) {
        if(args.length < 0){
            System.out.println("Error! No path specified!");
            System.out.println(USAGE_MESSAGE);
            System.exit(1);
        }

        if(args.length >= 2){
            int j = 0;
            boolean recursiveFlag = false;
            for(String i : args){
                if(i.startsWith("-") && i.length() == 2){
                    j++;
                    switch(i){
                        case "-h":
                                System.out.println(USAGE_MESSAGE);
                                break;
                        case "-r":
                                recursiveFlag = true;
                                break;
                        default:
                            System.out.println("Error! Invalid option specified!");
                            System.out.println(USAGE_MESSAGE);
                            System.exit(1);
                            break;
                    }
                }else{
                    break;
                }
            }
            System.out.println("Analysing " + args[j].split("/")[args[j].split("/").length-1]);
            SizeCalculator calc = new SizeCalculator();
            System.out.println("Total: "+ calc.getSize(args[j],recursiveFlag) + "kB");
        }
        else{
            if(args[0].equals("-h")){
                System.out.println(USAGE_MESSAGE);
                System.exit(0);
            }

            System.out.println("Analysing " + args[0].split("/")[args[0].split("/").length-1]);
            SizeCalculator calc = new SizeCalculator();
            System.out.println("Total: "+ calc.getSize(args[0],false) + "kB");
        }
    }

}