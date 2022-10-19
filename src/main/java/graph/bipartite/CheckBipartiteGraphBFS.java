package graph.bipartite;
import java.util.*;
public class CheckBipartiteGraphBFS {

    public static void main(String[] args) {
        int totalNodes = 7;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();

        for (int i = 0; i < totalNodes; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(4).add(3);
        adj.get(3).add(4);

        adj.get(4).add(5);
        adj.get(5).add(4);

//        adj.get(4).add(6);
//        adj.get(6).add(4);

        adj.get(5).add(6);
        adj.get(6).add(5);

        adj.get(1).add(6);
        adj.get(6).add(1);


        CheckBipartiteGraphBFS obj = new CheckBipartiteGraphBFS();
        if(obj.checkBipartite(adj, totalNodes)) System.out.println("Yes Bipartite");
        else System.out.println("Not Bipartite");
    }

    private boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int totalNodes) {
        int[] color = new int[totalNodes];
        Arrays.fill(color, -1);
        // A graph can have multiple components
        // do traversal on all components of Graph.
        for (int i = 0; i < totalNodes; i++) {
            if(color[i] == -1) {
                if(!checkBipartiteBfs(i, adj, color)) return false;
            }
        }
        return true;
    }

    private boolean checkBipartiteBfs(int startNode, ArrayList<ArrayList<Integer>> adj, int[] color) {

        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        color[startNode] = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int adjNode: adj.get(node)){
                if(color[adjNode] == -1){
                    color[adjNode] = 1 - color[node];
                    q.add(adjNode);
                } else if(color[adjNode] == color[node]) return false;
            }
        }
        return true;
    }
}
