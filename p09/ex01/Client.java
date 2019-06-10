package p09.ex01;
import java.util.Iterator;
import java.util.ListIterator;


//Patterns used:
//  -Iterator Pattern (2 Iterator types - Normal and List)!!
//Other stuff used:
//  -Generic Vector! (code by teacher, but might be useful/interesting)
//  -List Iterator (Can go forwards or backwards)
//  -Could be VERY USEFUL!

class Client{
    public static void main(String[] args) {
        //Create generic vector and add 10 elems (0-9)
        VectorGeneric<Integer> intVector = new VectorGeneric<>();
        for (int i = 0; i < 10; i++)
        intVector.addElem(i);


        // ITERATOR 
        System.out.println("######Iterator######");
        Iterator<Integer> normalIterator = intVector.iterator();
        while (normalIterator.hasNext())
            System.out.println(normalIterator.next());
        


        // LIST ITERATOR (Allows us to move bidirectionally)
        System.out.println("\n######List Iterator######");
        ListIterator<Integer> listIterator = intVector.listIterator();
        
        System.out.println("\nFORWARD");    
        while (listIterator.hasNext())
            System.out.printf("Index %d: %d\n",listIterator.nextIndex(),listIterator.next());
         
        System.out.println("\nBACKWARDS");
        while (listIterator.hasPrevious())
            System.out.printf("Index %d: %d\n",listIterator.previousIndex()+1,listIterator.previous());
 


        // LIST ITERATOR WITH INDEX
        System.out.println("\n######List Iterator with Starting Index######");
        ListIterator<Integer> listIteratorIndex = intVector.listIterator(5);
        
        System.out.println("\nFORWARD");
        while (listIteratorIndex.hasNext())
             System.out.printf("Index %d: %d\n",listIteratorIndex.nextIndex(),listIteratorIndex.next());
         
        System.out.println("\nBACKWARDS");
        while (listIteratorIndex.hasPrevious())
            System.out.printf("Index %d: %d\n",listIteratorIndex.previousIndex()+1,listIteratorIndex.previous());
    
        
        
        // 2 Iterators at the same time
        System.out.println("\n######List Iterator starting index 2 + Iterator######");
        listIteratorIndex = intVector.listIterator(1);
        normalIterator = intVector.iterator();

        while (listIteratorIndex.hasNext()){
            System.out.println("List Iterator: " + listIteratorIndex.next());
            System.out.println("Iterator: "+ normalIterator.next());    
        }
        
        System.out.println("Iterator: "+ normalIterator.next());

    }

}