package problems;

import problems.dto.TreeNode;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 */
public class MergeTwoBinaryTrees_617 {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		return merge(null, t1, t2);
	}

	private TreeNode merge(TreeNode node, TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) return node;
		if (node == null) {
			node = new TreeNode();
		}

		if (t1 != null && t2 != null) {
			node.val = t1.val + t2.val;
			node.left = merge(node.left, t1.left, t2.left);
			node.right = merge(node.right, t1.right, t2.right);
		} else if (t1 != null) {
			node = t1;
		} else if (t2 != null) {
			node = t2;
		}

		return node;
	}

	/**
	 * Input:
	 * 	Tree 1                     Tree 2
	 *      1                         2
	 *     / \                       / \
	 *    3   2                     1   3
	 *   /                           \   \
	 *  5                             4   7
	 * Output:
	 * Merged tree:
	 * 	     3
	 * 	    / \
	 * 	   4   5
	 * 	  / \   \
	 * 	 5   4   7
	 */
	public void testCase() {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.left.left = new TreeNode(5);
		t1.right = new TreeNode(2);

		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.left.right = new TreeNode(4);
		t2.right = new TreeNode(3);
		t2.right.right = new TreeNode(7);

		TreeNode treeNode = mergeTrees(t1, t2);
		System.out.println(treeNode);
	}
}
