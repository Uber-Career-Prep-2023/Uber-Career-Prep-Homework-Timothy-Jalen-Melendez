/**
 * Author: Timothy Jalen Melendez
 * Question 7: KAnagrams
 * Two strings are considered to be “k-anagrams" if they can be made into anagrams by
 * changing at most k characters in one of the strings. 
 * Given two strings and an integer k, determine if they are k-anagrams.
 * Technique: Increments/Decrements count
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
import java.util.HashMap;
public class KAnagrams {

    public static boolean kAnagrams(int k, String a, String b){
        HashMap <Character, Integer> map = new HashMap<Character, Integer>();
        int differences = 0;
        if(a.length() != b.length()){
            return false;
        }
        for(int i = 0; i < a.length(); ++i){
            if(!map.containsKey(a.charAt(i))){
                map.put(a.charAt(i), 1);
            }
            else{
                int val = map.get(a.charAt(i));
                map.put(a.charAt(i), val+1);
            }
        }
        for(int e = 0; e < b.length(); ++e){
            if(!map.containsKey(b.charAt(e))){
                continue;
            }
            else{
                int val = map.get(b.charAt(e));
                map.put(b.charAt(e), val-1);
            }
        }
        for(char val : map.keySet()){
            if(map.get(val) > 0){
                differences++;
            }
        }
        return differences <= k;
    }
    public static void main(String[] args){
        /*
            Input Strings: "apple", "peach"
            Input k: 1
            Output: False

            Input Strings: "apple", "peach"
            Input k: 2
            Output: True

            Input Strings: "cat", "dog"
            Input k: 3
            Output: True

            Input Strings: "debit curd", "bad credit"
            Input k: 1
            Output: True

            Input Strings: "baseball", "basketball"
            Input k: 2
            Output: False

         */
        int k = 1;
        System.out.println(kAnagrams(k, "apple", "peach" ));
        k = 2;
        System.out.println(kAnagrams(k, "apple", "peach" ));
        k = 3;
        System.out.println(kAnagrams(k, "cat", "dog" ));
        k = 1;
        System.out.println(kAnagrams(k, "debit curd", "bad credit" ));
        k = 2;
        System.out.println(kAnagrams(k, "baseball", "basketball" ));

         
    }
}