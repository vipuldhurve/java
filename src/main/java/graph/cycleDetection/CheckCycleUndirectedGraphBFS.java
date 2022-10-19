package graph.cycleDetection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckCycleUndirectedGraphBFS {

    public static void main(String[] args) {
        int totalNodes = 5;
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i = 0; i < totalNodes; i++)
            adj.add(i, new ArrayList<Integer>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(3);
        adj.get(1).add(3);
        adj.get(2).add(4);

        CheckCycleUndirectedGraphBFS obj= new CheckCycleUndirectedGraphBFS();

        boolean ans = obj.isCycle(totalNodes, adj);
        if(ans)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public boolean isCycle(int totalNodes, ArrayList<ArrayList<Integer>> adj){

        boolean[] vis = new boolean[totalNodes];
        Arrays.fill(vis, false);
        for (int i = 0; i < totalNodes; i++) {
            if(!vis[i]){
                if(checkForCycleBfs(i, adj, vis)) return true;
            }
        }
        return false;
    }

    public boolean checkForCycleBfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis){

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, -1));
        vis[start] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            ArrayList<Integer> adjNodes = adj.get(node.val);
            for (int adjNode: adjNodes) {

                if(!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.add(new Node(adjNode, node.val));
                } else if(node.parent != adjNode) return true;

            }
        }
        return false;
    }

    class Node {
        int val;
        int parent;

        Node(int val, int parent){
            this.val = val;
            this.parent = parent;
        }
    }

}
