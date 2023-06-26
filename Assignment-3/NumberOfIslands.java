/*
 * Question 4: Given a binary matrix in which 1s represent land and 0s represent water. Return the number of islands
 * Name: Timothy J. Melendez
 * Data Structure or Algorithm Used: Depth First Search
 * Time Complexity: O(V +E)
 * Space Complexity: O(V)
 * Time Spent: 39 mins
 */
public class NumberOfIslands {



    public static int numberOfIslands(int [][] matrix){
        int rows = matrix.length, cols = matrix[0].length, islands = 0;
        for(int i = 0; i < rows; i++){
            for(int k = 0; k < cols; k++)
                if(matrix[i][k] == 1){
                    search(matrix, i , k);
                    islands++;
            }
        }
        return islands;
    }
    private static void search(int[][] matrix, int i, int k){
        int rows = matrix.length, cols = matrix[0].length;
        if(i < 0 || k < 0){
            return;
        }
        if(i >= rows || k >= cols || matrix[i][k] == 0){
            return;
        }
        else{
            matrix[i][k] = 0;
            search(matrix, i + 1, k);
            search(matrix, i, k + 1);
            search(matrix, i - 1, k);
            search(matrix, i, k - 1);
        }

    }


    public static void main(String[] args){
        int[][] grid = new int[][] {
                {1, 0, 1, 1, 1},
                {1 ,1, 0, 1, 1},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        //Expected output islands = 3
        System.out.println(numberOfIslands(grid));

        grid = new int[][] {
                {1, 0, 0},
                {0, 0, 0}
        };

        //Expected output islands = 1
        System.out.println(numberOfIslands(grid));

        grid = new int[][] {
                {0, 0, 0},
                {0, 0, 0}
        };

        //Expected output islands = 0
        System.out.println(numberOfIslands(grid));

        grid = new int[][] {
                {1, 0, 0},
                {0, 0, 0},
                {1, 1, 1}
        };

        //Expected output islands = 2
        System.out.println(numberOfIslands(grid));

    }
}
