package dsa.binayTree.traversal;


import dsa.util.Print;
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

    private static void solve(Integer[] levelOrder) {
        TreeNode root = TreeNode.createBinaryTreeViaLevelOrder(levelOrder);
        System.out.println("INPUT: ");
        Print.printTree(root);
        System.out.println("PREORDER: " + preorder(root) + "\n\n");
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
