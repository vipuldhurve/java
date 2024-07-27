package dsa.binayTree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {
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

    public static void main(String[] args) {
        System.out.println("---- Case 1");
        Integer[] binaryTree = {1, 2, 3, 4, 5, null, null, null, null, 6, 7};
        TreeNode root = TreeNode.createBinaryTree(binaryTree);
        System.out.println(inorder(root));

        System.out.println("---- Case 2");
        binaryTree = new Integer[]{};
        root = TreeNode.createBinaryTree(binaryTree);
        System.out.println(inorder(root));

        System.out.println("---- Case 3");
        binaryTree = new Integer[]{2, null, 3};
        root = TreeNode.createBinaryTree(binaryTree);
        System.out.println(inorder(root));
    }

}
