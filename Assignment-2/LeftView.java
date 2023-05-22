/*
    Timothy J. Melendez
    Technique: Level-order traversal
    Time Complexity: O(n)
    Space Complexity: O(h), h being height
    Time Spent: 34 mins
 */
import java.util.ArrayList;
public class LeftView {

    static int maxLevel = 0;
    public static void leftViewHelper(MyBinarySearchTree.MyNode root, ArrayList<Integer> lst, int level){
        if(root == null){
            return;
        }
        if(level > maxLevel){
            lst.add(root.element);
            maxLevel = level;
        }
        leftViewHelper(root.left, lst, level + 1);
        leftViewHelper(root.right, lst, level +1);

    }

    public static int[] leftView(MyBinarySearchTree bst){
        ArrayList<Integer> lst = new ArrayList<>();

        leftViewHelper(bst.root, lst, maxLevel);
        int[] array = new int[lst.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = lst.get(i);
        }
        return array;
    }


    public static void main(String[] args){
        MyBinarySearchTree bst = new MyBinarySearchTree();
        bst.insert(10);
        bst.insert(9);
        bst.insert(15);
        bst.insert(12);
        bst.insert(17);
        bst.insert(18);
        bst.insert(11);
        bst.insert(13);
        bst.insert(14);

        int[] arr = leftView(bst);

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }

}
