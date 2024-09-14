package dsa.binayTree;

import dsa.util.Printer;
import dsa.util.TreeNode;

public class InvertBinaryTree {
//    You are given the root of a binary tree root.
//    Invert the binary tree and return its root.

//    INPUT:
//              1
//             / \
//            /   \
//           2     3
//          / \   / \
//         4   5 6   7
//    OUTPUT:
//              1
//             / \
//            /   \
//           3     2
//          / \   / \
//         7   6 5   4

    //    TIME COMPLEXITY: O(N)
    //    SPACE COMPLEXITY: O(H) where H is height. Best-case: O(logN) and Worst-case: O(N)
    private static TreeNode invertTree(TreeNode root) {
//        Base condition
        if (root == null) return null;

//        Hypothesis
//        This recursive call will invert the left part of root
        TreeNode left = invertTree(root.left);
//        This recursive call will invert the right part of root
        TreeNode right = invertTree(root.right);

//        Induction
        root.left = right;
        root.right = left;
        return root;
    }

    private static void solve(Integer[] levelOrder) {
        TreeNode root = TreeNode.createBinaryTreeViaLevelOrder(levelOrder);
        System.out.println("INPUT:");
        Printer.printBinaryTree(root);
        System.out.println("OUTPUT:");
        TreeNode invertedTreeRoot = invertTree(root);
        Printer.printBinaryTree(invertedTreeRoot);
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Integer[] levelOrder = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        solve(levelOrder);

        levelOrder = new Integer[]{1, 2, 3, 4, 5, null, null, null, null, 6, 7};
        solve(levelOrder);

        levelOrder = new Integer[]{3, 2, 1};
        solve(levelOrder);
    }
}
