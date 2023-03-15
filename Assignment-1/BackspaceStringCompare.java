/**
 * Author: Timothy Jalen Melendez
 * Question 4: BackspaceStringCompare
 * Given two strings representing series of keystrokes, determine whether the resulting text is the same. 
 * Backspaces are represented by the '#' character so "x#" results in the empty string ("").
 * Technique: Hash the running computation using a stack
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Time: 18 mins
 */
import java.util.Stack;
import java.lang.StringBuilder;
public class BackspaceStringCompare {

    private static String process(String input){
        Stack <Character> stack = new Stack<Character>();
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < input.length(); ++i){
            stack.push(input.charAt(i));
            if(input.charAt(i) == '#'){
                stack.pop();
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            word.append(stack.pop());
        }
        return word.toString();
    }

    public static boolean backString(String a, String b){
        return process(a).equals(process(b));
    }
    public static void main(String[] args){
        /*
            eInput Strings: "abcde", "abcde"
            Output: True

            Input Strings: "Uber Career Prep", "u#Uber Careee#r Prep"
            Output: True

            Input Strings: "abcdef###xyz", "abcw#xyz"
            Output: True

            Input Strings: "abcdef###xyz", "abcdefxyz###"
            Output: False
         */

         System.out.println(backString("abcde","abcde"));
         System.out.println(backString("Uber Career Prep","u#Uber Careee#r Prep"));
         System.out.println(backString("abcdef###xyz","abcw#xyz"));
         System.out.println(backString("abcdef###xyz","abcdefxyz###"));
         System.out.println(backString("",""));





    }
}
