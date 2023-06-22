/*
  Question 1: Adjacency List
 */
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
public class AdjacencyList {


    private HashMap<Integer, Set<Integer>> map;


    public AdjacencyList(){
        map = new HashMap<>();
    }
    static class Pair {
        int[] arr;
        public Pair(int a, int b){
            arr = new int[2];
            arr[0] = a;
            arr[1] = b;
        }
        public int getA(){
           return arr[0];
        }
        public int getB(){
            return arr[1];
        }
    }

    public HashMap<Integer, Set<Integer>> adjacencySet(Pair[] edges){
        for(int i = 0; i < edges.length; i++){
             Pair p = edges[i];
             int a = p.getA();
             int b = p.getB();
             Set<Integer> set;
             if(!map.containsKey(a)){
                 set = new HashSet<>();
                 set.add(p.getB());
                 map.put(a, set);
             }
             else{
                 set = new HashSet<>();
                 set.addAll(map.get(a));
                 set.add(p.getB());
                 map.put(a, set);
             }
             if(!map.containsKey(b)){
                 set = new HashSet<>();
                 map.put(b, set);
             }
        }
        return map;
    }

    public void printAdjList(HashMap<Integer, Set<Integer>> mp){
        for(Map.Entry<Integer, Set<Integer>> entry: mp.entrySet()){
            System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
        }
    }
/*
    boolean bfs(int target, map<int, set<int>> graph);
    boolean dfs(int target, map<int, set<int>> graph);
    array<int> topologicalSort(map<int, set<int>> graph);
*/

    public static void main(String[] args){
        /*
    // Build graph representation. You can also use an array rather than a set
    map<int, set<int>> adjacencySet(array<pair<int, int>> edges);
    // Example
    Input: [(1, 2), (2, 3), (1, 3), (3, 2), (2, 0)]
    Output:
    {
        0: []
        1: [2, 3]
        2: [0, 3]
        3: [2]
    }

     */
        Pair[] arr = new Pair[5];
        Pair p1 = new Pair(1,2);
        arr[0] = p1;
        Pair p2 = new Pair(2,3);
        arr[1] = p2;
        Pair p3 = new Pair(1,3);
        arr[2] = p3;
        Pair p4 = new Pair(3,2);
        arr[3] = p4;
        Pair p5 = new Pair(2,0);
        arr[4] = p5;

        AdjacencyList list = new AdjacencyList();
        list.adjacencySet(arr);
        list.printAdjList(list.map);
        System.out.println("~~~~~~~~");

        arr = new Pair[6];
        p1 = new Pair(1,2);
        arr[0] = p1;
        p2 = new Pair(2,3);
        arr[1] = p2;
        p3 = new Pair(1,3);
        arr[2] = p3;
        p4 = new Pair(3,2);
        arr[3] = p4;
        p5 = new Pair(2,0);
        arr[4] = p5;
        Pair p6 = new Pair(4,1);
        arr[5] = p6;
        list = new AdjacencyList();
        list.adjacencySet(arr);
        list.printAdjList(list.map);


    }
}
