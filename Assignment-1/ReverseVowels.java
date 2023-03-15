/**
 * Author: Timothy Jalen Melendez
 * Question 2: ReverseVowels
 * Given a string, reverse the order of the vowels in the string.
 * Technique: Hash the elements
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Time: 25 mins
 */
import java.lang.StringBuilder;
import java.util.HashSet;
import java.util.Stack;
public class ReverseVowels {

    public static String reverse(String s){
        StringBuilder word = new StringBuilder();
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        Stack<Character> tracker = new Stack<Character>();
        for(int i = 0; i < s.length(); ++i){
            if(set.contains(s.charAt(i))){
                tracker.push(s.charAt(i));
            }
        }
        for(int k = 0; k < s.length(); ++k){
            if(set.contains(s.charAt(k))){
                word.append(tracker.pop());
            }
            else{
                word.append(s.charAt(k));
            }
        }
        return word.toString();
    }

    public static void main(String[] args){
        /*
        Input String: "Uber Career Prep"
        Modified String: "eber Ceraer PrUp"

        Input String: "xyz"
        Modified String: "xyz"

        Input String: "flamingo"
        Modified String: "flominga"
        */
        System.out.println(reverse("Uber Career Prep"));
        System.out.println(reverse("xyz"));
        System.out.println(reverse("flamingo"));
        System.out.println(reverse(""));



    }
}
