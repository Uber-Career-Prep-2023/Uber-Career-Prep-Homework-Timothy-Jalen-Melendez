public class MyLinkedList {

    MyNode head;
    private int size;

    public MyLinkedList(){
        head = null;
        size = 0;
    }
    MyNode insertAtFront(MyNode head, int val){
        MyNode node = new MyNode(val);
        if(head == null){
            this.head = node;
            this.size++;
            return this.head;
        }
        node.next = this.head;
        this.head = node;
        this.size++;
        return this.head;
    }
    void insertAtBack(MyNode head, int val){
        MyNode node = new MyNode(val);
        if(head == null){
            this.head = node;
        }
        else{
            MyNode p = this.head;
            while(p.next != null){
               p = p.next;
            }
            p.next = node;
        }
        this.size++;
    }
    void insertAfter(MyNode head, int val, MyNode loc){
        MyNode node = new MyNode(val);
        if(head == null){
            this.head = node;
        }
        else{
            MyNode p = this.head;
            while(p != loc){
                p = p.next;
            }
            node.next = p.next;
            p.next = node;
        }
        this.size++;
    }
    MyNode deleteFront(MyNode head){
        if(head == null){
            this.size--;
            return head;
        }
        this.head = this.head.next;
        this.size--;

        return this.head;

    }
    void deleteBack(MyNode head){
        MyNode p = head;
        while(p.next != null){
            if(p.next.next == null){
                p.next = null;
                this.size--;
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
            this.size--;
            return p;
        }
        else{
            MyNode p = head;
            while(p.next != loc){
                p = p.next;
            }
            p.next = p.next.next;
            this.size--;
            return head;

        }
    }
    int length(MyNode head){
        /*
        MyNode p = head;
        int count = 0;
        while(p != null){
            count++;
            p = p.next;
        }
        return count;
         */
        return this.size;
    }
    MyNode reverseIterative(MyNode head){
        MyNode next = null, prev = null, curr = head;
        for(int i = 0; curr != null; i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;
        return this.head;
    }
    MyNode reverseRecursive(MyNode head){
        if(head != null){
            reverseHelper(head, null);
        }
        return head;
    }

    void reverseHelper(MyNode current, MyNode previous){
        if(current.next == null){
            this.head = current;
            current.next = previous;
            return;
        }
        MyNode next = current.next;
        current.next = previous;
        reverseHelper(next, current);
    }
    class MyNode {
        MyNode next;
        int element;
        public MyNode(int elem){
            this.element = elem;
        }
    }

    public static void main(String[] args){
        MyLinkedList lst = new MyLinkedList();
        MyNode h = lst.insertAtFront(null, 1);
        lst.insertAtBack(h, 2);
        lst.insertAtFront(h,4);
        lst.insertAtBack(h, 3);
        lst.insertAfter(h, 7, lst.head.next);
        MyNode p = lst.head;
        while(p != null){
            System.out.println(p.element);
            p = p.next;
        }
        System.out.println("Size: " + lst.size);
        System.out.println("~~~~~~");
        System.out.println("Head: "+lst.head.element);
        lst.reverseRecursive(lst.head);
        p = lst.head;
        while(p != null){
            System.out.println(p.element);
            p = p.next;
        }
        System.out.println("Size: " + lst.size);
        System.out.println("~~~~~~");

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