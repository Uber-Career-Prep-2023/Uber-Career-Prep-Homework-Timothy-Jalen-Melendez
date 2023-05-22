/*
        Timothy J. Melendez
        Technique: Inorder tree traversal
        Time Complexity: O(n)
        Space Complexity: O(n)
        Time Spent: 25 mins
  */


public class IsBST {

    static MyNode previous;
    static class MyNode {
        MyNode left, right;
        int element;
        public MyNode(int elem){
            this.element = elem;
        }
    }
    public static boolean isBstHelper(MyNode root){
        if(root == null){
            return true;
        }
        if(!isBstHelper(root.left)){
            return false;
        }
        if(previous != null && root.element <= previous.element){
            return false;
        }
        previous = root;
        return isBstHelper(root.right);

    }
    static boolean isBst(MyNode root){
        return isBstHelper(root);
    }

    public static void main(String[] args){
        MyNode root = new MyNode(6);
        root.left = new MyNode(4);
        root.right = new MyNode(3);

        boolean val = isBst(root);
        System.out.println("bool value: "+val);
    }
}