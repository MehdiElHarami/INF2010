public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T>{
    @Override
    public void add(T value) {
        this.root = add(value, this.root);
    }

    protected BinaryNode<T> add(T value, BinaryNode<T> curNode) {
        insertCounter++;
        if( curNode == null )
            return new BinaryNode<>( value );
        int compareResult = value.compareTo( curNode.value );
        if( compareResult < 0 )
            curNode.left = add( value, curNode.left );
        else if( compareResult > 0 )
            curNode.right = add( value, curNode.right );
        else
            ;
        return balance( curNode );
    }

    protected BinaryNode<T> balance( BinaryNode<T> curNode )
    {
        if ( curNode == null )
            return curNode;
        if ( BinaryNode.getHeight( curNode.left ) - BinaryNode.getHeight( curNode.right ) > 1 ) {
            if ( BinaryNode.getHeight( curNode.left.left ) < BinaryNode.getHeight( curNode.left.right ) )
                curNode.left = rotateRight( curNode.left );
            curNode = rotateLeft( curNode );
        }
        else if ( BinaryNode.getHeight( curNode.right ) - BinaryNode.getHeight( curNode.left ) > 1 ) {
            if ( BinaryNode.getHeight( curNode.right.right ) < BinaryNode.getHeight( curNode.right.left ) )
                curNode.right = rotateLeft( curNode.right );
            curNode = rotateRight( curNode );
        }
        curNode.height = Math.max( BinaryNode.getHeight( curNode.left ), BinaryNode.getHeight( curNode.right ) ) + 1;
        return curNode;
    }

    @Override
    public void remove(T value) {
        this.root = remove(value, this.root);
    }

    protected BinaryNode<T> remove(T value, BinaryNode<T> curNode) {
        if( curNode == null )
            return curNode;
        int compareResult = value.compareTo( curNode.value );
        if( compareResult < 0 )
            curNode.left = remove( value, curNode.left );
        else if( compareResult > 0 )
            curNode.right = remove( value, curNode.right );
        else if( curNode.left != null && curNode.right != null )
        {
            curNode.value = findMin( curNode.right ).value;
            curNode.right = remove( curNode.value, curNode.right );
        }
        else
            curNode = ( curNode.left != null ) ? curNode.left : curNode.right;
        return balance( curNode );
    }

   private BinaryNode<T> rotateLeft( BinaryNode<T> curNode )
   {
       insertCounter++;
       BinaryNode<T> otherNode = curNode.left;
       curNode.left = otherNode.right;
       otherNode.right = curNode;
       curNode.height = Math.max( BinaryNode.getHeight( curNode.left ), BinaryNode.getHeight( curNode.right ) ) + 1;
       otherNode.height = Math.max( BinaryNode.getHeight( otherNode.left ), curNode.height ) + 1;
       return otherNode;
   }

    private BinaryNode<T> rotateRight( BinaryNode<T> curNode )
    {
        insertCounter++;
        BinaryNode<T> otherNode = curNode.right;
        curNode.right = otherNode.left;
        otherNode.left = curNode;
        curNode.height = Math.max( BinaryNode.getHeight( curNode.left ), BinaryNode.getHeight( curNode.right ) ) + 1;
        otherNode.height = Math.max( BinaryNode.getHeight( otherNode.left ), curNode.height ) + 1;
        return otherNode;
    }
}
