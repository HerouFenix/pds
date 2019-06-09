package p06.ex02;
import java.io.File;
import java.util.List;

//Patterns used:
//  -Bridge Pattern (kinda, tenho que refazer este ex, pretty messy but works) 

//Other stuff used:
//  -Java Reflection


class Client{
    public static void main(String[] args){
        ContactsImp addressManager = new ContactsImp();

        File thisFile = new File("p06/ex02/ex2Text.txt");
        ContactsStorageInterface storage = new ContactsStorageImp(thisFile);

        //Try to load Text file
        addressManager.openAndLoad(storage);

        //Try to search by name
        System.out.println(addressManager.getByName("DS"));

        //Try to add new contact and check if its been added
        addressManager.add(new Contact("Adolfo Dias",911));
        System.out.println(addressManager.getByName("Adolfo Dias"));

        //Remove from address list and check if it got removed
        addressManager.remove(addressManager.getByName("Vasco"));
        System.out.println(addressManager.exists(new Contact("Vasco",42)));

        //Open a binary file and save list to it
        thisFile = new File("p06/ex02/ex2Binary");
        storage = new ContactsStorageImp(thisFile);
        addressManager.saveAndClose(storage);

        //Reset list and check that it reset
        System.out.println(addressManager.resetList());
        System.out.println(addressManager.getList());

        //Open binary to check if it got saved
        addressManager.openAndLoad(storage);
        System.out.println(addressManager.getList());
    }
    
}