/*
 * Question 7: Largest Squares of 1s
 * Technique: Dynamic Programming / Depth First Search / Tabulation
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 * Time Spent: 40 mins //Used some help to finish
 */
import java.lang.Math;
public class LargestSquareOf1s {

    public static int largestDimension(int[][] matrix){
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, outcome = 0;
        int[][] b = new int[m+1][n+1];
        for(int i = 1 ; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == 1) {
                    b[i][j] = Math.min(Math.min(b[i][j-1] ,
                            b[i-1][j-1]),
                            b[i-1][j]) + 1;
                    outcome = Math.max(b[i][j], outcome);
                }
            }
        }
        return outcome;
    }
    public static void main(String[] args){
        // Input is matrix
        // Output : 2
        int[][] matrix = {
                {0, 1, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 1, 1}
        };
        System.out.println(largestDimension(matrix)+"\n~~~~\n");

        // Input is matrix
        // Output : 3
        matrix = new int[][]{
                {0, 1, 0, 1, 1},
                {0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0}
        };
        System.out.println(largestDimension(matrix)+"\n~~~~\n");

        // Input is matrix
        // Output : 5
        matrix = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(largestDimension(matrix)+"\n~~~~\n");

        // Input is matrix
        // Output : 0
        matrix = new int[][]{{}
        };
        System.out.println(largestDimension(matrix)+"\n~~~~\n");


    }

}
