/*
 * Question 7: Given a string, return the string with the order of the space-separated words reversed
 * Name: Timothy J. Melendez
 * Data Structure or Algorithm Used: Stack problem
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Time Spent: 24 mins
 */
import java.util.Stack;
import java.lang.StringBuilder;
public class ReverseWords {

    public static String reverseWords(String s){
        if(s.length() <= 1){
            return s;
        }
        String[] split = s.split(" ");
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for(String word: split){
            stack.push(word);
        }
        while(!stack.isEmpty()){
            builder.append(stack.pop());
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length()-1);
        String reverse = builder.toString();
        return reverse;
    }
    public static void main(String[] args){
        /*
        Input: "Uber Career Prep"
        Output: "Prep Career Uber"
        */
        System.out.println("Uber Career Prep");
        System.out.println(reverseWords("Uber Career Prep"));

        /*
        Input: "Emma lives in Brooklyn, New York."
        Output: "York. New Brooklyn, in lives Emma"
        */
        System.out.println("Emma lives in Brooklyn, New York.");
        System.out.println(reverseWords("Emma lives in Brooklyn, New York."));

        /*
        Input: "this is a test string"
        Output: "string test a is this"
         */
        System.out.println("this is a test string");
        System.out.println(reverseWords("this is a test string"));


        /*
        Input: "test"
        Output: "test"
         */
        System.out.println("test");
        System.out.println(reverseWords("test"));

        /*
        Input: "t"
        Output: "t"
        */
        System.out.println("t");
        System.out.println(reverseWords("t"));

        /*
        Input: " "
        Output: " "
        */
        System.out.println(" ");
        System.out.println(reverseWords(" "));

        /*
        Input: ""
        Output: ""
        */
        System.out.println("");
        System.out.println(reverseWords(""));
    }

}