import java.util.*;
public class Graph_DFS {
    // Array of Lists untuk Adjacency List Representation
    private final int V; // No of vertices

    // Array of lists untuk adjencency List representation
    private final LinkedList<Integer> adj[];
    Graph_DFS(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v;++i)
            adj[i] = new LinkedList();
    }

    //Function untuk menambah edge ke graph
    void addEdge(int v,int w)
    {
        adj[v].add(w); // Add w to v's list
    }

    //Function untuk menambah edge ke graph
    void DFSutil (int v , boolean visited[])
    {
        // Tandai current node sudah dikunjungi dan print
        visited[v] =true;
        System.out.print(v+" ");

        //Berulang untuk semua simpul yang berdekatan dengan simpul ini
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSutil(n, visited);
        }
    }
    // Fungsi melakukan DFS traversal. Menggunakan DFSUtil secara rekursif
    void DFS(int v)
    {
        // Mark all the vertices as not visited
        // false by default in java)
        boolean visisted[] = new boolean[V];
        //panggil fungsi pembantu rekursif untuk mencetak traversal DFS
        DFSutil(v,visisted);
    }

    public static void main (String args[])
    {
        Graph_DFS g = new Graph_DFS(4);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        System.out.println("Following is depth first traversal "+"(starting from vertex 2)");
        g.DFS(2);
    }
}
