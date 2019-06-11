package p11.ex01Lambda;
import java.util.Comparator;
import java.util.Scanner;

import p11.ex01.Phone;

//Patterns used:
//  -Strategy Pattern
//Other stuff used:
//  -Comparators!
//  -LAMBDA EXPRESSIONS !!!!!!!!!!!!!
//  -JAVA REFLECTION !!!!!!!!! (Cast Object to an array's type)

public class Client{
    public static void main(String[] args) {
        Phone[] phones = new Phone[] { new Phone(998, 8, "Samsung", 18), new Phone(467.9, 4, "Nokia", 13),
                new Phone(1250, 4, "Apple", 13), new Phone(103.5, 2, "One", 13),
                new Phone(780, 3, "Huawei", 12) };

        Comparator<Phone> comparator = null;

        Scanner sc = new Scanner(System.in);  // Reading from System.in
        
        System.out.println("---Order by---");
        System.out.println("1) Price");
        System.out.println("2) Memory");
        System.out.println("3) Brand");
        System.out.println("4) Camera");
        System.out.print(">");
        int ordBy = sc.nextInt();
        
        System.out.println("---Order---");
        System.out.println("1) Ascending");
        System.out.println("2) Descending");
        System.out.print(">");
        int ord = sc.nextInt();
        
        System.out.println("---Algorithm---");
        System.out.println("1) Bubble Sort");
        System.out.println("2) Insertion Sort");
        System.out.println("3) Selection Sort");
        System.out.print(">");
        int alg = sc.nextInt();

        sc.close();
        
        switch(ordBy)
        {
            case 1 :
                if(ord == 1)
                    comparator = new priceCompAscending();
                else
                    comparator = new priceCompDescending();
                break;
                
            case 2 :
                if(ord == 1)
                    comparator = new memCompAscending();
                else
                    comparator = new memCompDescending();
                break;
                
            case 3:
                if(ord == 1)
                    comparator = new brandCompAscending();
                else
                    comparator = new brandCompDescending();
                break;
            
            case 4:
                if(ord == 1)
                    comparator = new cameraCompAscending();
                else
                    comparator = new cameraCompDescending();
        }

        Strategy<Phone> computation; //Our Strategy (Generic Type -> Phone)
        switch(alg)
        {
            case 1 :

                //Set computation to BUBBLE SORT
                computation = (array,comp)-> { 
                        int n = array.length;
                        for (int i = 0; i < n - 1; i++)
                            for (int j = 0; j < n - i - 1; j++)
                                if (comp.compare(array[j], array[j + 1]) > 0) {
                                    // swap array[j+1] and array[i]

                                    //Use Java Reflections to cast temp to our generic type (same as array) !!!!!
                                    Object temp = array[j];
                                    array[j] = array[j + 1];
                                    array[j + 1] = array[0].getClass().cast(temp);
                                }
                }; 

                computation.sort(phones, comparator);
                break;
                
            //case 2 :
            case 2:

                //Set computation to INSERTION SORT
                computation = (array,comp)-> { 
                    int n = array.length;
                    for (int i = 1; i < n; ++i) {
                        Object key = array[i];
                        int j = i - 1;
            
                        /*
                         * Move elements of arr[0..i-1], that are greater than key, to one position
                         * ahead of their current position
                         */
                        while (j >= 0 && comp.compare(array[j], array[0].getClass().cast(key)) > 0) {
                            array[j + 1] = array[j];
                            j = j - 1;
                        }
                        array[j + 1] = array[0].getClass().cast(key);
                    }
                }; 

                computation.sort(phones, comparator);
                break;
            case 3:

                //Set computation to SELECTION SROT
                computation = (array,comp)-> { 
                    int n = array.length; 
                    // Class<?> elemsClass = array.getClass().getComponentType(); SOMEWHY THIS DOESN'T WORK!
                    // https://stackoverflow.com/questions/21569868/try-to-do-typecast-but-getting-cap1-error THIS IS WHY!

                    // One by one move boundary of unsorted subarray 
                    for (int i = 0; i < n-1; i++) 
                    { 
                        // Find the minimum element in unsorted array 
                        int min_idx = i; 
                        for (int j = i+1; j < n; j++) 
                            if (comp.compare(array[j], array[min_idx]) < 0)
                                min_idx = j; 
              
                        // Swap the found minimum element with the first 
                        // element 
                        
                        Object temp = array[min_idx]; 
                        array[min_idx] = array[i]; 

                        //Use Java Reflections to cast temp to our generic type (same as array) !!!!!
                        array[i] = array[0].getClass().cast(temp);
                    }
                }; 

                computation.sort(phones, comparator);
                break;
        }
        System.out.println("Result:");
        for (Phone p : phones) {
            System.out.println(p);
            
        }
        
    }

    static class cameraCompAscending implements Comparator<Phone> {
        @Override
        public int compare(Phone a, Phone b) {
            return a.getCamera() > b.getCamera() ? 1 : a.getCamera() == b.getCamera() ? 0 : -1;
        }
    }
    
    static class cameraCompDescending implements Comparator<Phone> {
        @Override
        public int compare(Phone a, Phone b) {
            return a.getCamera() < b.getCamera() ? -1 : a.getCamera() == b.getCamera() ? 0 : 1;
        }
    } 

    static class priceCompAscending implements Comparator<Phone> {
        @Override
        public int compare(Phone a, Phone b) {
            return a.getPrice() > b.getPrice() ? 1 : a.getPrice() == b.getPrice() ? 0 : -1;
        }
    }
    
    static class priceCompDescending implements Comparator<Phone> {
        @Override
        public int compare(Phone a, Phone b) {
            return a.getPrice() < b.getPrice() ? -1 : a.getPrice() == b.getPrice() ? 0 : 1;
        }
    }
    
    static class memCompAscending implements Comparator<Phone> {
        @Override
        public int compare(Phone a, Phone b) {
            return a.getMemory() > b.getMemory() ? 1 : a.getMemory() == b.getMemory() ? 0 : -1;
        }
    }
    
    static class memCompDescending implements Comparator<Phone> {
        @Override
        public int compare(Phone a, Phone b) {
            return a.getMemory()< b.getMemory() ? -1 : a.getMemory() == b.getMemory() ? 0 : 1;
        }
    }
    
    static class brandCompAscending implements Comparator<Phone> {
        @Override
        public int compare(Phone a, Phone b) {
            return a.getBrand().compareToIgnoreCase(b.getBrand());
        }
    }
    
    static class brandCompDescending implements Comparator<Phone> {
        @Override
        public int compare(Phone a, Phone b) {
            return - a.getBrand().compareToIgnoreCase(b.getBrand());
        }
    }  
}