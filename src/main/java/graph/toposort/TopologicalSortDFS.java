package graph.toposort;
import java.util.*;

public class TopologicalSortDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int totalNodes = 6;
        for (int i = 0; i < totalNodes; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            adj.add(arr);
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        int res[] = topoSort(6, adj);

        System.out.println("Toposort of the given graph is:");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    private static int[] topoSort(int totalNodes, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[totalNodes];

        for (int i = 0; i < totalNodes; i++) {
            if(!vis[i]){
                findTopoSort(i, adj, vis, stack);
            }
        }

        int[] topoSortArray = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            topoSortArray[i] = stack.pop();
        }
        return topoSortArray;
    }

    private static void findTopoSort(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stack) {
        vis[node] = true;
        for(int adjNode: adj.get(node)){
            if(!vis[adjNode]){
                findTopoSort(adjNode, adj,vis,stack);
            }
        }
        stack.add(node);
    }
}
