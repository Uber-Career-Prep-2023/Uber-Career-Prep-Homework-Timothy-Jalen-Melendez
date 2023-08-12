/*
 * Question 2: Boggle
 * Technique: Trie / Depth First Search
 * Time Complexity: O(N*W + R*C^2) R = Row , C = Column
 * Space Complexity: O(N*W + R*C)
 * Time Spent: 38 mins
 */
import java.util.HashSet;
import java.util.Set;

public class Boggle {
    public static String[] dictionary = { "ACE", "GAPE", "MACE", "APE", "GRAPE", "MAP", "CAPE", "LACE",
            "MAY", "CLAP", "LAY", "PAY", "RAP", "TAPE", "TRAY", "RAY", "TRACE", "YAP", "TAP", "TRAP" };


    public static boolean dfs(char[][] board, String word, int i , int j, int k, int m, int index){
        if (i < 0 || i >= k || j < 0 || j >= m) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '+';

        boolean a = dfs(board, word, i, j + 1, k, m, index + 1), b = dfs(board, word, i, j - 1, k, m, index + 1),
                c = dfs(board, word, i + 1, j, k, m, index + 1), d = dfs(board, word, i - 1, j, k, m, index + 1),
                e = dfs(board, word, i + 1, j + 1, k, m, index + 1), f = dfs(board, word, i - 1, j + 1, k, m, index + 1),
                g = dfs(board, word, i + 1, j - 1, k, m, index + 1),h = dfs(board, word, i - 1, j - 1, k, m, index + 1);
        board[i][j] = temp;
        return a || b || c || e || f || g || h || d;
    }
    public static Set<String> boggleValidWords(char[][] board){
        int n = board.length, m = board[0].length;
        Set<String> answer = new HashSet<>(), list = new HashSet<>();
        for (String word : dictionary) {
            int l = word.length();
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < m; k++) {
                    if (dfs(board, word, i, k, n, m, 0)) {
                        list.add(word);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args){

        /*
            Dictionary:
            Ace Gape Mace Ape Grape Map Cape Lace May Clap Lap Pace Clay Lay Pay
            Rap Tape Tray Ray Trace Yap Tap Trap

            Board:[ [A, D, E],
                    [R, C, P],
                    [L, A, Y] ]
            Ouput:
            Ace Lay Clap Race Clay Ape Pace Ray Cape Lace Lap Yap Pay Rap
         */

        char[][] board = {
                            {'A', 'D', 'E'},
                            {'R', 'C', 'P'},
                            {'L', 'A', 'Y'}
                        };

        Set<String> list = boggleValidWords(board);
        for(String word : list){
            System.out.println(word);
        }

        System.out.println("~~~~~~~~~");
        /*
            Dictionary:
            Ace Gape Mace Ape Grape Map Cape Lace May Clap Lap Pace Clay Lay Pay
            Rap Tape Tray Ray Trace Yap Tap Trap

            Board:[ [A, A, A],
                    [A, A, P],
                    [A, A, E] ]
            Ouput:
            APE
         */

        char[][] boardTwo = {
                {'A', 'A', 'A'},
                {'A', 'A', 'P'},
                {'A', 'A', 'E'}
        };

        Set<String> listTwo = boggleValidWords(boardTwo);
        for(String word : listTwo){
            System.out.println(word);
        }

        System.out.println("~~~~~~~~~");
        /*
            Dictionary:
            Ace Gape Mace Ape Grape Map Cape Lace May Clap Lap Pace Clay Lay Pay
            Rap Tape Tray Ray Trace Yap Tap Trap

            Board:[[]]
            Ouput:
            None
         */

        char[][] boardThree = {{}
        };

        Set<String> listThree = boggleValidWords(boardThree);
        for(String word : listThree){
            System.out.println(word);
        }


    }
}
