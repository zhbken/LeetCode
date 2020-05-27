package challenge.may_2020;


import problems.dto.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class CousinsInBinaryTree_993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode xNode = null, yNode = null;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.val == x) {
                    xNode = node;
                } else if (node.val == y) {
                    yNode = node;
                }

                if (node.left != null && node.right != null) {
                    if (node.left.val == x && node.right.val == y) {
                        return false;
                    }

                    if (node.left.val == y && node.right.val == x) {
                        return false;
                    }
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (xNode != null && yNode != null) {
                return true;
            }
            if (xNode != null || yNode != null) return false;
        }

        return false;
    }

    //[1,2,3,null,4,null,5], x = 5, y = 4
    //Output: true
    public void testCase() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);

        System.out.println(isCousins(root, 5, 4));
    }

    //Input: root = [1,2,3,null,4], x = 2, y = 3
    // Output: false
    public void testCase2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);

        System.out.println(isCousins(root, 2, 3));
    }

    //Input: root = [1,2,3,4], x = 4, y = 3
    //Output: false
    public void testCase3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);

        System.out.println(isCousins(root, 4, 3));
    }
}