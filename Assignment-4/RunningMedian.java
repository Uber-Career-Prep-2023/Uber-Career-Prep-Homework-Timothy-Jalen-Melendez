/*
 * Question 3: Running Median
 * Technique: Maintain Two Heaps / Priority Queue
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 * Time Spent: 32 mins
 */

import java.util.PriorityQueue;
public class RunningMedian {


    public static void runningMedian(int[] array){

        PriorityQueue<Double> minHeapOne = new PriorityQueue<>(), minHeapTwo = new PriorityQueue<>();

        for (int i = 0; i < array.length; i++) {
            minHeapTwo.add(-1.0 * array[i]);
            minHeapOne.add(-1.0 * minHeapTwo.poll());

            if (minHeapOne.size() > minHeapTwo.size()){
                minHeapTwo.add(-1.0 * minHeapOne.poll());
            }
            System.out.println("~~~~~~~~~~~~~");
            if (minHeapOne.size() != minHeapTwo.size()){
                System.out.println(-1.0 * minHeapTwo.peek());
            }
            else{
                System.out.println((minHeapOne.peek() - minHeapTwo.peek()) / 2);
            }

        }
    }
    public static void main(String[]args){
        /*
            You will be given a stream of numbers, one by one.
            After each new number, return the median of the numbers so far.
            Examples (newest number at each step in bold): Input: 1
            Output: 1
            Input: 1, 11 Output: 6
            Input: 1, 11, 4 Output: 4
            Input: 1, 11, 4, 15 Output: 7.5
            Input: 1, 11, 4, 15, 12 Output: 11
         */
        int[] arr = {1, 11, 4, 15, 12};
        runningMedian(arr);

        /*
        Input = 0
        Output = 0
         */
        arr = new int[1];
        runningMedian(arr);

        /*
         Input: 3
         Output: 3
         Input: 3, 5
         Output: 4
         Input: 3, 5, 6
         Output: 5
         Input: 3, 5, 6, 100
         Output: 5.5
         */

        int [] arry = {3, 5, 6, 100};
        runningMedian(arry);

    }
}
