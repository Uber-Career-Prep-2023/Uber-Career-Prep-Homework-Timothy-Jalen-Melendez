/*
 * Question 5: Min Cost stair climbing
 * Technique: Dynamic Programming Tabulation
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Time Spent: 27 mins
 */
import java.lang.Math;
public class MinCostStairClimbing {

    public static int minCost(int[] arr){
        int len = arr.length;
        if(len < 1){
            return -1;
        }else if(len == 1){
            return arr[0];
        }
        int[] dynamic = new int[len];
        for(int i = 0; i < len; i++){
            if (i < 2){
                dynamic[i] = arr[i];
            }
            else {
                dynamic[i] = arr[i] + Math.min(dynamic[i-1], dynamic[i-2]);
            }
        }
        return Math.min(dynamic[len-1], dynamic[len-2]);
    }
    public static void main(String[] args){
        /*
        Examples:
        Input: [4, 1, 6, 3, 5, 8]
        Output: 9 (step on stairs 1, 3, 4 for a cost of 1+3+5)
        */
        int[] array = {4, 1, 6, 3, 5, 8};
        System.out.println(minCost(array) + "\n~~~~~\n");


        /*
        Input: [11, 8, 3, 4, 9, 13, 10]
        Output: 25 (step on stairs 1, 3, 5 for a cost of 8+4+13)
         */
        array = new int[]{11, 8, 3, 4, 9, 13, 10};
        System.out.println(minCost(array) + "\n~~~~~\n");

        /*
        Input: [0]
        Output: 0 (step on stairs 1, 3, 5 for a cost of 8+4+13)
         */
        array = new int[]{0};
        System.out.println(minCost(array) + "\n~~~~~\n");

        /*
        Input: []
        Output: -1 (step on stairs 1, 3, 5 for a cost of 8+4+13)
         */
        array = new int[]{};
        System.out.println(minCost(array) + "\n~~~~~\n");
    }
}
