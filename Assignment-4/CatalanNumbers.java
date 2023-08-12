/*
 * Question 4: Catalan Numbers
 * Technique: Dynamic Programming Tabulation
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * Time Spent: 29 mins
 */
public class CatalanNumbers {


    public static int[] catalanNum(int n){
        int cat[] = new int[n + 2];
        cat[0] = 1;
        cat[1] = 1;
        int i = 2;
        for (; i <= n; i++) {
            cat[i] = 0;
            for (int j = 0; j < i; j++) {
                cat[i] += cat[j] * cat[i - j - 1];
            }
        }
        return cat;
    }

    public static void main(String[] args){
        /*
        Examples: Input: 1
        Output: 1, 1
        */
        int[] arr = catalanNum(1);
        for(int i = 0; i < arr.length - 1; i++){
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n~~~~~~~\n");


        /*
        Input: 5
        Output: 1, 1, 2, 5, 14, 42
         */
        arr = catalanNum(5);
        for(int i = 0; i < arr.length - 1; i++){
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n~~~~~~~\n");


        /*
        Input: 10
        Output: 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796
         */
        arr = catalanNum(10);
        for(int i = 0; i < arr.length - 1; i++){
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n~~~~~~~\n");

        /*
        Input: 0
        Output: 1
         */
        arr = catalanNum(0);
        for(int i = 0; i < arr.length - 1; i++){
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n~~~~~~~\n");

    }
}
