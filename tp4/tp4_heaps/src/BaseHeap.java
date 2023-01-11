import java.util.ArrayList;
import java.util.Arrays;

public class BaseHeap<AnyType extends Comparable<AnyType>>{

    /**
     * Private lambda to specify the heap direction (min or max)
     */
    private interface HeapComparator{
        public boolean compare(int x);
    }

    private HeapComparator mainComparator;
    private HeapComparator heapSortComparator;
    private ArrayList<AnyType> array;
    private static boolean DEFAULT_IS_MAX_HEAP = true;

    /**
     * Default constructor which creates an empty max heap
     */
    public BaseHeap() { this(DEFAULT_IS_MAX_HEAP); }

    /**
     * Empty min or max heap constructor
     * @param isMaxHeap determines if structure is MaxHeap or MinHeap
     */
    public BaseHeap(boolean isMaxHeap) {
        heapSortComparator = isMaxHeap ? (x) -> { return x < 0; } : (x) -> { return x > 0; };
        mainComparator = isMaxHeap ? (x) -> { return x > 0; } : (x) -> { return x < 0; };
        array = new ArrayList<AnyType>();
    }

    /**
     * Min or max heap constructor which copies an array
     * @param isMaxHeap determines if structure is MaxHeap or MinHeap
     * @param a array to be copied
     */
    public BaseHeap(boolean isMaxHeap, AnyType a []){
        heapSortComparator = isMaxHeap ? (x) -> { return x < 0; } : (x) -> { return x > 0; };
        mainComparator = isMaxHeap ? (x) -> { return x > 0; } : (x) -> { return x < 0; };
        array = new ArrayList<AnyType>(Arrays.asList(a));
    }

    /**
     * @return Min/Max depending on type of heap created
     */
    public AnyType peek() {
        return array.get(0);
    }

    /**Worst Case O(1)
     * Finds the index of a parent's left child
     * @param parentIndex parent index
     * @return left child index
     */
    private int leftChildIndex(int parentIndex){
        return 2 * parentIndex + 1;
    }

    /**Worst Case O(1)
     * Finds the index of a child's parent
     * @param childIndex child index
     * @return parent index
     */
    private int parentIndex(int childIndex){
        return (childIndex - 1) / 2;
    }

    /**Worst Case O(1)
     * Finds the last child index of the array
     * @return last child index
     */
    private int lastChildIndex(){
        return array.size() - 1;
    }

    /**Worst Case O(log n)
     * Inserts element at last index and percolates up with swaps.
     * making sure `heap` still respects
     * either MinHeap or MaxHeap format depending on `isMaxHeap`
     * @param x Element to insert
     */
    public void insert( AnyType x )
    {
        array.add(null);
        int hole = array.size() - 1;
        for(; hole > 0 && mainComparator.compare(x.compareTo(array.get(parentIndex(hole)))); hole = parentIndex(hole))
            array.set(hole, array.get(parentIndex(hole)));
        array.set(hole, x);
    }

    /**Worst Case O(log n)
     * Deletes heap's root and percolates to find a new min or max
     * making sure `heap` still respects
     * either MinHeap or MaxHeap format depending on `isMaxHeap`
     * @return deleted item
     * @throws UnderflowException when trying to delete empty array
     */
    public AnyType delete() throws UnderflowException {
        if(array.size() == 0)
            throw new UnderflowException("Cannot delete because array is empty");
        AnyType item = array.get(0);
        array.set(0, array.get(lastChildIndex()));
        array.remove(lastChildIndex());
        if (array.size() > 0)
            percolateDown(0, lastChildIndex(), mainComparator);
        return item;
    }

    /**
     * Percolates the heap downwards by swapping the potential index (hole) of root with child.
     * @param hole initial index considered for item insertion before percolation
     * @param n max index considered for percolation
     * @param comp lambda expression to compare items in min or max heap order
     */
    private void percolateDown(int hole, int n, HeapComparator comp)
    {
        int child;
        AnyType tmp = array.get(hole);
        for(; leftChildIndex(hole) < n; hole = child)
        {
            child = leftChildIndex(hole);
            if(child != n - 1 && comp.compare(array.get(child + 1).compareTo(array.get(child))))
                child++;
            if(comp.compare(array.get(child).compareTo(tmp))){
                array.set(hole, array.get(child));
            }
            else
                break;
        }
        array.set(hole, tmp);
    }

    /** Worst Case O(n)
     * assures that min or max is root.
     *
     * Rearrange elements within `data` to respect either MinHeap
     * or MaxHeap format depending on `isMaxHeap`
     */
    public void heapify(){
        for(int i = parentIndex(lastChildIndex()); i >= 0; i--)
            percolateDown(i, lastChildIndex() + 1, mainComparator);
    }

    /**Worst Case O(n log n)
     * Sorts the internal array
     * @return copy of internal sorted array
     * Elements will be in ascending order if it is a MinHeap
     * Elements will be in descending order if it is a MaxHeap
     */
    public ArrayList<AnyType> heapsort(){
        for(int i = parentIndex(lastChildIndex()); i >= 0; i--)
            percolateDown(i, lastChildIndex() + 1, heapSortComparator);
        AnyType tmp;
        for(int i = lastChildIndex(); i > 0; i--) {
            tmp = array.get(0);
            array.set(0, array.get(i));
            array.set(i, tmp);
            percolateDown(0, i, heapSortComparator);
        }
        return new ArrayList<AnyType>(array);
    }

