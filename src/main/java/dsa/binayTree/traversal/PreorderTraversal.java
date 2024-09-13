package dsa.binayTree.traversal;


import dsa.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
//             1
//            / \
//           2   3
//         /  \
//        4    5
//            / \
//           6   7
//    Node Left Right -> 1 2 4 5 6 7 3
    public static List<Integer> preorder(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) return preOrder;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            preOrder.add(temp.val);
            if (temp.right != null) st.push(temp.right);
            if (temp.left != null) st.push(temp.left);
        }
        return preOrder;
    }

    public static void main(String[] args) {
        System.out.println("---- Case 1");
        Integer[] binaryTree = {1, 2, 3, 4, 5, null, null, null, null, 6, 7};
        TreeNode root = TreeNode.createBinaryTreeViaLevelOrder(binaryTree);
        System.out.println(preorder(root) + "\n");

        System.out.println("---- Case 2");
        binaryTree = new Integer[]{};
        root = TreeNode.createBinaryTreeViaLevelOrder(binaryTree);
        System.out.println(preorder(root) + "\n");

        System.out.println("---- Case 3");
        binaryTree = new Integer[]{2, null, 3};
        root = TreeNode.createBinaryTreeViaLevelOrder(binaryTree);
        System.out.println(preorder(root) + "\n");
    }

}
