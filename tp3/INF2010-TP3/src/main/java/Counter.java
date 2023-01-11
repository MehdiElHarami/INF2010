import java.util.*;
public class Counter {
    private static int N_TREES = 50;
    public static ArrayList<Integer> generateRandomArray(int size) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int rdInt = 0;
        for (int i = 0; i < size; i++) {
            rdInt = (int)(Math.random()*10000);
            arr.add(rdInt);
        }
        return arr;
    }

    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list)
    {
        Set<Integer> set = new LinkedHashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    public static BinarySearchTree<Integer> createBinarySearchTree(ArrayList<Integer> arr) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        for (int i = 0; i < arr.size(); i++) {
            bst.add(arr.get(i));
            bst.size++;
        }
        return bst;
    }

    public static AvlTree<Integer> createAvlTree(ArrayList<Integer> arr) {
        AvlTree<Integer> avl = new AvlTree<>();

        for (int i = 0; i < arr.size(); i++) {
            avl.add(arr.get(i));
            avl.size++;
        }
        return avl;
    }

    public static void binarySearchTree(BinarySearchTree<Integer> tree, ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            tree.contains(arr.get(i));
        }
    }

    public static void generateData() {
        for (int i = 1; i <= N_TREES; i++) {
            ArrayList<Integer> randomArr = generateRandomArray(i*10);

            removeDuplicates(randomArr);

            AvlTree<Integer> avl = createAvlTree(randomArr);
            binarySearchTree(avl, randomArr);
            System.out.print(avl.size + ",");
            System.out.print(avl.insertCounter + ",");
            System.out.print(avl.searchCounter + ",");

            BinarySearchTree<Integer> bst = createBinarySearchTree(randomArr);
            binarySearchTree(bst, randomArr);

            System.out.print(bst.insertCounter + ",");
            System.out.println(bst.searchCounter);
        }
    }

    public static void generateWorstCase() {

        for (int j = 1; j <= N_TREES; j++)
        {
            AvlTree<Integer> avl = new AvlTree<>();
            BinarySearchTree<Integer> bst = new BinarySearchTree<>();
            int i = 0;
            for (i = 1; i <= j * 10; i++) {
                avl.add(i);
                bst.add(i);
            }
            for (i = 1; i <= j * 10; i++) {
                avl.contains(i);
                bst.contains(i);
            }

            System.out.print(i + ",");
            System.out.print(avl.insertCounter + ",");
            System.out.print(avl.searchCounter + ",");

            System.out.print(bst.insertCounter + ",");
            System.out.println(bst.searchCounter);
        }
    }

    public static void main(String[] args) {
        generateData();
        generateWorstCase();
    }
}