import java.util.Stack;

public class DirectedDFS {
    private boolean[] marked;
    private boolean hasCycle;
    private Stack<Integer> reversePost; // Topological order

    // constructor
    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        hasCycle = false;
        reversePost = new Stack<Integer>();
        dfs(G, s);
    }

    //--------------------------------------------------------
    // Summary: Depth First Search Method.
    // Precondition: G is a Directed Graph and v is an integer.
    // Postcondition: all vertices in G have been visited recursively.
    //--------------------------------------------------------
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            } else if (reversePost.contains(w)) { // Back edge detected, there is a cycle
                hasCycle = true;
            }
        }
        reversePost.push(v); // Add vertex to the topological order
    }

    //--------------------------------------------------------------
    // Summary: Check if the directed graph has a cycle.
    // Precondition: The directed graph G has been created.
    // Postcondition: Returns true if the directed graph has a cycle.
    //--------------------------------------------------------------
    public boolean hasCycle() {
        return hasCycle;
    }

}
