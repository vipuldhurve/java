package dsa.binayTree;

import dsa.util.Printer;
import dsa.util.TreeNode;

public class SubtreeOfBinaryTree {
//    Given the roots of two binary trees root and subRoot,
//    return true if there is a subtree of root with the same structure
//    and node values of subRoot and false otherwise.

//    A subtree of a binary tree is a tree that consists of a node in tree
//    and all of this node's descendants.
//    The tree could also be considered as a subtree of itself.

//    Example 1:
//             TREE                           SUB-TREE
//              1                                 2
//             / \                               / \
//            /   \                             4   5
//           2     3
//          / \
//         4   5
//    OUTPUT: true

//    Example 2:
//             TREE                           SUB-TREE
//              1                                 2
//             / \                               / \
//            /   \                             4   5
//           2     3
//          / \
//         4   5
//        /
//       6
//    OUTPUT: false


    //    TIME COMPLEXITY: O(N * M)
    //    where N is the number of nodes in root,
    //    and M is the number of nodes in subRoot.

    private static boolean isSameTree(TreeNode rootA, TreeNode rootB) {
//        If both nodes are null
        if (rootA == null && rootB == null) return true;
//        If one of the node is null
        if (rootA == null || rootB == null) return false;
//        If node values are same
//        If left and right part are also sameTree
        return rootA.val == rootB.val
                && isSameTree(rootA.left, rootB.left)
                && isSameTree(rootA.right, rootB.right);
    }

    private static boolean isSubTree(TreeNode root, TreeNode subRoot) {
//        null is always a subTree of root
        if (subRoot == null) return true;
//        If root is null, not possible
        if (root == null) return false;
//        If subTree is same as tree
//        OR If subTree is same as tree's left part or right part
        return isSameTree(root, subRoot)
                || isSubTree(root.left, subRoot)
                || isSubTree(root.right, subRoot);
    }

    private static void solve(Integer[] levelOrderTree, Integer[] levelOrderSubtree) {
        TreeNode root = TreeNode.createBinaryTreeViaLevelOrder(levelOrderTree);
        TreeNode subRoot = TreeNode.createBinaryTreeViaLevelOrder(levelOrderSubtree);
        System.out.println("TREE:");
        Printer.printBinaryTree(root);
        System.out.println("SUB-TREE:");
        Printer.printBinaryTree(subRoot);
        System.out.println("OUTPUT: " + String.valueOf(isSubTree(root, subRoot)).toUpperCase() + "\n\n");
    }

    public static void main(String[] args) {
        Integer[] levelOrderTree = new Integer[]{1, 2, 3, 4, 5};
        Integer[] levelOrderSubtree = new Integer[]{2, 4, 5};
        solve(levelOrderTree, levelOrderSubtree);

        levelOrderTree = new Integer[]{1, 2, 3, 4, 5, null, null, 6};
        levelOrderSubtree = new Integer[]{2, 4, 5};
        solve(levelOrderTree, levelOrderSubtree);
    }

}
