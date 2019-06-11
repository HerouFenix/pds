package p03.ex02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        Street street = new Street();
        menu(street, args);

    }

    // Menu function that handles the user interface of the program
    public static void menu(Street street, String[] args) {
        String input, fileName, personName;
        String[] memberData;
        Scanner sc;
        if (args.length == 1) {
            String commands = readCommandsFile(args[0]);
            if (commands == null) {
                System.exit(1);
            }
            sc = new Scanner(commands);
        } else
            sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nCommands available: Load, Map, Add, Remove, List, Lookup, Clear, Quit");
            System.out.println("Command:");
            input = sc.next().toLowerCase();
            switch (input) {
            case "quit":
                System.exit(0);
                break;

            case "load":
                System.out.println("Insert File Name:");
                fileName = sc.next();
                readLoadFile(fileName, street);
                break;

            case "map":
                if (street.isEmpty())
                    System.out.println("\nYou didn't add any information yet!");
                else
                    System.out.println(street);
                break;

            case "add":
                System.out.println("Insert name x1 x2:");
                if (args.length == 0)
                    sc.nextLine();
                memberData = dealWithMemberInput(sc.nextLine().trim());
                if (memberData != null) {
                    street.add(memberData[0], Integer.parseInt(memberData[1]), Integer.parseInt(memberData[2]));
                }
                break;

            case "remove":
                if (street.isEmpty()) {
                    System.out.println("\nYou didn't add any information yet!");
                } else {
                    System.out.print("Insert Person's Name:");
                    personName = sc.next();
                    street.remove(personName);
                }
                break;

            case "list":
                if (street.isEmpty()) {
                    System.out.println("\nYou didn't add any information yet!");
                } else {
                    street.list();
                }
                break;

            case "lookup":
                if (street.isEmpty()) {
                    System.out.println("\nYou didn't add any information yet!");
                } else {
                    System.out.println("Insert Person's Name:");
                    personName = sc.next();
                    street.lookup(personName);
                }
                break;

            case "clear":
                street.clear();
                break;

            default:
                System.err.println("ERROR: Command does not exist!");
            }
        }
    }

    // Reads file with commmands to feed the main function
    public static String readCommandsFile(String fileName) {
        Path path = Paths.get(fileName);
        List contents;
        try {
            contents = Files.readAllLines(path);

        } catch (IOException ex) {
            System.err.println("ERROR: Invalid File Name!");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object line : contents) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    // Reads members' info from file and inserts it to street
    public static void readLoadFile(String fileName, Street street) {
        Path path = Paths.get(fileName);
        List contents;
        try {
            contents = Files.readAllLines(path);

        } catch (IOException ex) {
            System.err.println("ERROR: Invalid File Name!");
            return;
        }
        for (int i = 0; i < contents.size(); i++) {
            String line = contents.get(i).toString();
            if (i == 0 & line.charAt(0) == '>')
                continue;
            else {
                String[] personInfo = line.split("[-|\\s]+");
                street.add(personInfo[2], Integer.parseInt(personInfo[0]), Integer.parseInt(personInfo[1]));
            }
        }
    }

    // Checks if input is correspondent to expected (number of elements and it's
    // type).
    // If input is valid return String[] = {name, x1, x2}; otherwise returns null.
    public static String[] dealWithMemberInput(String memberInput) {
        String[] data = memberInput.split(" ");
        if (data.length != 3 || data[0].isEmpty() || data[1].isEmpty() || data[2].isEmpty()) {
            System.err.println("ERROR: BAD input");
            return null;
        }

        if (!(data[1].matches("^\\d+$") && data[1].matches("^\\d+$"))) {
            System.err.println("Second and Third argument must be positive integers!");
            return null;
        }
        return data;
    }
}
