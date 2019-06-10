package p09.ex02;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

//Patterns used:
//  -Command Pattern (Basically used to simplify and support add operation to list/collection)
//Other stuff used:
//  -Fun uses of generics! (Which might be important)
//Note:
//  -I couldn't Override the execute/undo methods in the abstract command class BECAUSE THEY TAKE IN GENERICS AS PARAMETERS
//SO THE JAVA COMPILER DOESN'T GUARANTEE WHETHER OR NOT THE METHODS IN THE ADD,REMOVE OR ABSTRACT COMMAND ACTUALLY TAKE IN THE SAME
//PARAMETER TYPE, HENCE IT RECOGNIZES THE FUNCTIONS AS BEING DIFFERENT TO EACH OTHER!...thats fun xD

public class Client {
    public static void main(String[] args) {
        System.out.println("#####USING AN ARRAY LIST OF STRINGS#####");

        ArrayList<String> ourList = new ArrayList<>(); //Remember that ArrayLists are subclasses of Collections! That's why this works (Downcasting)
        AddCommand addCommand = new AddCommand(ourList);
        RemoveCommand removeCommand = new RemoveCommand(ourList);

        addCommand.execute("Oi");
        addCommand.execute("Amigo :)");

        System.out.println("Size after 2 addCommands : "+ourList.size());
        if(ourList.size()>1){
            System.out.println("Element at index 0: " + ourList.get(0));
            System.out.println("Element at index 1: " + ourList.get(1));
        }

        addCommand.undo();
        System.out.println("Element at index 0 after first addCommand undo : " + ourList.get(0));

        removeCommand.execute("Oi");
        System.out.println("Size of list after removeCommand on 'Oi' : " + ourList.size());

        removeCommand.undo();
        System.out.println("Element at index 0 after first removeCommand undo : " + ourList.get(0));


        System.out.println("\n#####USING AN ARRAY LIST OF INTEGERS#####");

        ArrayList<Integer> ourList2 = new ArrayList<>();
        addCommand = new AddCommand(ourList2);
        removeCommand = new RemoveCommand(ourList2);

        addCommand.execute(1);
        addCommand.execute(2);

        System.out.println("Size after 2 addCommands : "+ourList2.size());
        if(ourList2.size()>1){
            System.out.println("Element at index 0: " + ourList2.get(0));
            System.out.println("Element at index 1: " + ourList2.get(1));
        }

        addCommand.undo();
        System.out.println("Element at index 0 after first addCommand undo : " + ourList2.get(0));

        removeCommand.execute(1);
        System.out.println("Size of list after removeCommand on '1' : " + ourList2.size());

        removeCommand.undo();
        System.out.println("Element at index 0 after first removeCommand undo : " + ourList2.get(0));
    }
}