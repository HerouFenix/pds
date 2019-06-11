package p11.ex01;
import java.util.Comparator;

public interface Strategy{
    void sort(Phone[] phones,  Comparator<Phone> comparator);
}

class BubbleSort implements Strategy{
    public void sort(Phone[] phones,  Comparator<Phone> comparator){
        int n = phones.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (comparator.compare(phones[j], phones[j + 1]) > 0) {
                    // swap array[j+1] and array[i]
                    Phone temp = phones[j];
                    phones[j] = phones[j + 1];
                    phones[j + 1] = temp;
                }
    }
}

class InsertionSort implements Strategy{
    public void sort(Phone[] phones,  Comparator<Phone> comparator){
        int n = phones.length;
        for (int i = 1; i < n; ++i) {
            Phone key = phones[i];
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are greater than key, to one position
             * ahead of their current position
             */
            while (j >= 0 && comparator.compare(phones[j], key) > 0) {
                phones[j + 1] = phones[j];
                j = j - 1;
            }
            phones[j + 1] = key;
        }
    }
}

class SelectionSort implements Strategy{
    public void sort(Phone[] phones,  Comparator<Phone> comparator){
        int n = phones.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (comparator.compare(phones[j], phones[min_idx]) < 0)
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            Phone temp = phones[min_idx]; 
            phones[min_idx] = phones[i]; 
            phones[i] = temp; 
        } 
    }
}