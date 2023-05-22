/*
    Timothy J. Melendez
    Technique: Generic Tree Traversal
    Time Complexity: O(n)
    Space Complexity: O(n)
    Time Spent: 38 mins
 */



public class CopyTree {

    static class MyBinarySearchTree {


        public MyNode root;
        private int size;

        public MyBinarySearchTree() {
            root = null;
            size = 0;
        }

        int min() {
            if (this.root == null) {
                return 0;
            }
            if (this.root.left == null) {
                return root.element;
            }
            MyNode p = this.root.left;
            while (p.left != null) {
                p = p.left;
            }
            return p.element;
        }

        int max() {
            if (this.root == null) {
                return 0;
            }
            if (this.root.right == null) {
                return root.element;
            }
            MyNode p = this.root.right;
            while (p.right != null) {
                p = p.right;
            }
            return p.element;
        }

        boolean contains(int val) {
            MyNode toor = this.root;
            while (toor != null) {
                if (val == toor.element) {
                    return true;
                } else if (val > toor.element) {
                    toor = toor.right;
                } else if (val < toor.element) {
                    toor = toor.left;
                }
            }
            return false;
        }

        void insert(int val) {
            if (this.root == null) {
                this.root = new MyNode(val);
                size++;
            } else {
                MyNode newNode = new MyNode(val), toor = this.root, parent = null;
                while (toor != null) {
                    if (val > toor.element) {
                        parent = toor;
                        toor = toor.right;
                    } else if (val < toor.element) {
                        parent = toor;
                        toor = toor.left;
                    }
                }
                if (val > parent.element) {
                    parent.right = newNode;
                } else {
                    parent.left = newNode;
                }


                size++;
            }
        }

        int delete(int val) {
            if (!contains(val)) {
                return -1;
            }

            return 0;
        }
    }
    static class MyNode {
        MyNode left, right;
        int element;
        public MyNode(int elem){
            this.element = elem;
        }
    }
    public MyNode copyTree(MyNode root){
        if(root == null){
            return null;
        }
        MyNode toor = new MyNode(root.element);
        toor.left = copyTree(root.left);
        toor.right = copyTree(root.right);
        return toor;
    }

    public static void main(String[] args){
        MyBinarySearchTree bst = new MyBinarySearchTree();
        CopyTree t = new CopyTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(1);
        bst.insert(7);
        bst.insert(8);
        System.out.printf("root: %d, left: %d, right: %d\n", bst.root.element,
                bst.root.left.element, bst.root.right.element);
        MyNode newRoot = t.copyTree(bst.root);
        System.out.printf("root: %d, left: %d, right: %d\n", newRoot.element,
                newRoot.left.element, newRoot.right.element);

    }


}
