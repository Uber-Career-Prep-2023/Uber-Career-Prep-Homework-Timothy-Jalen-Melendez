/*
 * Question 3: Priority Queue
 */
import java.util.HashMap;
public class PriorityQueue {
    static class Pair {
        HashMap<String, Integer> map;
        public Pair(String a, int b){
            map.put(a, b);
        }
    }
    private Pair[] arr; // the underlying array

    public int top(){ // returns the highest priority (first) element in the PQ
        return 0;
    }
    public void insert(String x, int weight) { // adds string x to the PQ with priority weight

    }
    public void remove() { // removes the highest priority (first) element in the PQ

    }

}
