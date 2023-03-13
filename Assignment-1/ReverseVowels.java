/**
 * Author: Timothy Jalen Melendez
 * Question: ReverseVowels
 * Given a string, reverse the order of the vowels in the string.
 * Technique:
 * it is Fixed-size sliding window.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ReverseVowels {

    private char[] vowels = {'a','A','e','E','i','I','o','O','u','U'};
    public static String reverse(String s){
        String temp = "";
        return temp;
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




    }
}
