//BFS(int s) traverses vertices reachable from s/
import java.util.*;


// kelas ini mewakili grafik berarah menggunakan representasi daftar adjacency
class Graph_BFS {
    private final int V; // Jumlah vertex
    private final LinkedList<Integer>adj[]; // Daftar Adjacency


    // Constructor
    Graph_BFS(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v;++i)
            adj[i]= new LinkedList();
    }


    //Fungsi untuk menambahkan edge ke grafik
    void addEdge (int v, int w)
    {
        adj[v].add(w);
    }


    //Mencetak BFS traversal dari sumber yang diberikan s
    void BFS(int s)
    {
        //Tandai semua simpul sebagai belum dikunjungi
        //(secara default disetel sebagai false)
        boolean visited[]=  new boolean[V];


        //Buat antrian (queue) untuk BFS
        LinkedList<Integer>queue = new LinkedList<>();


        //Tandai node saat ini sebagai dikunjungi dan masukkan ke dalam antrian (queue)
        visited[s]= true;
        queue.add(s);


        while(!queue.isEmpty())
        {
            //Ambil vertex dari antrian (queue) dan cetak
            s=queue.poll();
            System.out.print(s+" ");


            //Dapatkan semua simpul yang berdekatan yang belum dikunjungi, tandai
            //mereka sebagai dikunjungi dan masukkan ke dalam antrian (queue)
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }
}
