public class BinaryTree<T> {
    protected BinaryNode<T> root = null;

    public int size = 0;
    public int insertCounter = 0;
    public int searchCounter = 0;

    public void printPostOrder() {
        printPostOrder(root);
    }

    private void printPostOrder(BinaryNode<T> node) {
        if( node != null )
        {
            printPostOrder( node.left );
            printPostOrder( node.right );
            System.out.println( node.getValue() );
        }
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printPreOrder(BinaryNode<T> node) {
        if( node != null )
        {
            System.out.println( node.getValue() );
            printPreOrder( node.left );
            printPreOrder( node.right );
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(BinaryNode<T> node) {
        if( node != null )
        {
            printInOrder( node.left );
            System.out.println( node.getValue() );
            printInOrder( node.right );
        }
    }
}

