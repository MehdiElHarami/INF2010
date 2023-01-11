package src.classes;

import src.interfaces.HashTable;

public class BaseTable<AnyType> implements HashTable<AnyType> {
    protected static final int DEFAULT_TABLE_SIZE = 11;
    protected HashEntry<AnyType>[] array;

    private int currentSize;
    public BaseTable() {
        this(DEFAULT_TABLE_SIZE);
    }
    public BaseTable(int size) {
        allocateArray(size);
        makeEmpty();
    }
    public void insert(AnyType x) {
        int currentPos = findPos(x);
        if(isActive(currentPos))
            return;

        array[currentPos] = new HashEntry<>(x,true);

        if(++currentSize > array.length / 2)
            rehash();
    }
    private void rehash( )
    {
        HashEntry<AnyType> [ ] oldArray = array;

        allocateArray( nextPrime( 2 * oldArray.length) );
        currentSize = 0;

        for( int i = 0; i < oldArray.length; i++ )
            if( oldArray[ i ] != null && oldArray[ i ].isActive )
                insert( oldArray[ i ].element );
    }
    public int findPos(AnyType x) {
        return 0;
    }
    public void remove(AnyType x) {
        int currentPos = findPos(x);
        if(isActive(currentPos))
            array[currentPos].isActive = false;
    }
    public boolean contains(AnyType x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }
    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }
    public void makeEmpty() {
        currentSize = 0;
        for(int i = 0; i < array.length; i++)
            array[i] = null;
    }
    private void allocateArray(int arraySize) {
        array = new HashEntry[nextPrime(arraySize)];
    }
    private static int nextPrime( int n) {
        if(n <= 0)
            n = 3;

        if(n % 2 == 0)
            n++;

        for(; !isPrime(n); n += 2)
            ;

        return n;
    }
    protected static boolean isPrime(int n) {
        if(n == 2 || n == 3)
            return true;

        if(n == 1 || n % 2 == 0)
            return false;

        for(int i = 3; i * i <= n; i += 2)
            if(n % i == 0)
                return false;

        return true;
    }
    protected int myhash(AnyType x)
    {
        int hashVal = x.hashCode();

        hashVal %= array.length;
        if(hashVal < 0)
            hashVal += array.length;

        return hashVal;
    }
    protected static class HashEntry<AnyType> {
        public AnyType  element;
        public boolean isActive;

        public HashEntry(AnyType e) {
            this(e, true);
        }

        public HashEntry(AnyType e, boolean i) {
            element  = e;
            isActive = i;
        }
    }
}