    /**
     * Prints array
     */
    public void print(){
        System.out.println(array);
    }

    /**
     * Solution to problems of section 3, expecting Pair items in the array (See Main)
     * @param Q order of the element to find
     * @return element of order Q in heap
     * @throws UnderflowException
     */
    public AnyType qFunction(int Q) throws UnderflowException {
        this.heapsort();
        for (int q = 1; q < Q; q++)
            this.delete();
        return this.delete();
    }
};

/**
 * Used to test BaseHeap class
 */
class Main {
    public static void main(String[] args) throws UnderflowException {

        int MAX_ARRAY_LENGTH = 25;

        BaseHeap<Integer> emptyMaxHeap = new BaseHeap<Integer>();
        BaseHeap<Integer> emptyMinHeap = new BaseHeap<Integer>(false);
        int rdInt;

        System.out.println("\t===== PARTIE 1 =====");
        System.out.println("Inserting consecutively:");

        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            rdInt = (int) (Math.random() * 100);
            System.out.printf(rdInt + " ");
            emptyMaxHeap.insert(rdInt);
            emptyMinHeap.insert(rdInt);
        }

        System.out.println();
        System.out.println("Max Heap:");
        emptyMaxHeap.print();
        System.out.println("Min heap:");
        emptyMinHeap.print();

        System.out.println("Emptying Max Heap:");
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++)
            System.out.printf(emptyMaxHeap.delete() + " ");

        System.out.println("\nEmptying Min Heap:");
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++)
            System.out.printf(emptyMinHeap.delete() + " ");

        Integer[] arrayToHeapify = new Integer[25];
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++)
            arrayToHeapify[i] = (int) (Math.random() * 100);
        BaseHeap<Integer> maxHeapToHeapify = new BaseHeap<Integer>(true, arrayToHeapify);
        BaseHeap<Integer> minHeapToHeapify = new BaseHeap<Integer>(false, arrayToHeapify);

        System.out.println("\nUnheapified array:");
        maxHeapToHeapify.print();
        System.out.println("Heapified Max Heap:");
        maxHeapToHeapify.heapify();
        maxHeapToHeapify.print();
        System.out.println("Heapified Min Heap:");
        minHeapToHeapify.heapify();
        minHeapToHeapify.print();

        System.out.println("\n\n\t===== PARTIE 2 =====");

        Integer[] array1 = new Integer[25];
        Integer[] array2 = new Integer[25];
        Integer[] array3 = new Integer[25];
        for (int i = 0; i < MAX_ARRAY_LENGTH; i++) {
            array1[i] = (int) (Math.random() * 100);
            array2[i] = (int) (Math.random() * 100);
            array3[i] = (int) (Math.random() * 100);
        }

        BaseHeap<Integer> maxHeapFromArray1 = new BaseHeap<Integer>(true, array1);
        BaseHeap<Integer> maxHeapFromArray2 = new BaseHeap<Integer>(true, array2);
        BaseHeap<Integer> maxHeapFromArray3 = new BaseHeap<Integer>(true, array3);
        BaseHeap<Integer> minHeapFromArray1 = new BaseHeap<Integer>(false, array1);
        BaseHeap<Integer> minHeapFromArray2 = new BaseHeap<Integer>(false, array2);
        BaseHeap<Integer> minHeapFromArray3 = new BaseHeap<Integer>(false, array3);

        System.out.println("Arrays:");
        maxHeapFromArray1.print();
        maxHeapFromArray2.print();
        maxHeapFromArray3.print();

        System.out.println("Sorted Max Heaps:");
        System.out.println(maxHeapFromArray1.heapsort());
        System.out.println(maxHeapFromArray2.heapsort());
        System.out.println(maxHeapFromArray3.heapsort());

        System.out.println("Sorted Min Heaps:");
        System.out.println(minHeapFromArray1.heapsort());
        System.out.println(minHeapFromArray2.heapsort());
        System.out.println(minHeapFromArray3.heapsort());

        System.out.println("\n\t===== PARTIE 3 =====");

        String[] qArray = new String[] {"aaa", "abc", "aab", "AaAb", "zsw" };
        BaseHeap<Pair> qMaxHeap = new BaseHeap<Pair>();
        Pair pair;
        for(int i = 0; i < qArray.length; i++){
            pair = new Pair(qArray[i], (int) qArray[i].chars().filter(c -> c == 'a').count());
            qMaxHeap.insert(pair);
        }

        System.out.println("String Array:");
        qMaxHeap.print();
        System.out.println("Item with 'a' frequency of 2:");
        System.out.println(qMaxHeap.qFunction(2));

        Integer[] kArray = new Integer[] {1,1,1,1,2,3,4,5,5,6,7,8,9,9,9};
        BaseHeap<Pair> kMaxHeap = new BaseHeap<Pair>();

        int freqCounter = 1;
        Integer tmp = kArray[0];
        for(int i = 1; i < kArray.length; i++){
            if (kArray[i] == tmp)
                freqCounter++;
            else{
                pair = new Pair(tmp.toString(), freqCounter);
                kMaxHeap.insert(pair);
                tmp = kArray[i];
                freqCounter = 1;
            }
        }
        pair = new Pair(tmp.toString(), freqCounter);
        kMaxHeap.insert(pair);

        System.out.println("Integer Array:");
        kMaxHeap.print();
        System.out.println("Item with second most frequency:");
        System.out.println(kMaxHeap.qFunction(2));
    }
}
