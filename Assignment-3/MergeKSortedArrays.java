/*
 * Question 9: Given an array of k sorted arrays, merge the k arrays into a single sorted array.
 * Data Structure or Algorithm Used: Mergesort with Priority Queue
 * Time Complexity: O(n log k)
 * Space Complexity: O(n)
 * Time Spent: 40+mins
 */
import java.util.ArrayList;
import java.util.PriorityQueue;
public class MergeKSortedArrays {
    private static class HeapNode
            implements Comparable<HeapNode> { //Used hint to solve by borrowing
        int x, y, value;
        HeapNode(int x, int y, int value)
        {
            this.x = x;
            this.y = y;
            this.value = value;
        }
        @Override public int compareTo(HeapNode hn)
        {
            if (this.value <= hn.value) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }

    public static int[] mergeSort(int k , int[][]listOfArrays){
        if(listOfArrays.length <= 0 || listOfArrays[0].length <= 0){
            return new int[]{};
        }
        ArrayList<Integer> temp = new ArrayList<>();
        PriorityQueue<HeapNode> heap = new PriorityQueue<HeapNode>();

        for (int i = 0; i < listOfArrays.length; i++) {
            heap.add(new HeapNode(i, 0, listOfArrays[i][0]));
        }
        HeapNode current = null;
        while (!heap.isEmpty()) {
            current = heap.poll();
            temp.add(current.value);

            if (current.y < (listOfArrays[current.x].length - 1)) {
                heap.add(new HeapNode(current.x, current.y + 1, listOfArrays[current.x][current.y + 1]));
            }
        }
        int[] sorted = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            sorted[i] = temp.get(i);
        }
        return sorted;
    }
    public static void printArr(int[] array){
        if(array.length <= 0){
            System.out.println("[]");
            return;
        }
        System.out.printf("[");
        int i = 0;
        for(; i < array.length - 1; i++){
            System.out.printf("%d,", array[i]);
        }
        System.out.printf("%d]\n", array[i]);
    }
    public static void main(String[] args){
        /*
        Input: 2, [[1, 2, 3, 4, 5], [1, 3, 5, 7, 9]]
        Output: [1, 1, 2, 3, 3, 4, 5, 5, 7, 9]
        */
        int[][] array = new int[][] {
                {1, 2, 3, 4, 5},
                {1, 3, 5, 7, 9}
        };
        int[] arr = mergeSort(2, array);
        printArr(arr);


        /*
        Input: 3, [[1, 4, 7, 9], [2, 6, 7, 10, 11, 13, 15], [3, 8, 12, 13, 16]]
        Output: [1, 2, 3, 4, 6, 7, 7, 8, 9, 10, 11, 12, 13, 13, 15, 16]
         */

        array = new int[][]{
                {1,4,7,9},
                {2, 6, 7, 10, 11, 13, 15},
                {2,8,12,13,16}
        };
        arr = mergeSort(3, array);
        printArr(arr);

        /*
        Input: 1, [[9, 1, 4 7]]
        Output: [1, 4, 7, 9]
         */

        array = new int[][]{
                {1,4,7,9}
        };
        arr = mergeSort(1, array);
        printArr(arr);

        /*
        Input: 1, [[9]]
        Output: [9]
         */

        array = new int[][]{
                {9}
        };
        arr = mergeSort(1, array);
        printArr(arr);

        /*
        Input: 1, [[]]
        Output: [0]
         */

        array = new int[][]{
                {}
        };
        arr = mergeSort(1, array);
        printArr(arr);



    }
}
