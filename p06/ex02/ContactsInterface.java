package p06.ex02;
import java.util.*;
import java.io.*;

public interface ContactsInterface{
    public void openAndLoad(ContactsStorageInterface store);
    public void saveAndClose();
    public void saveAndClose(ContactsStorageInterface store);
    public boolean exists(Contact contact);
    public Contact getByName(String name);
    public boolean add(Contact contact);
    public boolean remove(Contact contact);
}

class ContactsImp implements ContactsInterface{
    private List<Contact> contacts;

    public ContactsImp(){
        this.contacts = new ArrayList<>();
    }

    public List<Contact> getList(){
        return this.contacts;
    }

    public boolean resetList(){
        try{
            this.contacts.removeAll(this.contacts);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void openAndLoad(ContactsStorageInterface store){
        //Load the contacts into our local Contact list
        this.contacts.addAll(store.loadContacts());
    };

    public void saveAndClose(){
        //Check if we have contacts to add
        if(contacts.size()<1){
            System.out.println("ERRO! AddressList was never initialized! Call openAndLoad first!");
            return;
        }

        Scanner input = new Scanner(System.in);

        //Get path name
        System.out.println("Type in the File's Path:");
        String filePath = input.nextLine();
        input.close();

        //Try to open a File with the specified path 
        try{
           File addressFile = new File(filePath);
           ContactsStorageInterface ourStorage = new ContactsStorageImp(addressFile);

           //Try to save contacts and save the result of the operation as a flag
           boolean testFlag = ourStorage.saveContacts(this.contacts);

           if(testFlag){
               System.out.println("Success!");
           }else{
               System.out.println("Error! Operation not completed!");
           }

        }catch(Exception e){
            System.out.println("ERRO! " + e.toString());
            System.exit(1);
        }
    };

    public void saveAndClose(ContactsStorageInterface store){
        //Check if we have contacts to add
        if(contacts.size()<1){
            System.out.println("ERRO! AddressList was never initialized! Call openAndLoad first!");
            return;
        }

        //Try to save contacts and save the result of the operation as a flag
        boolean testFlag = store.saveContacts(this.contacts);

        if(testFlag){
            System.out.println("Success!");
        }else{
            System.out.println("Error! Operation not completed!");
        }
    };

    public boolean exists(Contact contact){
        //Go through entire list of contacts and return first time the name & number correspond
        for(Contact i : this.contacts){
            if(i.toString().equals(contact.toString())){
                return true;
            }
        }
        return false;
    };

    public Contact getByName(String name){
        //Go through entire list of contacts and return first time the name corresponds
        for(Contact i : this.contacts){
            if(i.getName().equals(name)){
                return i;
            }
        }

        System.out.println("Contact not found!");
        return null;
    };

    public boolean add(Contact contact){

        //First check if it exists (return false if it does since we're not gonna add a duplicate)
        if(this.exists(contact)){
            return false;
        }else{
            contacts.add(contact);
            return true;
        }
    };

    public boolean remove(Contact contact){
        
        //First check if it exists (return false if it doesnt since that means we have nothing to remove)
        if(contact != null && this.exists(contact)){
            contacts.remove(contact);
            return true;
        }else{
            return false;
        } 
    };

}