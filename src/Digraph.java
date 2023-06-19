import java.util.LinkedList;

public class Digraph {
    private final int V;
    private int E;
    private final LinkedList<Integer>[] adj;

    //constructor
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    //return V(vertex number)
    public int V() {
        return V;
    }

    // return E(edge number)
    public int E() {
        return E;
    }

    //--------------------------------------------------------
    // Summary: Connecting the vertex with the vertices.
    // Precondition: v and w are an integer.
    // Postcondition: vertices connected by edges and edge number increased.
    //--------------------------------------------------------
    public void addEdge(int v, int w) {
        if (v < V && w < V) {
            adj[v].add(w);
            E++;
        }
    }

    //return adj list
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
