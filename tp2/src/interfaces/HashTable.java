package src.interfaces;

public interface HashTable<AnyType> {
     void insert(AnyType x);
     int findPos(AnyType x);
     void remove(AnyType x);
     boolean contains(AnyType x);
     void makeEmpty();
}