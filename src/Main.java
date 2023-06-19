import java.util.*;

public class Main {
    // main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //get vertex number
        int V = scanner.nextInt();

        // creating directed Graph
        Digraph G = new Digraph(V + 1);

        // creating hashmap
        Map<String, Integer> vertices = new LinkedHashMap<>();

        //for put the hash map
        int count = 0;

        // get edge number
        int E = scanner.nextInt();

        // for getting values, put the hash and add to Graph
        for (int i = 0; i < E; i++) {
            String v = scanner.next();
            String w = scanner.next();

            int a, b;

            if (!vertices.containsKey(v)) {
                vertices.put(v, count++);
            }
            a = vertices.get(v);

            if (!vertices.containsKey(w)) {
                vertices.put(w, count++);
            }
            b = vertices.get(w);

            G.addEdge(a, b);
        }

        System.out.println("Enter the number of taxi pickups: ");
        System.out.println("Enter the number of taxi rides: ");
        System.out.println("Enter the taxi rides: ");

        // creating dfs class
        DirectedDFS dfs = new DirectedDFS(G, 0);

        // Print result
        Stack<Integer> list = new Stack<>(); // for reverse
        for (String vertex : vertices.keySet()) {
            int v = vertices.get(vertex);
            System.out.print(vertex + ": ");

            for (int w : G.adj(v)) {
                list.push(w);
            }
            for (int w = list.size() - 1; w >= 0; w--) {
                System.out.print(getKey(vertices, list.pop()) + " ");
            }
            System.out.println();
        }

        // checking has cycle
        if (!dfs.hasCycle()) {
            System.out.println("This ride network can be kept in a tree structure.");
        } else {
            System.out.println("This ride network cannot be kept in a tree structure.");
        }
    }

    //--------------------------------------------------------
    // Summary: This method retrieves the key (string) of a given value (integer) in a given map.
    // Precondition: map is a Map object with String keys and Integer values.
    // value is an integer representing a value in the map.
    // Postcondition: the key associated with the value is returned. If no key is found, null is returned.
    //--------------------------------------------------------
    private static String getKey(Map<String, Integer> map, int value) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}