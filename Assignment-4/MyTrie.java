/*
 * Question 1: Trie
 */
public class MyTrie {

    static TrieNode root;
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean validWord;
        public TrieNode(){
            validWord = false;
        }
    }

    /*
    This method has an O(n) insertion time and a O(n*m) space complexity where m is number of nodes
    */
    public static void insert(String word){ // adds a word to the trie
        int level = 0, idx,  len = word.length();
        TrieNode traversalNode = root;
        char baseChar = 'a';
        for(; level < len; level++){
            idx = word.charAt(level) - baseChar;
            if(traversalNode.children[idx] == null){
                traversalNode.children[idx] = new TrieNode();
            }

            traversalNode = traversalNode.children[idx];
        }
        traversalNode.validWord = true;
    }

    /*
    This method has an O(n) search time and a O(1) space complexity
    */
    public static boolean isValidWord(String word){ // returns a boolean indicating whether word is in the trie
        int level = 0, idx,  len = word.length();
        TrieNode traversalNode = root;
        char baseChar = 'a';
        for(level = 0; level < len; level++){
            idx = word.charAt(level) - baseChar;

            if (traversalNode.children[idx] == null)
                return false;

            traversalNode = traversalNode.children[idx];
        }

        return (traversalNode.validWord);

    }

    /*
    This method has an O(n) deletion time and a O(n*m) space complexity
    */
    public static TrieNode removeHelper(TrieNode node, String word, int level){

        if(node == null){
            return null;
        }

        if(level == word.length()) {

            if (node.validWord){
                node.validWord = false;
            }

            boolean alone = true;
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null){
                    alone = false;
                }
            }
            if (alone) {
                node = null;
            }
            return root;
        }

        int idx = word.charAt(level) - 'a';
        node.children[idx] = removeHelper(node.children[idx], word, level + 1);
        boolean alone = true;
        for(int i = 0; i < 26; i++){
            if(node.children[i] != null){
                alone = false;
            }
        }

        if (alone && node.validWord == false){
            node = null;
        }
        return node;
    }

    /*
   This method has an O(n) deletion time and a O(n*m) space complexity
   */
    public static void remove(String word){  // removes word, from the trie & deletes unused nodes
        removeHelper(root, word, 0);
    }



    public static void main(String args[]){
        root = new TrieNode();
        insert("hello");
        //input should output true
        System.out.println(isValidWord("hello"));

        //input should output false
        System.out.println(isValidWord("world"));

        insert("world");
        insert("would");

        //input should output true
        System.out.println(isValidWord("world"));

        remove("would");
        //input should output false
        System.out.println(isValidWord("would"));

        remove("hello");
        remove("world");
        //input should output false and false
        System.out.println(isValidWord("world"));
        System.out.println(isValidWord("hello"));


    }
}