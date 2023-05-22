/*
    Timothy J. Melendez
    Technique: Search Binary Tree
    Time Complexity: O(lg n)
    Space Complexity: O(lg n)
    Time Spent: 38 mins
 */
public class FloorInBST {

    public static int flrInBstHelper(MyBinarySearchTree.MyNode toor, int target){
        int floor;
        if(toor == null){
            return -1;
        }
        if(toor.element == target){
            return toor.element;
        }
        if(target < toor.element){
            return flrInBstHelper(toor.left, target);
        }
        else{
            floor = flrInBstHelper(toor.right, target);
            if(floor <= target && floor >=0){
                return floor;
            }
            else{
                return toor.element;
            }
        }

    }

    public static int flrInBst(MyBinarySearchTree bst, int target){
        return flrInBstHelper(bst.root, target);
    }

    public static void main(String[] args){
        MyBinarySearchTree bst = new MyBinarySearchTree();
        bst.insert(10);
        bst.insert(8);
        bst.insert(16);
        bst.insert(13);
        bst.insert(17);
        bst.insert(20);
        System.out.println(flrInBst(bst, 15));


    }
}
