public class MyDoublyLinkedList {

    MyNode head;
    private int size;

    public MyDoublyLinkedList(){
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
        node.next = head;
        head.prev = node;
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
            MyNode p = head;
            while(p.next != null){
                p = p.next;
            }
            p.next = node;
            node.prev = p;

        }
        this.size++;
    }
    void insertAfter(MyNode head, int val, MyNode loc){
        MyNode node = new MyNode(val);
        if(head == null){
            this.head = node;
        }
        else{
            MyNode p = head;
            while(p != loc){
                p = p.next;
            }
            node.prev = p;
            node.next = p.next;
            p.next = node;
            if(node.next != null){
                node.next.prev = node;
            }
        }
        this.size++;
    }
    MyNode deleteFront(MyNode head){
        if(head == null){
            return head;
        }
        MyNode p = head.next;
        if(p != null){
            p.prev = null;
        }
        this.head = p;
        this.size--;

        return this.head;

    }
    void deleteBack(MyNode head){
        MyNode p = head;
        while(p.next != null){
            p = p.next;
        }
        if(p.prev != null){
            p.prev.next = null;
        }
        p.prev = null;
        if(this.size == 1){
            head = null;
            this.head = null;
        }
        this.size--;
    }
    MyNode deleteNode(MyNode head, MyNode loc){
        if(head == null){
            return null;
        }
        else if(head == loc){
            MyNode p = head.next;
            if(p != null){
                p.prev = null;
            }
            head = null;
            this.head = p;
            this.size--;
            return this.head;
        }
        else{
            MyNode p = head;
            while(p.next != loc){
                p = p.next;
            }
            p.next = p.next.next;
            p.next.prev = p;
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
        return size;
    }
    MyNode reverseIterative(MyNode head){
        MyNode t = null, prev = null, curr = head;
        for(int i = 0; curr != null; i++){
            t = curr.prev;
            curr.prev = curr.next;
            curr.next = t;
            curr = curr.prev;
        }
        if(t == null);
        else{
            this.head = t.prev;
        }
        return this.head;
    }
    MyNode reverseRecursive(MyNode head){
        if(head != null){
            reverseHelper(head, null);
        }
        return this.head;
    }

    void reverseHelper(MyNode current, MyNode previous){
        if(current == null){
            return;
        }
        MyNode t = current.next;
        current.next = current.prev;
        current.prev = t;
        if(current.prev != null){
            reverseHelper(current.prev, null);
        }
        else{
            this.head = current;
            return;
        }
    }
    class MyNode {
        MyNode next, prev;
        int element;
        public MyNode(int elem){
            this.element = elem;
        }
    }

    public static void main(String[] args){
        MyDoublyLinkedList lst = new MyDoublyLinkedList();
        MyNode h = lst.insertAtFront(null, 2);
        lst.insertAtBack(h, 4);
        lst.insertAtFront(h,1);
        lst.insertAtBack(h, 5);
        lst.insertAfter(h, 3, lst.head.next);
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