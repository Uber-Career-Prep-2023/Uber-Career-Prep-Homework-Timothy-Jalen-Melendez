/**
 * Author: Timothy Jalen Melendez
 * Question 9: DedupArray
 * Given a sorted array of non-negative integers, modify the array by removing duplicates 
 * so each element only appears once. If arrays are static (aka, not dynamic/resizable) 
 * in your language of choice, the remaining elements should appear in the left-hand side 
 * of the array and the extra space in the right-hand side should be padded with -1s.
 * Technique: Hash the elements
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Time: 31 mins
 */
import java.util.HashMap;
import java.lang.StringBuilder;
public class DedupArray {

    public static int[] dedup(int[] array){
        HashMap <Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int j = 0; j < array.length; ++j){
            if(!map.containsKey(array[j])){
                map.put(array[j], 1);
            }
        }
        int w = 0;
        int[] modded = new int[array.length];
        for(int key : map.keySet()){
            modded[w++] = key;
        }
        for(; w < modded.length;++w){
            modded[w] = -1;
        }
        return modded;
    }
    public static void main(String[] args){
        /*
        Input Array: [1, 2, 2, 3, 3, 3, 4, 4, 4, 4]
        Modified Array: [1, 2, 3, 4] 
        or [1, 2, 3, 4, -1, -1, -1, -1, -1, -1] (depending on language)

        Input Array: [0, 0, 1, 4, 5, 5, 5, 8, 9, 9, 10, 11, 15, 15]
        Modified Array: [0, 1, 4, 5, 8, 9, 10, 11, 15]
        or [0, 1, 4, 5, 8, 9, 10, 11, 15, -1, -1, -1, -1, -1] (depending on language)

        Input Array: [1, 3, 4, 8, 10, 12]
        Modified Array: [1, 3, 4, 8, 10, 12]
         */
        int [] arr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4}, soln = dedup(arr);
        StringBuilder lst = new StringBuilder();
        lst.append("[");
        for(int k = 0; k < arr.length; ++k){
            lst.append(soln[k]+", ");
        }
        lst.delete(lst.length()-2, lst.length()-1);
        lst.append("]");
        System.out.println(lst);
        lst = new StringBuilder();
        

        arr = new int []{0, 0, 1, 4, 5, 5, 5, 8, 9, 9, 10, 11, 15, 15};
        soln = dedup(arr);
        lst.append("[");
        for(int k = 0; k < arr.length; ++k){
            lst.append(soln[k]+", ");
        }
        lst.delete(lst.length()-2, lst.length()-1);
        lst.append("]");
        System.out.println(lst);
        lst = new StringBuilder();

        arr = new int []{1, 3, 4, 8, 10, 12};
        soln = dedup(arr);
        lst.append("[");
        for(int k = 0; k < arr.length; ++k){
            lst.append(soln[k]+", ");
        }
        lst.delete(lst.length()-2, lst.length()-1);
        lst.append("]");
        System.out.println(lst);
        lst = new StringBuilder();
    }
}