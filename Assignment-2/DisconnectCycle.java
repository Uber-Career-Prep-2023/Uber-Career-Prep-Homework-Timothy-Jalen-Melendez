/*
    Timothy J. Melendez
    Technique: Hash linked list nodes
    Time Complexity: O(n)
    Space Complexity: O(n)
    Time Spent: 20 mins
 */

import java.util.HashSet;

public class DisconnectCycle {

    public static MyLinkedList.MyNode disconnectCycle(MyLinkedList.MyNode head){
        if(head == null){
            return null;
        }
        MyLinkedList.MyNode ptr = head;
        MyLinkedList.MyNode trailing = null;
        HashSet<MyLinkedList.MyNode> set = new HashSet<>();
        while(ptr != null){
            if(!set.contains(ptr)){
                set.add(ptr);
            }
            else{
                trailing.next = null;
                return head;
            }
            trailing = ptr;
            ptr = ptr.next;

        }
        return head;

    }

    public static void main(String[] args){
        MyLinkedList lst = new MyLinkedList();
        MyLinkedList.MyNode h = lst.insertAtFront(null,1);
        lst.insertAtBack(h, 2);
        lst.insertAtBack(h, 3);
        lst.insertAtBack(h, 4);
        h.next.next.next.next = h.next;
        disconnectCycle(lst.head);
        MyLinkedList.MyNode p = lst.head;
        while(p != null){
            System.out.println(p.element);
            p = p.next;
        }

    }
}
