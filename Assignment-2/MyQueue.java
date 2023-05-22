public class MyQueue {

    private MyNode front, back;
    private int size;

    public MyQueue(){
        front = back = null;
        size = 0;
    }
    class MyNode {
        MyNode next;
        int element;
        public MyNode(int elem){
            this.element = elem;
        }
    }
    int peek() { // returns the first item in the queue
        if(!isEmpty()){
            return front.element;
        }
        return -1;
    }
    void enqueue(int x) { // adds x to the back of the queue
        MyNode node = new MyNode(x);
        if(isEmpty()){
            front = node;
            back = node;
            size++;
            return;
        }
        back.next = node;
        back = node;
        size++;
        return;

    }
    int dequeue() { // removes and returns the first item in the queue
        if(isEmpty()){
            return -1;
        }
        int val = front.element;
        front = front.next;
        size--;
        return val;
    }
    boolean isEmpty() { // returns a boolean indicating whether the queue is empty
        return size == 0;
    }
    public static void main(String[] args){
        MyQueue que = new MyQueue();
        que.enqueue(4);
        que.enqueue(3);
        que.enqueue(2);

        while(!que.isEmpty()){
            System.out.println(que.peek());
            que.dequeue();
        }
    }
}
