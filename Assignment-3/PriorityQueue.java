/*
 * Question 3: Priority Queue
 */
import java.util.ArrayList;

public class PriorityQueue {

    ArrayList<Pair> array, heap;
    static class Pair {
        public int weight;
        public String tsk;

        public Pair(String a, int b){
            this.tsk = a;
            this.weight = b;
        }
    }
    public PriorityQueue(){
        array = new ArrayList<>();
        heap = new ArrayList<>();
    }


    public int top(){ // returns the highest priority (first) element in the PQ
        if(heap.size() < 1){
            return -1;
        }
        Pair maxPair = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int index = 0;

        while (index < heap.size()) {
            int leftId = index * 2 + 1;
            int rightId = index * 2 + 2;
            int iD = leftId;
            if (rightId < heap.size() && heap.get(rightId).weight > heap.get(leftId).weight) {
                iD = rightId;
            }

            if (iD < heap.size() && heap.get(iD).weight > heap.get(index).weight) {
                Pair temp = heap.get(iD);
                heap.set(iD, heap.get(index));
                heap.set(iD, temp);
                index = iD;
            } else {
                break;
            }
        }
        return maxPair.weight;
    }
    public void insert(String x, int weight) { // adds string x to the PQ with priority weight
        heap.add(new Pair(x, weight));
        int index = heap.size() - 1;
        while(index != 0){
            int parentIndex = (index -1) /2;
            if(heap.get(parentIndex).weight < heap.get(index).weight){
                Pair temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(index));
                heap.set(parentIndex, temp);
                index = parentIndex;
            }
            else{
                break;
            }
        }
    }
    public void remove() { // removes the highest priority (first) element in the PQ
        if(heap.size() < 1){
            return;
        }
        Pair maxPair = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int index = 0;

        while (index < heap.size()) {
            int leftId = index * 2 + 1;
            int rightId = index * 2 + 2;
            int iD = leftId;
            if (rightId < heap.size() && heap.get(rightId).weight > heap.get(leftId).weight) {
                iD = rightId;
            }

            if (iD < heap.size() && heap.get(iD).weight > heap.get(index).weight) {
                Pair temp = heap.get(iD);
                heap.set(iD, heap.get(index));
                heap.set(iD, temp);
                index = iD;
            } else {
                break;
            }
        }
        heap.remove(maxPair);
    }

    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue();
        pq.insert("first", 10);
        pq.insert("third", 2);
        pq.insert("second", 5);
        pq.insert("fourth", 1);
        //Expected : 10
        System.out.println(pq.top());

        pq.remove();
        //Expected : 5
        System.out.println(pq.top());

        pq.remove();
        pq.remove();

        //Expected : -1
        System.out.println(pq.top());

        //insert time : O(1), top: O(n), remove: O(n)
        //space: O(n)




    }
}
