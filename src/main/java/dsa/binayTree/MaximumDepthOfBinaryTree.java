package dsa.binayTree;

import dsa.util.Printer;
import dsa.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
//    Given the root of a binary tree, return its depth.
//    The depth of a binary tree is defined as the number of nodes along the longest path
//    from the root node down to the farthest leaf node.

    private static int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
    }

    private static int maxDepthLevelOrderTraversal(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {
//            Number of nodes at current level
            int levelSize = queue.size();
//            Increment depth for each level
            depth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
//                Add left and right child to queue if exist
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }

    private static void solve(Integer[] levelOrder){
        System.out.println("INPUT");
        TreeNode root = TreeNode.createBinaryTreeViaLevelOrder(levelOrder);
        Printer.printBinaryTree(root);
        System.out.println("OUTPUT: " + maxDepthLevelOrderTraversal(root) + "\n\n");
    }

    public static void main(String[] args) {
        Integer[] levelOrder = new Integer[]{1,2,3,null,null,4};
        solve(levelOrder);

        levelOrder = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        solve(levelOrder);

        levelOrder = new Integer[]{1, 2, 3, 4, 5, null, null, null, null, 6, 7};
        solve(levelOrder);

        levelOrder = new Integer[]{3, 2, 1};
        solve(levelOrder);
    }
}
