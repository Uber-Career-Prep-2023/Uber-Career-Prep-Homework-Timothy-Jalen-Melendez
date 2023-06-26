import java.util.ArrayList;

/*
 * Question 2: Build a Heap
 */
public class MyHeap {

        private int[] array; // the underlying array
        private int index;
        public MyHeap(int sz){
                array = new int[sz];
                index = 0;
        }
        public int top(){ // returns the min (top) element in the heap
              if(array.length >= 1){
                      return array[0];
              }
              return -1;
        }
        public void insert(int x){ // adds int x to the heap in the appropriate position
                array[index] = x;
                int curr = index;
                while(array[curr] < array[parent(curr)]){
                        int temp = array[curr];
                        array[curr] = array[parent(curr)];
                        array[parent(curr)] = temp;
                        curr = parent(curr);
                }
                index++;
        }
        private int leftCh(int i ){
                return (i * 2) + 1;
        }
        private int rightCh(int i ){
                return (i * 2) + 2;
        }
        private int parent(int i ){
                return (i - 1)/ 2;
        }
        private void heapify(int idx){
                if(rightCh(idx) >= array.length || leftCh(idx) >= array.length){
                        return;
                }
                if(array[idx] > array[leftCh(idx)] || array[idx] > array[rightCh(idx)]){
                        if(array[leftCh(idx)] < array[rightCh(idx)]){
                                int temp = array[idx];
                                array[idx] = array[parent(leftCh(idx))];
                                array[parent(leftCh(idx))] = temp;
                                heapify(leftCh(idx));
                        }else{
                                int temp = array[idx];
                                array[idx] = array[parent(rightCh(idx))];
                                array[parent(rightCh(idx))] = temp;
                                heapify(rightCh(idx));
                        }
                }

        }
        public void remove(){ // removes the min (top) element in the heap
                if(array.length < 1){
                        return;
                }
                array[0] = array[--index];
                heapify(0);
        }
        public static void main(String[] args){
                MyHeap minHeap = new MyHeap(5);

                minHeap.insert(2);
                minHeap.insert(18);
                minHeap.insert(15);
                minHeap.insert(7);
                minHeap.insert(12);

                //Expected 2
                System.out.println(minHeap.top());
                /*
                Insertion and deletion time complexity: O(log n)
                Space complexity O(log n)

                top() time complexity : O(1)

                heapify: O(n)


                 */


                /*
                minHeap.remove();
                minHeap.remove();

                //Expected 12
                System.out.println(minHeap.top());
                minHeap.remove();

                //Expected 15
                System.out.println(minHeap.top());
                minHeap.remove();

                //Expected 18
                System.out.println(minHeap.top());
                minHeap.remove();

                //Expected -1
                System.out.println(minHeap.top());
                */


        }
}
