package dsa.binayTree;

import dsa.util.Printer;
import dsa.util.TreeNode;

public class BalancedBinaryTree {
//    Given a binary tree, return true if it is height-balanced and false otherwise.

//    A height-balanced binary tree is defined as
//    a binary tree in which the left and right subtrees of every node
//    differ in height by no more than 1.

//    Example 1:
//    INPUT:
//              3
//             / \
//            /   \
//           9     20
//                / \
//               15   7
//    OUTPUT: TRUE

//    Example 2:
//    INPUT:

//              1
//             / \
//            /   \
//           2     2
//          / \
//         3   3
//        / \
//       4   4
//    OUTPUT: false

    private static int isBalanced(TreeNode root) {
//        Method will return maximum length of left or right part of tree
//        Or -1 if either side is not height balanced
        if (root == null) return 0;
//        Recursive calls to check heights of left and right part
        int left = isBalanced(root.left);
        int right = isBalanced(root.right);
//        If left or right part is not balanced then return -1
//        If difference between left and right part of tree heights is > 1
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
//        Return max length from right and left part of tree
        return 1 + Math.max(isBalanced(root.left), isBalanced(root.right));
    }

    private static void solve(Integer[] levelorder) {
        TreeNode root = TreeNode.createBinaryTreeViaLevelOrder(levelorder);
        System.out.println("INPUT:");
        Printer.printBinaryTree(root);
        boolean isHeightBalanced = (isBalanced(root) == -1 ? false : true);
        System.out.println("OUTPUT: " + String.valueOf(isHeightBalanced).toUpperCase() + "\n\n");
    }

    public static void main(String[] args) {
        Integer[] levelOrder = new Integer[]{3, 9, 20, null, null, 15, 7};
        solve(levelOrder);

        levelOrder = new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4};
        solve(levelOrder);
    }
}
