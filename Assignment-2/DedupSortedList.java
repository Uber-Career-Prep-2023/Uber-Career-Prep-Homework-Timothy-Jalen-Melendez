/*
    Timothy J. Melendez
    Technique: LinkedList reset/catch-up two-pointer
    Time Complexity: O(n^2)
    Space Complexity: O(1)
    Time Spent: 24 mins
 */

public class DedupSortedList {

    public static MyLinkedList.MyNode dedupSortedList(MyLinkedList.MyNode head){
        if(head == null){
            return null;
        }
        MyLinkedList.MyNode firstPtr = head;

        while(firstPtr != null){
            MyLinkedList.MyNode secondPtr = firstPtr;
            while(secondPtr != null && secondPtr.element == firstPtr.element){
                secondPtr = secondPtr.next;
            }
            firstPtr.next = secondPtr;
            firstPtr = firstPtr.next;
        }
        return head;

    }

    public static void main(String[] args){
        MyLinkedList lst = new MyLinkedList();
        MyLinkedList.MyNode h = lst.insertAtFront(null,1);
        lst.insertAtBack(h, 2);
        lst.insertAtBack(h, 2);
        lst.insertAtBack(h, 3);
        MyLinkedList.MyNode p = lst.head;
        while(p != null){
            System.out.println(p.element);
            p = p.next;
        }
        MyLinkedList.MyNode newHead = dedupSortedList(h);
        System.out.println("new: "+newHead.element);
        while(newHead != null){
            System.out.println(newHead.element);
            newHead = newHead.next;
        }

    }
}

