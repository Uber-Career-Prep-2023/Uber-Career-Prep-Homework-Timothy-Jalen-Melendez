public class MyStack {

    private MyNode top;

    private int size;

    public MyStack(){
        top = null;
        size = 0;
    }
    class MyNode {
        MyNode next;
        int element;
        public MyNode(int elem){
            this.element = elem;
        }
    }

    int top() { // returns the top item in the stack
        if(!isEmpty()){
            return top.element;
        }
        return -1;
    }
    void push(int x){ // adds x to the top of the stack
        MyNode node = new MyNode(x);
        if(top == null){
            top = node;
            size++;
            return;
        }
        node.next = top;
        top = node;
        size++;
        return;

    }
    int pop() { // removes and returns the top item in the stack
        if(isEmpty()){
            return -1;
        }
        int val = top.element;
        MyNode p = top;
        top = top.next;
        p = null;
        size--;
        return val;

    }
    boolean isEmpty(){ // returns a boolean indicating whether the stack is empty
        return size == 0;
    }
    public static void main(String [] args){
        MyStack stck = new MyStack();
        stck.push(4);
        stck.push(3);
        stck.push(2);
        while(!stck.isEmpty()){
            System.out.println(stck.top());
            stck.pop();
        }
    }
}

