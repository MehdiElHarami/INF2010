package src.classes;

import src.interfaces.HashTable;

public class QuadraticProbing<AnyType> extends BaseTable<AnyType> implements HashTable<AnyType> {
    public QuadraticProbing() { super(DEFAULT_TABLE_SIZE); }
    public QuadraticProbing(int size) { super(size); }
    public int findPos(AnyType x) {
        int offset = 1;
        int currentPos = myhash( x );

        while( array[ currentPos ] != null &&
                !array[ currentPos ].element.equals( x ) )
        {
            currentPos += offset;
            offset += 2;

            if( currentPos >= array.length )
                currentPos -= array.length;
        }

        return currentPos;
    }
}