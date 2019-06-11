package p11.ex01;
import java.util.Comparator;
import java.util.Scanner;

//Patterns used:
//  -Strategy Pattern
//Other stuff used:
//  -Comparators!

public class Client{
    public static void main(String[] args) {
        Phone[] phones = new Phone[] { new Phone(998, 8, "Samsung", 18), new Phone(467.9, 4, "Nokia", 13),
                new Phone(1250, 4, "Apple", 13), new Phone(103.5, 2, "One", 13),
                new Phone(780, 3, "Huawei", 12) };

        Comparator<Phone> comparator = null;
        Context ctx = null;
        Strategy strategy = null;

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
        switch(alg)
        {
            case 1 :
                strategy = new BubbleSort();
                ctx = new Context(strategy);
                ctx.sort(phones,comparator);
                break;
                
            case 2 :
                strategy = new InsertionSort();
                ctx = new Context(strategy);
                ctx.sort(phones,comparator);
                break;
            case 3:
                strategy = new SelectionSort();
                ctx = new Context(strategy);
                ctx.sort(phones,comparator);
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