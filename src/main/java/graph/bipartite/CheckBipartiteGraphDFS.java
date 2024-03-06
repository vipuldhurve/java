package graph.bipartite;
import java.util.*;
public class CheckBipartiteGraphDFS {

    public static void main(String[] args) {
        int totalNodes = 6;
        ArrayList < ArrayList < Integer >> graph = new ArrayList < ArrayList < Integer >> ();

        for (int i = 0; i < totalNodes; i++)
            graph.add(new ArrayList < Integer > ());

        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(1).add(4);
        graph.get(4).add(1);

        graph.get(1).add(5);
        graph.get(5).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(4);
        graph.get(4).add(3);

        graph.get(3).add(5);
        graph.get(5).add(3);

        if (checkBipartite(graph, totalNodes))
            System.out.println("It is a Bipartite Graph");
        else
            System.out.println("It is not a Bipartite Graph");
    }

    private static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int totalNodes) {
        int[] color = new int[totalNodes];
        Arrays.fill(color, -1);
        // A graph can have multiple components
        // do traversal on all components of Graph.
        for (int i = 0; i < totalNodes; i++) {
            if(color[i] == -1) {
                if(!checkBipartiteDfs(i,adj, color)) return false;
            }
        }
        return true;
    }

    private static boolean checkBipartiteDfs(int node, ArrayList<ArrayList<Integer>> adj, int[] color) {

        if(color[node] == -1) color[node] = 0;

        for(int adjNode: adj.get(node)){
            if(color[adjNode] == -1){
                color[adjNode] = 1 - color[node];
                if(!checkBipartiteDfs(adjNode, adj, color)) return false;
            } else if(color[adjNode] == color[node])  return false;
        }
        return true;
    }
}
