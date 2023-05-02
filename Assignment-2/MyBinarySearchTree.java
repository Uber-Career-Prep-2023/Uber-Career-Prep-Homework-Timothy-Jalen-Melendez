public class MyBinarySearchTree {


    private MyBinarySearchTree.MyNode root;
    private int size;

    public MyBinarySearchTree(){
        root = null;
        size = 0;
    }

    int min(){

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
        MyNode toor = root;
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
        if(root == null){
            root = new MyNode(val);
            size++;
        }
        else{
            MyNode newNode = new MyNode(val), toor = root;
            while(toor != null){
                if(toor.element < val){
                    toor = toor.left;
                }
                else if(toor.element > val){
                    toor = toor.right;
                }
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
        MyBinarySearchTree.MyNode left, right;
        int element;
        public MyNode(int elem){
            this.element = elem;
        }
    }

    public static void main(String[] args){
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