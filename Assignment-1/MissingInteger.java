/**
 * Author: Timothy Jalen Melendez
 * Question 6: MissingInteger
 * Given an integer n and a sorted array of integers of size n-1 which contains
 * all but one of the integers in the range 1-n, find the missing integer.
 * Technique: Hash the running computation
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MissingInteger {

    public static int missing(int[] array, int n){
        for(int i = array.length - 1; i >= 0; i--, n--){
            if(array[i] - n != 0){
                return array[i] + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        /*
            Input Array: [1, 2, 3, 4, 6, 7]
            Input n: 7
            Output: 5

            Input Array: [1]
            Input n: 2
            Output: 2

            Input Array: [1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12]
            Input n: 12
            Output: 9

         */
        int[] arr = {1, 2, 3, 4, 6, 7};
        int n = 7;
        System.out.println(missing(arr, n));

        arr = new int []{1};
        n = 2;
        System.out.println(missing(arr, n));

        arr = new int []{1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12};
        n = 12;
        System.out.println(missing(arr, n));
    }
}