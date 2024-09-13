package dsa.binayTree.traversal;


import dsa.util.Print;
import dsa.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    //             1
//            / \
//           2   3
//         /  \
//        4    5
//            / \
//           6   7
//    Left Node Right -> 4 2 6 5 7 1 3
    public static List<Integer> inorder(TreeNode node) {
        List<Integer> inorder = new ArrayList<>();
        if (node == null) return inorder;

        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;
                TreeNode temp = stack.pop();
                inorder.add(temp.val);
                if (temp.right != null) stack.push(temp.right);
            }
        }
        return inorder;
    }

    private static void solve(Integer[] levelOrder) {
        TreeNode root = TreeNode.createBinaryTreeViaLevelOrder(levelOrder);
        System.out.println("INPUT: ");
        Print.printTree(root);
        System.out.println("INORDER: " + inorder(root) + "\n\n");
    }

    public static void main(String[] args) {
        Integer[] levelOrder = {1, 2, 3, 4, 5, null, null, null, null, 6, 7};
        solve(levelOrder);

        levelOrder = new Integer[]{};
        solve(levelOrder);

        levelOrder = new Integer[]{2, null, 3};
        solve(levelOrder);
    }

}
