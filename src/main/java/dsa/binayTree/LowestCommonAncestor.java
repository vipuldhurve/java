package dsa.binayTree;

import dsa.util.Printer;
import dsa.util.TreeNode;

public class LowestCommonAncestor {
//    Given a binary search tree (BST) or binary tree(BT)
//    where all node values are unique,
//    and two nodes from the tree p and q,
//    return the lowest common ancestor (LCA) of the two nodes.

//    The lowest common ancestor between two nodes p and q
//    is the lowest node in a tree T such that both p and q as descendants.
//    The ancestor is allowed to be a descendant of itself.

//    Example 1:
//             TREE          p = 5 AND q = 1
//              3
//             / \
//            /   \
//           /     \
//          5       1
//         / \     / \
//        6   2   0   8
//           / \
//          7   4
//    OUTPUT: 3

//    Example 2:
//             TREE          p = 5 AND q = 4
//              3
//             / \
//            /   \
//           /     \
//          5       1
//         / \     / \
//        6   2   0   8
//           / \
//          7   4
//    OUTPUT: 5

    //    TIME COMPLEXITY: O(N), where N is the number of nodes in tree
    private static TreeNode lowestCommonAncestorInBinaryTree(TreeNode root, int p, int q) {
        if (root == null) return null;
//        CASE 1: If current-node is either p or q
        if (root.val == p || root.val == q) return root;
//        Check on left and right of current-node
        TreeNode left = lowestCommonAncestorInBinaryTree(root.left, p, q);
        TreeNode right = lowestCommonAncestorInBinaryTree(root.right, p, q);

//        CASE 2: If both, p and q are on left or right side of current node
        if (left == null) return right;
        if (right == null) return left;

//        If left !=null && right != null
//        CASE 3: If one p and q are found, one on left and other on right
        return root;
    }

    private static void solveLcaInBinaryTree(Integer[] levelorder, int p, int q) {
        TreeNode root = TreeNode.createBinaryTreeViaLevelOrder(levelorder);
        System.out.println("BINARY TREE:  p = " + p + "  q = " + q);
        Printer.printBinaryTree(root);
        System.out.println("OUTPUT: " + lowestCommonAncestorInBinaryTree(root, p, q).val + "\n\n");
    }

//    Example 1:
//         BINARY SEARCH TREE          p = 3 AND q = 8
//              5
//             / \
//            /   \
//           3     8
//          / \   / \
//         1   4 7   9
//          \
//           2
//    OUTPUT: 5

//    Example 2:
//        BINARY SEARCH TREE          p = 3 AND q = 4
//              5
//             / \
//            /   \
//           3     8
//          / \   / \
//         1   4 7   9
//          \
//           2
//    OUTPUT: 3

    //    TIME COMPLEXITY: O(N), where N is the number of nodes in tree
    private static TreeNode lowestCommonAncestorInBinarySearchTree(TreeNode root, int p, int q) {
//        Given that p and q both exist in BST
        while (true) {
            if (root.val < p && root.val < q) {
                //            CASE 1: If current-node is less than both p and q
                root = root.right;
            } else if (root.val > p && root.val > q) {
                //            CASE 2: If current-node is more than both p and q
                root = root.left;
            } else {
                //            CASE 3:
                //            (p.val <= curr.val <= q.val)
                //            OR
                //            (p.val >= curr.val >= q.val)
                return root;
            }
        }
    }

    private static void solveLcaInBinarySearchTree(Integer[] levelorder, int p, int q) {
        TreeNode root = TreeNode.createBinaryTreeViaLevelOrder(levelorder);
        System.out.println("BINARY SEARCH TREE:  p = " + p + "  q = " + q);
        Printer.printBinaryTree(root);
        System.out.println("OUTPUT: " + lowestCommonAncestorInBinaryTree(root, p, q).val + "\n\n");
    }

    public static void main(String[] args) {
        Integer[] levelOrder = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        int p = 5;
        int q = 1;
        solveLcaInBinaryTree(levelOrder, p, q);

        p = 5;
        q = 4;
        solveLcaInBinaryTree(levelOrder, p, q);

        levelOrder = new Integer[]{5, 3, 8, 1, 4, 7, 9, null, 2};
        p = 3;
        q = 8;
        solveLcaInBinarySearchTree(levelOrder, p, q);

        p = 3;
        q = 4;
        solveLcaInBinarySearchTree(levelOrder, p, q);
    }
}
