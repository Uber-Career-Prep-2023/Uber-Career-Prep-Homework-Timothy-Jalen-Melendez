/*
 * Question 5: Given a number, k, return an array of the first k binary numbers, represented as strings.
 * Name: Timothy J. Melendez
 * Data Structure or Algorithm Used: ArrayList
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Time Spent: 32
 */
import java.util.ArrayList;
public class FirstKBinaryNumbers {

    private static String[] array;

    public static String[] firstKBinaryNum(int k){
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            list.add(Integer.toBinaryString(i));
        }

        array = list.toArray(new String[list.size()]);
        return array;
    }
    public static void main(String[] args){
        /*
        Input: 5
        Output: ["0", "1", "10", "11", "100"]
        */
        firstKBinaryNum(5);
        for(int i = 0; i < 5; i++){
            System.out.printf("%s ", array[i]);
        }
        System.out.printf("\n");

        /*
        Input: 10
        Output: ["0", "1", "10", "11", "100", "101", "110", "111", "1000", "1001"]
         */
        firstKBinaryNum(10);
        for(int i = 0; i < 10; i++){
            System.out.printf("%s ", array[i]);
        }
        System.out.printf("\n");

        /*
        Input: 15
        Output: ["0", "1", "10", "11", "100", "101", "110", "111", "1000", "1001", "1010", "1011", "1100", "1101", "1110"]
         */
        firstKBinaryNum(15);
        for(int i = 0; i < 15; i++){
            System.out.printf("%s ", array[i]);
        }
        System.out.printf("\n");

        /*
        Input: 1
        Output: ["0"]
         */
        firstKBinaryNum(1);
        for(int i = 0; i < 1; i++){
            System.out.printf("%s ", array[i]);
        }
        System.out.printf("\n");

        /*
        Input: 0
        Output: []
         */
        firstKBinaryNum(0);
        for(int i = 0; i < 0; i++){
            System.out.printf("%s ", array[i]);
        }
        System.out.printf("\n");

        /*
        Input: -5
        Output: []
         */
        firstKBinaryNum(0);
        for(int i = 0; i < -5; i++){
            System.out.printf("%s ", array[i]);
        }
        System.out.printf("\n");
    }
}