public class MyBinarySearchTree {


    public MyNode root;
    private int size;

    public MyBinarySearchTree(){
        root = null;
        size = 0;
    }

    int min(){
        if(this.root == null){
            return 0;
        }
        if(this.root.left == null){
            return root.element;
        }
        MyNode p = this.root.left;
        while(p.left != null){
            p = p.left;
        }
        return p.element;
    }

    int max(){
        if(this.root == null){
            return 0;
        }
        if(this.root.right == null){
            return root.element;
        }
        MyNode p = this.root.right;
        while(p.right != null){
            p = p.right;
        }
        return p.element;
    }

    boolean contains(int val){
        MyNode toor = this.root;
        while(toor != null){
            if(val == toor.element){
                return true;
            }
            else if(val > toor.element){
                toor = toor.right;
            }
            else if(val < toor.element){
                toor = toor.left;
            }
        }
        return false;
    }

    void insert(int val){
        if(this.root == null){
            this.root = new MyNode(val);
            size++;
        }
        else{
            MyNode newNode = new MyNode(val), toor = this.root, parent = null;
            while(toor != null) {
                if (val > toor.element) {
                    parent = toor;
                    toor = toor.right;
                } else if (val < toor.element) {
                    parent = toor;
                    toor = toor.left;
                }
            }
            if(val > parent.element){
                parent.right = newNode;
            }
            else{
                parent.left = newNode;
            }


            size++;
        }
    }

    int delete(int val){
        if(!contains(val)){
            return -1;
        }
        
        return 0;
    }
    class MyNode {
        MyNode left, right;
        int element;
        public MyNode(int elem){
            this.element = elem;
        }
    }

    public static void main(String[] args){
        MyBinarySearchTree bst = new MyBinarySearchTree();

        System.out.println("Hello World");
    }
}
/*
    int min() // returns the minimum value in the BST
    int max() // returns the maximum value in the BST
    bool contains(int val) // returns a boolean indicating whether val is present in the BST
    // For simplicity, do not allow duplicates. If val is already present, insert is a no-op
    void insert(int val) // creates a new Node with data val in the appropriate location
    int delete(int val) // deletes the Node with data val, if it exists

 */