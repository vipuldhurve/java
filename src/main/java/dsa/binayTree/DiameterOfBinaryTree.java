package dsa.binayTree;

import dsa.util.Printer;
import dsa.util.TreeNode;

public class DiameterOfBinaryTree {
//    The diameter of a binary tree is defined as
//    the length of the longest path between any two nodes within the tree.
//    The path does not necessarily have to pass through the root.

//    The length of a path between two nodes in a binary tree is the number of edges between the nodes.

//    Given the root of a binary tree root,
//    return the diameter of the tree.


//    INPUT:
//              1
//               \
//                \
//                 2
//                / \
//               3   4
//              /
//             5

//    OUTPUT: 3               Path     5 -> 3 -> 2 -> 4

    static int DIAMETER;

    private static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

//        If longest path includes current node
        DIAMETER = Math.max(DIAMETER, 1 + left + right);

//        Return longest side i.e. left or right
        return Math.max(left, right) + 1;
    }

    private static void solve(Integer[] levelOrder) {
        System.out.println("INPUT:");
        TreeNode root = TreeNode.createBinaryTreeViaLevelOrder(levelOrder);
        Printer.printBinaryTree(root);
        DIAMETER = 0;
        diameterOfBinaryTree(root);
        System.out.println("OUTPUT: " + (DIAMETER - 1) + "\n\n");

    }

    public static void main(String[] args) {
        Integer[] levelOrder = new Integer[]{1, null, 2, 3, 4, 5, null};
        solve(levelOrder);

        levelOrder = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        solve(levelOrder);

        levelOrder = new Integer[]{1, 2, 3, 4, 5, null, null, null, null, 6, 7};
        solve(levelOrder);

        levelOrder = new Integer[]{3, 2, 1};
        solve(levelOrder);
    }
}
