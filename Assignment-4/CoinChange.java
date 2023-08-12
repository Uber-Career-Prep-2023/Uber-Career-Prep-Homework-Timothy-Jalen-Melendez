/*
 * Question 8: Coin Change
 * Technique: Dynamic Programming Memoization
 * Time Complexity: O(n * sum)
 * Space Complexity: O(n * sum)
 * Time Spent: 36 mins // previous experience
 */
import java.util.Arrays;
public class CoinChange {


    public static int coinChange(int[] coins, int sum, int numCoins, int[][] table ){
        if(sum == 0){
            return table[numCoins][sum] = 1;
        }
        if(numCoins == 0){
            return 0;
        }
        if(table[numCoins][sum] != -1){
            return table[numCoins][sum];
        }
        if(coins[numCoins - 1] <= sum){
            return table[numCoins][sum] = coinChange(coins, sum - coins[numCoins - 1], numCoins, table)  + coinChange(coins, sum, numCoins - 1, table);
        }
        else{
            return table[numCoins][sum] = coinChange(coins, sum, numCoins - 1, table);
        }

    }
    public static void main(String[] args){
        /*
            Given a list of coin denominations and a target sum,
            return the number of possible ways to make change for that sum.

            Examples: Input:
            Coins: [2, 5, 10]
            Sum: 20
            Output: 6 (Options are: 10 2s; 4 5s; 2 10s; 5 2s & 2 5s; 5 2s & 1 10; 2 5s & 1 10)

        */

        int[] coins = {2, 5, 10};
        int sum = 20;
        int[][] table = new int[coins.length + 1][sum + 1];
        for (int[] row : table){
            Arrays.fill(row, -1);
        }
        System.out.println(coinChange(coins, sum, coins.length, table)+"\n~~~~~\n");


        /*
            Sum: 14
            Output: 3 (Options are: 7 2s; 2 5s & 2 2s; 1 10 & 2 2s)

        */
        coins = new int[]{2, 5, 10};
        sum = 15;
        table = new int[coins.length + 1][sum + 1];
        for (int[] row : table){
            Arrays.fill(row, -1);
        }
        System.out.println(coinChange(coins, sum, coins.length, table)+"\n~~~~~\n");
    }
}
