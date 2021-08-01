import java.util.Comparator;

public class MaxPQ {
	
    private Object[] heap;
    private int size;
    protected Comparator cmp;
    
    public MaxPQ(int capacity) {
        this(capacity, new DefaultComparator());
    }

    public MaxPQ(int capacity, Comparator cmp) {
        if (capacity < 1) throw new IllegalArgumentException();
        this.heap = new Object[capacity+1];
        this.size = 0;
        this.cmp = cmp;
    }

    public void insert(Object object) {
        // Ensure object is not null
        if (object == null) throw new IllegalArgumentException();
        // Check available space
        if (size == heap.length-1) throw new IllegalStateException();
        // Place object at the next available position
        heap[++size] = object;
        // Let the newly added object swim
        swim(size);
    }

    public Object getMax() {
        // Ensure not empty
        if (size == 0) throw new IllegalStateException();
        // Keep a reference to the root object
        Object object = heap[1];
        // Replace root object with the one at rightmost leaf
        if (size > 1) heap[1] = heap[size];
        // Dispose the rightmost leaf
        heap[size--] = null;
        // Sink the new root element
        sink(1);
        // Return the object removed
        return object;
    }

    private void swim(int i) {
        while (i > 1) {  //if i root (i==1) return
            int p = i/2;  //find parent
            int result = cmp.compare(heap[i], heap[p]);  //compare parent with child
            if (result <= 0) return;    //if child <= parent return
            swap(i, p);                 //else swap and i=p
            i = p;
        }
    }

    private void sink(int i){
        int left = 2*i, right = left+1, max = left;
        // If 2*i >= size, node i is a leaf
        while (left <= size) {
            // Determine the largest children of node i
            if (right <= size) {
                max = cmp.compare(heap[left], heap[right]) < 0 ? right : left;
            }
            // If the heap condition holds, stop. Else swap and go on.
            if (cmp.compare(heap[i], heap[max]) >= 0) return;
            swap(i, max);
            i = max; left = 2*i; right = left+1; max = left;
        }
    }
    
    private void swap(int i, int j) {
        Object tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
    
    public void print() {
        for (int i=1; i<=size; i++){
            System.out.print(heap[i]+ " ");
        }
        System.out.println();
    }
    
    boolean empty(){
        return size == 0;
    }   
    
}