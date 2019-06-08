package p06.ex02;
import java.io.*;
import java.util.*;

public interface ContactsStorageInterface{
    public List<Contact> loadContacts();
    public boolean saveContacts(List<Contact> list);
}

class ContactsStorageImp implements ContactsStorageInterface{
    private File textFile;
    public ContactsStorageImp(File ourFile){
        try{
            textFile = ourFile;
        }catch(Exception e){
            System.out.println("ERRO! " + e.toString());
            System.exit(1);
        }
    }

    public void changeFile(String textPath){
        try{
            textFile = new File(textPath);
        }catch(Exception e){
            System.out.println("ERRO! " + e.toString());
            System.exit(1);
        }    
    }

    //Check file type via the extension
    private String checkFileType(){
        String[] fileName = textFile.getName().split("\\.");
        String ext;
        //This solution works assuming that the filepath contains, at max, 1 "." :(
        if(fileName.length > 1){
            ext = fileName[1];
        }else{
            ext = "binary";
        }

        //Upper case first letter
        ext = ext.substring(0,1).toUpperCase() + ext.substring(1);

        return ext;
    }

    public List<Contact> loadContacts(){
        //Get the type of file from its extension
        String ext = checkFileType();

        try{

            String storageType = "ContactsStorage"+ext;

            //Use java reflection to create the specific storage type
            ContactsStorageInterface specificStorage = (ContactsStorageInterface) Class.forName("p06.ex02."+storageType).getConstructor(File.class).newInstance(textFile);

            //Get the contact list using that storage's loadContacts function
            return specificStorage.loadContacts();

        }catch(Exception e){
            System.out.println("ERRO! " + e.toString());
            System.exit(1);
        }

        return null;
    }
    
    public boolean saveContacts(List<Contact> list){  
        //Get the type of file from its extension
        String ext = checkFileType();

        try{

            String storageType = "ContactsStorage"+ext;

            //Use java reflection to create the specific storage type
            ContactsStorageInterface specificStorage = (ContactsStorageInterface) Class.forName("p06.ex02."+storageType).getConstructor(File.class).newInstance(textFile);

            //Get the contact list using that storage's loadContacts function
            return specificStorage.saveContacts(list);

        }catch(Exception e){
            System.out.println("ERRO! " + e.toString());
            System.exit(1);
        }

        
        return true;
    };
}

class ContactsStorageTxt extends ContactsStorageImp implements ContactsStorageInterface{
    private File textFile;

    public ContactsStorageTxt(File ourFile){
        super(ourFile);
        this.textFile = ourFile;
    }

    public List<Contact> loadContacts(){
        try{
            Scanner fileScanner = new Scanner(textFile);
    
            List<Contact> contacts = new ArrayList<>();
            //Go through all contents of file
            while (fileScanner.hasNext()) {
                //String currentLine[] = fileScanner.nextLine();
                //Split each line by tabs
                /*String[] currentContacts = currentLine.split("\\t"); NOTE THIS WASN'T WORKING SOMEWHY I COULDN'T DETECT THE TABS :(

    
                for(String currentContact : currentContacts){
                    //Change our Contac object to fit the current contacts parameters
                    contact.setName(currentContact.split(" ")[0]);
                    contact.setNumber(Integer.parseInt(currentContact.split(" ")[1]));
    
                    contacts.add(contact); //Add the new contact
                }*/

                String currentLine[] = fileScanner.nextLine().split("\\s+");
                for(int i = 0 ; i < currentLine.length ; i++){
                    //Add current contact
                    Contact contact = new Contact(currentLine[i],Integer.parseInt(currentLine[++i]));
                    contacts.add(contact); //Add the new contact
                }
            }

            fileScanner.close();

            return contacts;
        }catch(Exception e){
            System.out.println("ERROR! "+e.toString());
        }

        return null;
    }
    
    public boolean saveContacts(List<Contact> list){    
        try{
            FileWriter writer = new FileWriter(textFile.getName());
            PrintWriter printWriter = new PrintWriter(writer);
            //Write contacts from list
            for(Contact currentContact : list){
                printWriter.print(currentContact.toString() + " ");
            }

            printWriter.close();
            writer.close();

            return true;
        }catch(Exception e){
            return false;
        }
    };
}

class ContactsStorageBinary extends ContactsStorageImp implements ContactsStorageInterface{
    private File binaryFile;

    public ContactsStorageBinary(File ourFile){
        super(ourFile);
        this.binaryFile = ourFile;
    }

    public List<Contact> loadContacts(){
        try{
            List<Contact> contacts = new ArrayList<>();
            //Go through all contents of file
            FileReader fileReader = new FileReader(binaryFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null) {

                String currentLine[] = line.split(" - ");
                for(int i = 0 ; i < currentLine.length ; i++){
                    //Add current contact
                    Contact contact = new Contact(currentLine[i],Integer.parseInt(currentLine[++i]));
                    contacts.add(contact); //Add the new contact
                }        
            }

            bufferedReader.close();
            fileReader.close();

            return contacts;
        }catch(Exception e){
            System.out.println("ERROR! "+e.toString());
        }

        return null;
    }
    
    public boolean saveContacts(List<Contact> list){    
        try{
            FileWriter fileWriter = new FileWriter(this.binaryFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            //Write contacts from list
            for(Contact currentContact : list){
               bufferedWriter.write(currentContact.toString());
               bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();

            return true;
        }catch(Exception e){
            return false;
        }
    };
}