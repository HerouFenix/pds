package p11.ex01Lambda;
import java.util.Comparator;

public interface Strategy<K>{
    void sort(K[] array,  Comparator<K> comparator);
}
