class AVLTreeTester {
    public static void main(String[] args) {

        AvlTree<Integer> avl = new AvlTree<Integer>();
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        Integer[] toInsert = {1,2,3,4};
        for(int i = 0; i < toInsert.length; i++) {
            avl.add(toInsert[i]);
            bst.add(toInsert[i]);
        }

        System.out.println(avl.insertCounter);
        System.out.println(bst.insertCounter);

        System.out.println("Parcours préordre de BST: "); bst.printPreOrder(); System.out.println("");
        System.out.println("Parcours en ordre de BST: "); bst.printInOrder(); System.out.println("");
        System.out.println("Parcours postordre de BST: "); bst.printPostOrder(); System.out.println("");

        System.out.println("Parcours préordre de AVL: "); avl.printPreOrder(); System.out.println("");
        System.out.println("Parcours en ordre de AVL: "); avl.printInOrder(); System.out.println("");
        System.out.println("Parcours postordre de AVL: "); avl.printPostOrder(); System.out.println("");
    }
}
