/**
 * Author: Timothy Jalen Melendez
 * Question: MaxMeanSubarray
 * Given an array of integers and an integer, k, find the maximum mean of a subarray of size k.
 * Technique: This is a one of the Two Pointer techniques, more specifically
 * it is Fixed-size sliding window.
 * Time Complexity:
 * Space Complexity:
 */
public class MaxMeanSubarray {

    public static double MaxMean(int k, int[] array){
        int leftIdx = 0, rightIdx = k - 1;
        int curr = 0, max = Integer.MIN_VALUE;
        if(k > array.length){
            return -1;
        } else if (k <= 0) {
            return -1;
        }
        for(; rightIdx < array.length; leftIdx++, rightIdx++){
            for(int i = 0; i < k ; i++){
                curr = curr + array[leftIdx + i];
            }
            if(curr > max){
                max = curr;
            }
            curr = 0;
        }

        return (double) max / k;
    }

    public static void main(String[] args){
        /*
        Input k = 2
        Output: 4.5
        */
        int k = 2;
        int arr[] = {4, 5, -3, 2, 6, 1};
        System.out.println("Test Case 1 Output : "+MaxMean(k, arr));
        /*
        Input k = 3
        Output: 3
        */
        k = 3;
        arr = new int[]{4, 5, -3, 2, 6, 1};
        System.out.println("Test Case 2 Output : "+MaxMean(k, arr));

        /*
        Input k = 3
        Output: 1
         */
        k = 3;
        arr = new int[]{1, 1, 1, 1, -1, -1, 2, -1, -1};
        System.out.println("Test Case 3 Output : "+MaxMean(k, arr));

        /*
        Input k = 5
        Output: 1
         */
        k = 5;
        arr = new int[]{1, 1, 1, 1, -1, -1, 2, -1, -1, 6};
        System.out.println("Test Case 4 Output : "+MaxMean(k, arr));




    }
}
