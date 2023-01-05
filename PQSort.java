import java.util.PriorityQueue;

public class PQSort {
    public static <E extends Comparable<? super E>> void heapsort(E[] a){
        PriorityQueue<E> pq = new PriorityQueue<E>();
        for(E e : a) pq.add(e);
        for(int i =0; !pq.isEmpty(); i++)a[i] = pq.remove();
    }
    public static <E extends Comparable<? super E>> void heapsort2011(E[] a){
        PriorityQueue2011<E> pq = new PriorityQueue2011<>();
        for(E e : a)pq.add(e);
        for(int i=0; !pq.isEmpty(); i++)a[i] = pq.remove();
    }
}
