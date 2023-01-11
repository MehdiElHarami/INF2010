package src.classes;

import src.interfaces.HashTable;

public class DoubleHashing<AnyType> extends BaseTable<AnyType> implements HashTable<AnyType> {
    public DoubleHashing() { super(DEFAULT_TABLE_SIZE); }
    public DoubleHashing(int size) { super(size); }
    public int findPos(AnyType x) {
        int currentPos = myhash( x );

        int R = array.length - 2;
        while(!isPrime(R))
            R -= 2;

        int secondHash = R-((x.hashCode()%R < 0 ? x.hashCode()%R + R : x.hashCode()%R));
        secondHash = secondHash == 0? 1 : secondHash;

        while( array[ currentPos ] != null &&
                !array[ currentPos ].element.equals( x ) )
        {
            currentPos += secondHash;

            if( currentPos >= array.length )
                currentPos -= array.length;
        }

        return currentPos;
    }
}