/*
    Timothy J. Melendez
    Technique: Doubly Linked list forward-backward two-pointer
    Time Complexity: O(n)
    Space Complexity: O(1)
    Time Spent: 15 mins
 */

public class IsPalindrome {

    public static boolean isPalindrome(MyDoublyLinkedList.MyNode head){

        if(head == null){
            return true;
        }
        if(head.next == null){
            return true;
        }
        MyDoublyLinkedList.MyNode end = head;
        while(end.next != null){
            end = end.next;
        }
        MyDoublyLinkedList.MyNode begin = head;
        while(begin != null){
            if(begin.element != end.element){
                return false;
            }
            begin = begin.next;
            end = end.prev;
        }
        return true;

    }

    public static void main(String[] args){
        MyDoublyLinkedList lst = new MyDoublyLinkedList();
        MyDoublyLinkedList.MyNode h = lst.insertAtFront(null,1);
        lst.insertAtBack(h, 2);
        lst.insertAtBack(h, 1);
        MyDoublyLinkedList.MyNode p = lst.head;
        while(p != null){
            System.out.println(p.element);
            p = p.next;
        }
        System.out.println("bool: "+ isPalindrome(h));
    }
}
