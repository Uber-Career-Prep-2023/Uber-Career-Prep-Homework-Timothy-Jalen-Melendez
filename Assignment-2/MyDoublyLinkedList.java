public class MyDoublyLinkedList {

    private MyNode head;
    private int size;

    public MyDoublyLinkedList(){
        head = null;
        size = 0;
    }
    MyNode insertAtFront(MyNode head, int val){
        MyNode node = new MyNode(val);
        if(head == null){
            head = node;
            return head;
        }
        head.prev = node;
        node.next = head;

        return node;
    }
    void insertAtBack(MyNode head, int val){
        MyNode node = new MyNode(val);
        if(head == null){
            head = node;
        }
        else{
            MyNode p = head;
            while(p.next != null){
                p = p.next;
            }
            p.next = node;
            node.prev = p;

        }
    }
    void insertAfter(MyNode head, int val, MyNode loc){
        MyNode node = new MyNode(val);
        if(head == null){
            head = node;
        }
        else{
            MyNode p = head;
            while(p != loc){
                p = p.next;
            }
            p.next = node;
            node.prev = p;
            node.next = p.next.next;
            if(p.next.next != null){
                p.next.next.prev = node;
            }
        }
    }
    MyNode deleteFront(MyNode head){
        if(head == null){
            return head;
        }
        MyNode p = head.next;
        if(p != null){
            p.prev = null;
        }
        head = null;

        return p;

    }
    void deleteBack(MyNode head){
        MyNode p = head;
        while(p.next != null){
            if(p.next.next == null){
                p.next = null;
                return;
            }
            p = p.next;
        }
    }
    MyNode deleteNode(MyNode head, MyNode loc){
        if(head == null){
            return null;
        }
        else if(head == loc){
            MyNode p = head.next;
            head = null;
            return p;
        }
        else{
            MyNode p = head;
            while(p.next != loc){
                p = p.next;
            }
            p.next = p.next.next;
            return head;

        }
    }
    int length(MyNode head){
        MyNode p = head;
        int count = 0;
        while(p != null){
            count++;
            p = p.next;
        }
        return count;
    }
    MyNode reverseIterative(MyNode head){
        MyNode next, prev = null;
        for(int i = 0; head != null && i < size; i++, head = next){
            next = head.next;
            head.next = prev;
            prev = head;

        }
        return head;
    }
    MyNode reverseRecursive(MyNode head){
        if(head != null){
            reverseHelper(head, null);
        }
        return head;
    }

    void reverseHelper(MyNode current, MyNode previous){
        if(current.next == null){
            head = current;
            current.next = previous;
            return;
        }
        MyNode next = current.next;
        current.next = previous;
        reverseHelper(next, current);
    }
    class MyNode {
        MyNode next, prev;
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

Node insertAtFront(Node head, int val) // creates new Node with data val at front; returns new head
void insertAtBack(Node head int val) // creates new Node with data val at end
void insertAfter(Node head, int val, Node loc) // creates new Node with data val after Node loc
Node deleteFront(Node head) // removes first Node; returns new head
void deleteBack(Node head) // removes last Node
Node deleteNode(Node head, Node loc) // deletes Node loc; returns head
int length(Node head) // returns length of the list
Node reverseIterative(Node head) // reverses the linked list iteratively
Node reverseRecursive(Node head) // reverses the linked list recursively (Hint: you will need a helper function)
 */