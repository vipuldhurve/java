package dsa.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

//    LeetCode 973 ------------------------
//    Given an array of points where points[i] = [xi, yi] represents a point
//    on the X-Y plane and an integer k,
//    return the k closest points to the origin (0, 0).
//    The distance between two points on the X-Y plane is the Euclidean distance
//    (i.e., √(x1 - x2)2 + (y1 - y2)2).
//    You may return the answer in any order.
//    The answer is guaranteed to be unique (except for the order that it is in).

//    Input: points = [[1,3],[-2,2]], k = 1, k = 1
//    Output: [[-2,2]]

//    Input: points = [[3,3],[5,-1],[-2,4]], k = 2
//    Output: [[3,3],[-2,4]]


    private static class Node implements Comparable<Node>{
        int[] point;
        int dist;

        Node(int[] point, int dist) {
            this.point = point;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.dist, this.dist);
        }


        static class NodeRevComparator implements Comparator<Node> {
            @Override
            public int compare(Node n1, Node n2) {
                return Integer.compare(n2.dist, n1.dist);
            }
        }

    }


    private static int[][] kClosestPointsToOrigin(int[][] points, int k) {
//        To remove elements of greater distance we need maxHeap
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new Node.NodeRevComparator());
        for (int[] point : points) {
            maxHeap.add(new Node(point, point[0] * point[0] + point[1] * point[1]));
            if (maxHeap.size() > k) maxHeap.poll();
        }

        int[][] kClosestPoints = new int[k][2];
        int i = 0;
        while (maxHeap.size() > 0) {
            kClosestPoints[i++] = maxHeap.poll().point;
        }

        return kClosestPoints;
    }

    private static void solve(int[][] input, int k) {
        System.out.println("INPUT: "+ Arrays.deepToString(input) +" and  k = " + k);
        System.out.println("OUTPUT: " + Arrays.deepToString(kClosestPointsToOrigin(input, k)) +"\n");
    }


    public static void main(String[] args) {
        int[][] input = new int[][]{
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        int k = 2;
        solve(input, k);

        input = new int[][]{
                {1, 3},
                {-2, 2}
        };
        k = 1;
        solve(input, k);
    }

}
