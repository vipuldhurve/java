package graph.toposort;
import java.util.*;

public class TopologicalSortBFS {
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();

        // adding new arraylists to 'adj' to add neighbour nodes
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList < > ());
        }


        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(3).add(1);
        adj.get(2).add(3);

        if(new TopologicalSortBFS().isCyclic(6,adj)){
            System.out.println("Cycle detected in Graph");
        } else {
            System.out.println("Cycle not detected in Graph");
        }
    }

    private boolean isCyclic(int totalNodes, ArrayList<ArrayList<Integer>> adj) {

        //Initializing indegree array
        int[] indegree = new int[totalNodes];
        for (ArrayList<Integer> adjNodes : adj) {
            for (Integer adjNode : adjNodes) {
                indegree[adjNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> topoSortList = new ArrayList<>();

        for (int i = 0; i < totalNodes; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            topoSortList.add(node);
            for(int adjNode: adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        topoSortList.forEach(integer -> System.out.print(integer + " "));
        System.out.println(" ");
        return topoSortList.size() != totalNodes;
    }
}
