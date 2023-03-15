/**
 * Author: Timothy Jalen Melendez
 * Question 3: ZeroSumSubArrays
 * Given an array of integers, count the number of subarrays that sum to zero.
 * Technique: This is a one of the Two Pointer techniques, more specifically
 * two pointer catch up
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * Time: 28 mins
 */

public class ZeroSumSubArrays {

    public static int zeroSum(int[] array){
        int count = 0, sum = 0;
        for(int j = 0; j < array.length; ++j){
            sum += array[j];
            if(sum == 0){
                count++;
            }
            for(int k = j+1; k < array.length; ++k){
                sum += array[k];
                if(sum == 0){
                    count++;
                }
            }
            sum = 0;
            
        }
        return count;
    }

    public static void main(String[] args){
        /*
        Input Array: [4, 5, 2, -1, -3, -3, 4, 6, -7]
        Output: 2
        (Subarrays: [5, 2, -1, -3, -3], [-3, 4, 6, -7])

        Input Array: [1, 8, 7, 3, 11, 9]
        Output: 0

        Input Array: [8, -5, 0, -2, 3, -4]
        Output: 2
        (Subarrays: [0], [8, -5, 0, -2, 3, -4])

        */
        int[] arr = {4, 5, 2, -1, -3, -3, 4, 6, -7};
        System.out.println(zeroSum(arr));

        arr = new int[]{1, 8, 7, 3, 11, 9};
        System.out.println(zeroSum(arr));

        arr = new int[]{8, -5, 0, -2, 3, -4};
        System.out.println(zeroSum(arr));

        arr = new int[]{0};
        System.out.println(zeroSum(arr));


    }
}
