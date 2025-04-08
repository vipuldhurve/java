package dsa.util;

import java.util.*;

public class Printer {

    // Prints INT Matrix In A WELL Formatted Grid
    public static void printIntMatrix(int[][] arr) {
        for (int[] x : arr) {
            for (int y : x) System.out.print(y + "   ");
            System.out.println();
        }
    }

    // Prints String array
    public static void printStringArray(String[] arr) {
        System.out.print("[ ");
        for (String s : arr) {
            System.out.print(s +" ");
        }
        System.out.println("]");
    }

    // Prints CHAR Matrix In A WELL Formatted Grid
    public static void printCharMatrix(char[][] arr) {
        for (char[] x : arr) {
            for (char y : x) System.out.print(y + "   ");
            System.out.println();
        }
    }

    // Prints Graph Nodes And Neighbors
    public static void printGraphNodes(GraphNode node) {
        Set<GraphNode> visitedGraphNode = new HashSet<>();
        printGraphNodesDFS(node, visitedGraphNode);
    }

    private static void printGraphNodesDFS(GraphNode node, Set<GraphNode> visitedGraphNode) {
        if (node == null) return;
        visitedGraphNode.add(node);
        System.out.println(node);
        for (GraphNode neighbor : node.neighbors) {
            if (!visitedGraphNode.contains(neighbor)) printGraphNodesDFS(neighbor, visitedGraphNode);
        }
    }

    // Prints linked list i.e. LIST-NODEs
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Prints Binary Tree Structure
    public static void printBinaryTree(TreeNode root) {
        if (root == null) return;
        // Find the maximum depth of the tree to determine spacing
        int maxLevel = getMaxLevel(root);
        // Print the tree
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    // Helper function to print each level of the tree
    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || areAllElementsNull(nodes)) return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }
                if (nodes.get(j).left != null) System.out.print("/");
                else printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null) System.out.print("\\");
                else printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    // Helper function to print whitespace
    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) System.out.print(" ");
    }

    // Helper function to check if all elements in the List<TreeNode> are null
    private static boolean areAllElementsNull(List<TreeNode> list) {
        for (TreeNode node : list) {
            if (node != null) return false;
        }
        return true;
    }

    // Function to calculate the maximum depth of the tree
    private static int getMaxLevel(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getMaxLevel(node.left), getMaxLevel(node.right)) + 1;
    }
}
