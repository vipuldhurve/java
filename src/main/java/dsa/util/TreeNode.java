package dsa.util;


import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode createBinaryTreeViaLevelOrder(Integer[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) return null;

//        Create root node from 1st element in array and add in queue
        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < levelOrder.length) {
            TreeNode current = queue.poll();
//            Check for left node
            if (levelOrder[i] != null) {
                current.left = new TreeNode(levelOrder[i]);
                queue.add(current.left);
            }
            i++;
//            Check for right node
            if (i < levelOrder.length && levelOrder[i]!=null){
                current.right = new TreeNode(levelOrder[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}
