/**
 * Used to match key with frequency in BaseHeap
 */
public class Pair implements Comparable<Pair> {
    String key;
    int value;

    public Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "(" + key + "," + value + ")";
    }

    @Override
    public int compareTo(Pair a) {
        return this.value - a.value;
    }
}
