/*
 * Question 6: Word Break
 * Technique: Dynamic Programming Tabulation
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * Time Spent: 32 mins
 */
import java.util.HashSet;
import java.util.Set;
import java.lang.String;
public class WordBreak {
    public static String[] dictionary = {"elf", "manatee", "quip", "go", "not", "tee", "golf", "note", "teen", "man", "pig"};
    public static Set<String> set = new HashSet<>();

    public static void initialize(){
        for(String word: dictionary){
            set.add(word);
        }
    }

    public static boolean wordBreak(String word){
        if(word.length() < 1){
            return false;
        }
        boolean[] dynamic = new boolean[word.length() + 1];
        dynamic[0] = true;
        for(int i = 1; i <= word.length(); i++) {
            for(int j = i - 1; j >= 0; j--) {
                dynamic[i] = dynamic[j] && set.contains(word.substring(j, i));
                if(dynamic[i]){
                    break;
                }
            }
        }
        return dynamic[word.length()];
    }
    public static void main(String[] args){
        initialize();

        /*
            Input: mangolf
            Output: True (“man”, “golf”)
        */
        System.out.println(wordBreak("mangolf")+"\n~~~~~~\n");


        /*
            Input: manateenotelf
            Output: True (“manatee”, “not”, “elf”)
        */
        System.out.println(wordBreak("manateenotelf")+"\n~~~~~~\n");


        /*
            Input: quipig
            Output: False
         */
        System.out.println(wordBreak("quipig")+"\n~~~~~~\n");


        /*
            Input: dog
            Output: False
         */
        System.out.println(wordBreak("dog")+"\n~~~~~~\n");

        /*
            Input: ""
            Output: False
         */
        System.out.println(wordBreak("")+"\n~~~~~~\n");

    }
}
