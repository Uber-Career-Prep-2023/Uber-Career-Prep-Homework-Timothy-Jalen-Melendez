/**
 * Author: Timothy Jalen Melendez
 * Question 10: TwoSum
 * Given an array of integers and a target integer, k, return the number of pairs of
 * integers in the array that sum to k. In each pair, the two items
 * must be distinct elements (come from different indices in the array).
 * Technique: Simultaneous two pointer
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */

 public class TwoSum {

    public static int tSum(int k, int[] arr){
        int pairs = 0;
        for(int i = 0; i < arr.length; ++i){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == k){
                    pairs++;
                }
            }
        }

        return pairs;
    }
    public static void main(String[] args){
        /*
            Input Array: [1, 10, 8, 3, 2, 5, 7, 2, -2, -1]
            Input k: 10
            Output: 3
            (Pairs: (8, 2), (8, 2), (3, 7))
            
            Input Array: [1, 10, 8, 3, 2, 5, 7, 2, -2, -1]
            Input k: 9
            Output: 4
            (Pairs: (10, -1), (1, 8), (2, 7), (2, 7))

            Input Array: [4, 3, 3, 5, 7, 0, 2, 3, 8, 6]
            Input k: 6
            Output: 5
            (Pairs: (4, 2), (0, 6), (3, 3), (3, 3), (3, 3))

            Input Array: [4, 3, 3, 5, 7, 0, 2, 3, 8, 6]
            Input k: 1
            Output: 0

         */
        int k = 10;
        int [] arr = {1, 10, 8, 3, 2, 5, 7, 2, -2, -1};
        System.out.println(tSum(k,arr));

        k = 9;
        arr = new int[]{1, 10, 8, 3, 2, 5, 7, 2, -2, -1};
        System.out.println(tSum(k,arr));

        k = 6;
        arr = new int[]{4, 3, 3, 5, 7, 0, 2, 3, 8, 6};
        System.out.println(tSum(k,arr));

        k = 1;
        arr = new int[]{4, 3, 3, 5, 7, 0, 2, 3, 8, 6};
        System.out.println(tSum(k,arr));





    }
}
