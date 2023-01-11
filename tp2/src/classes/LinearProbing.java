package src.classes;

import src.interfaces.HashTable;

public class LinearProbing<AnyType> extends BaseTable<AnyType> implements HashTable<AnyType> {
    public LinearProbing() { super(DEFAULT_TABLE_SIZE); }
    public LinearProbing(int size) { super(size); }
    public int findPos(AnyType x) {
        int currentPos = myhash( x );

        while( array[ currentPos ] != null &&
                !array[ currentPos ].element.equals( x ) )
        {
            currentPos += 1;

            if( currentPos >= array.length )
                currentPos -= array.length;
        }

        return currentPos;
    }
}