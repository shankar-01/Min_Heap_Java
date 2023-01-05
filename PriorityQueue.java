import java.util.AbstractQueue;
import java.util.Iterator;

public class PriorityQueue<E extends Comparable<? super E>> extends AbstractQueue<E>{
    private E[] queue = null;
    private int size = 0;
    public PriorityQueue() {
        queue = null;
    }

    @Override
    public boolean add(E e) {
        if(e == null){
            throw new NullPointerException();
        }
        if(queue == null){
            queue = (E[]) new Comparable[2];
            queue[++size] = e;
        }
        else{
            if((size +1) == queue.length){
                grow();
            }
            queue[++size] = e;
            sift(size);
        }

        return true;
    }
    private void sift(int i){
        while( i > 1 && queue[i].compareTo(queue[parent(i)]) < 0){
            swap(i, parent(i));
            i = parent(i);
        }
    }
    private void swap(int i , int p){
        E temp = queue[i];
        queue[i] = queue[p];
        queue[p] = temp;
    }
    private void grow(){
        E[] temp = queue;
        queue = (E[]) new Comparable[temp.length * 2];
        for(int i =0; i<temp.length; i++){
            queue[i] = temp[i];
        }
    }
    private int parent(int i){
        return i/2;
    }
    @Override
    public boolean offer(E e) {
        return add(e);
    }

    @Override
    public E remove() {
        if(size < 1){
            return null;
        }
        E temp = queue[1];
        queue[1] = queue[size];
        queue[size--] = null;
        siftDown(1);
        return temp;
    }
    private void siftDown(int i){
        int mi = i;
        int l = leftChild(i);
        if(l <= size && queue[l].compareTo(queue[mi])<0){
            mi = l;
        }
        int r = rightChild(i);
        if(r <= size && queue[r].compareTo(queue[mi])<0){
            mi = r;
        }
        if(i != mi){
            swap(i, mi);
            siftDown(mi);
        }

    }
    private int leftChild(int i){
        return 2 * i;
    }
    private int rightChild(int i){
        return 2 * i + 1;
    }

    @Override
    public String toString() {
        String str = "[";
        if (queue != null){
            for (int i = 0; i <= size; i++) {
                str += queue[i] + ", ";
            }
            str = str.substring(0, str.length() - 2);
        }
        str +="]";
        return str;
    }
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E poll() {
        return remove();
    }

    @Override
    public E peek() {
        if(size  < 1){
            return null;
        }
        return queue[1];
    }

    @Override
    public E element() {
        return peek();
    }

    public String toTree(){
        String str = "";
        int space = size*2;
        int m = 0;
        int i =1;
        while(i<=size){
            m = i+1;
            int ts = space*2;
            for(int j=1; j<m && i<= size; i++, j++){
                str += String.format("%"+space+"d", queue[i]);
                space = ts;
            }
            str +=System.lineSeparator();
            space /=4;
        }
        return str;
    }
}
