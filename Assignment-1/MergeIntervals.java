/**
 * Author: Timothy Jalen Melendez
 * Question 8: MergeIntervals
 * Given a list of integer pairs representing the low and high end of an interval,
 * inclusive, return a list in which overlapping intervals are merged
 * Time Complexity: 
 * Space Complexity: 
 * Time: 40 mins(Unfinshed)
 */
import java.util.ArrayList;
public class MergeIntervals {

    public static ArrayList<String> merge(ArrayList<String> in){
        ArrayList<String> list = new ArrayList<>();


        return list;
    }
    public static void main(String[] args){
        /*
        Input: [(2, 3), (4, 8), (1, 2), (5, 7), (9, 12)]
        Output: [(4, 8), (1, 3), (9, 12)]

        Input: [(5, 8), (6, 10), (2, 4), (3, 6)]
        Output: [(2, 10)]

        Input: [(10, 12), (5, 6), (7, 9), (1, 3)]
        Output: [(10, 12), (5, 6), (7, 9), (1, 3)]
         */
        ArrayList <String> lst = new ArrayList<>();
        lst.add("(2, 3)");
        System.out.println(merge(lst));
         
    }
}