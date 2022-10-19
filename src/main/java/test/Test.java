package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
        for (int test = 1; test <= z; test++) {
            int totalNodes = sc.nextInt();
            int edges = sc.nextInt();

            ArrayList<ArrayList<Node>> adj = new ArrayList<>();
            for (int i = 0; i <= totalNodes; i++)
                adj.add(new ArrayList<>());

            for (int i = 0; i < edges; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();

                adj.get(u).add(new Node(v, w));
                adj.get(v).add(new Node(u, w));
            }

            System.out.println(shortestPath(1,  adj, totalNodes));
        }
    }

    private static int shortestPath(int src, ArrayList<ArrayList<Node>> adj, int totlaNodes) {
        PriorityQueue<Node> q = new PriorityQueue<>(new Node());

        int[] dist = new int[totlaNodes+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        q.add(new Node(src, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            for(Node level1Node: adj.get(node.v)){
                if(dist[level1Node.v] > dist[node.v] + level1Node.weight){
                    dist[level1Node.v] = dist[node.v] + level1Node.weight;
                    q.add(new Node(level1Node.v, dist[level1Node.v]));
                }

                for(Node level2Node : adj.get(level1Node.v)){
                    if(dist[level2Node.v] > dist[node.v] + 2*level1Node.weight){
                        dist[level2Node.v] = dist[node.v] + 2*level1Node.weight;
                        q.add(new Node(level2Node.v, dist[level2Node.v]));
                    }
                }
            }
        }

        return dist[totlaNodes];
//        System.out.println("The distances from source "+src+" are : ");
//        for (int i = 0; i < totlaNodes; i++)
//        {
//            System.out.print( dist[i] + " ");
//        }
    }

    static class Node implements Comparator<Node> {
        int v;
        int weight;

        Node(){}
        Node(int v, int weight){
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compare(Node n1, Node n2) {
            return n1.weight - n2.weight;
        }
    }

}


