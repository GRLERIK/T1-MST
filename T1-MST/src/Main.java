import java.io.File;

public class Main {
    public static void main(String[] args) {

        // Caminho do arquivo (ajuste se quiser outro nome)
        In in = new In(new File("dados/dados.txt"));

        while (true) {
            int m = in.readInt(); // número de vértices
            int n = in.readInt(); // número de arestas

            if (m == 0 && n == 0) break;

            EdgeWeightedGraph G = new EdgeWeightedGraph(m);

            long total = 0; // soma de todas as arestas

            // leitura das arestas
            for (int i = 0; i < n; i++) {
                int x = in.readInt();
                int y = in.readInt();
                int z = in.readInt();

                Edge e = new Edge(x, y, z);
                G.addEdge(e);

                total += z;
            }

            // calcula MST usando Kruskal
            KruskalMST mst = new KruskalMST(G);

            long mstWeight = 0;

            for (Edge e : mst.edges()) {
                mstWeight += e.weight();
            }

            // economia
            long economia = total - mstWeight;

            System.out.println(economia);
        }
    }
}