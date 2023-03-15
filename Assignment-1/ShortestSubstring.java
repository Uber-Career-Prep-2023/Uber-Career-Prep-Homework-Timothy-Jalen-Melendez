/**
 * Author: Timothy Jalen Melendez
 * Question 5: ShortestSubstring
 * Given a string and a second string representing required characters, return the length
 * of the shortest substring containing all the required characters.
 * Technique: Growing/Shrinking window
 * Time Complexity: O(n^3)
 * Space Complexity: O(n)
 */
import java.lang.StringBuilder;
import java.util.HashMap;
public class ShortestSubstring {

    public static int shortestSub(String input, String req){
        int shortest = Integer.MAX_VALUE;
        char[] word = new char[req.length()];
        int count = 0;
        for(int i = 0; i < word.length; i++){
            word[i] = req.charAt(i);
        }

        StringBuilder sub = new StringBuilder();
        HashMap<String, Integer> in = new HashMap<String, Integer>();

        for(int j = 0; j < input.length(); ++j){
            for(int k = j; k < input.length(); k++){
                //System.out.println(sub);
                sub.append(input.charAt(k));
                for(int y = 0; y < sub.length() && count < word.length; y++){
                    if(sub.charAt(y) == word[count]){
                        count++;
                    }
                }
                if(count == word.length - 1){
                    //System.out.println(sub.toString()+"<- sub");
                    in.put(sub.toString(), sub.length());
                }
                count = 0;
                
            }
            sub = new StringBuilder();
            
        }
        for(int val : in.values()){
            if(val < shortest){
                shortest = val;
            }
        }
        
        return shortest;
    }
    public static void main(String[] args){
        /*
            Input Strings: "abracadabra", "abc"
            Output: 4
            (Shortest Substring: "brac")

            Input Strings: "zxycbaabcdwxyzzxwdcbxyzabccbazyx", "zzyzx" (Fun fact: "Zzyzx" is a town in the Mojave Desert in California!)
            Output: 10
            (Shortest Substring: "zzxwdcbxyz")

            Input Strings: "dog", "god"
            Output: 3
            (Shortest Substring: "dog")

         */
        System.out.println(shortestSub("abracadabra", "abc"));
        //System.out.println(shortestSub("zxycbaabcdwxyzzxwdcbxyzabccbazyx", "zzyzx"));
        System.out.println(shortestSub("dog", "god"));
     
    }
}
