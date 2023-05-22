/*
    Timothy J. Melendez
    Technique: Linked list fixed distance two-pointer
    Time Complexity: O(n)
    Space Complexity: O(1)
    Time Spent: 32 mins
 */
public class MoveNthLastToFront {

    public static MyLinkedList.MyNode nthLastToFront(MyLinkedList lst, int k){
        MyLinkedList.MyNode head = lst.head;
        if(head == null){
            return null;
        }
        MyLinkedList.MyNode p = head;
        int i = 0;
        while(p != null){
            i++;
            p = p.next;

        }
        if(k > i){
            return null;
        }
        else if(k == i){
            return head;
        }
        MyLinkedList.MyNode ptr = head;
        for(int n = 1; n < i - k && ptr != null; n++){
            ptr = ptr.next;
        }
        MyLinkedList.MyNode temp = ptr.next;
        System.out.println("t: "+ temp.element);
        if(temp != null){
            ptr.next = temp.next;
            temp.next = lst.head;
            lst.head = temp;
        }
        return lst.head;
    }

    public static void main(String[] args){
        MyLinkedList lst = new MyLinkedList();
        MyLinkedList.MyNode h = lst.insertAtFront(null,1);
        lst.insertAtBack(h, 2);
        lst.insertAtBack(h, 3);
        lst.insertAtBack(h, 4);
        lst.insertAtBack(h, 5);
        MyLinkedList.MyNode p = lst.head;
        while(p != null){
            System.out.println(p.element);
            p = p.next;
        }
        System.out.println("~~~~~~");
        nthLastToFront(lst, 3);
        MyLinkedList.MyNode t = lst.head;
        while(t != null){
            System.out.println(t.element);
            t = t.next;
        }
    }
}
