package p09.ex01;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> {
    private T[] vec;
    private int nElem;
    private final static int ALLOC = 50;
    private int dimVec = ALLOC;
    
    @SuppressWarnings("unchecked")
    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }


    public boolean addElem(T elem) {
        if (elem == null)
            return false;
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }


    private void ensureSpace() {
        if (nElem>=dimVec) {
            dimVec += ALLOC;
            
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[dimVec];
            System.arraycopy(vec, 0, newArray, 0, nElem );
            
            vec = newArray;
        }
    }


    public boolean removeElem(T elem) {
        for (int i = 0; i < nElem; i++) {
            if (vec[i].equals(elem)) {
                if (nElem-i-1 > 0) // not last element
                    System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
                vec[--nElem] = null; // libertar último objecto para o GC
                return true;
            }
        }
        
        return false;
    }


    public int totalElem() {
        return nElem;
    }


    public T getElem(int i) {
        return (T) vec[i];
    }

    //Return iterator
    public Iterator<T> iterator(){
        return (this).new VectorIterator<T>();
    }

    //Return List iterator (starting at index 0)
    public ListIterator<T> listIterator() {
        return new VectorListIterator<T>(0);
    }

    //Return List iterator (starting at specified index)
    public ListIterator<T> listIterator(int index) {
        return new VectorListIterator<T>(index);
    }

    private class VectorIterator<T> implements Iterator<T>{
        private int index;

        VectorIterator(){
            index = 0;
        }

        //Function checks if still have more elements
        public boolean hasNext(){
            return (index < nElem);
        }

        //Function returns the next value in the Vector OR an error message saying we're out of bounds
        public T next(){
            if (hasNext())
                return (T)VectorGeneric.this.vec[index++];
            throw new NoSuchElementException("Index out of bounds!");
            
        }

        //Optional remove function
        public void remove(){
            throw new UnsupportedOperationException("Operation not supported!");
        }

    }

    private class VectorListIterator<T> implements ListIterator<T> {
        private int index;

        VectorListIterator(int index) {
            this.index = index;
        }

        //Added special condition that resets this.index to an acceptable value if it goes out of bounds
        public boolean hasNext() {
            if (this.index < nElem)
                return true;
            else{
                this.index--;
                return false;
            }
        }

        public boolean hasPrevious() {
            if (this.index > 0)
                return true;
            else{
                this.index++;
                return false;
            }
        }

        public T next() {
            if (hasNext())
                return (T) VectorGeneric.this.vec[this.index++];
            throw new NoSuchElementException("Index out of bounds!");
        }

        
        public T previous() {
            if (hasPrevious()) {
                return (T) VectorGeneric.this.vec[this.index--];
            }
            throw new NoSuchElementException("Index out of bounds!");
        }

        public int nextIndex() {
            return this.index+1;
        }

        public int previousIndex() {
            return this.index-1;
        }

        //Optional methods
        public void add(T elem) {
            throw new UnsupportedOperationException("Operation not supported!");
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation not supported!");  
        }

        public void set(T elem) {
            throw new UnsupportedOperationException("Operation not supported!");  
        }
    }
}