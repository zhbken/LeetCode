package problems;

import problems.dto.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 */
public class MaximumDepthOfBinaryTree_104 {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
		return 1 + (l > r ? l : r);
	}

	/**
	 * Example:
	 * Given binary tree [3,9,20,null,null,15,7],
	 *
	 *     3
	 *    / \
	 *   9  20
	 *     /  \
	 *    15   7
	 * return its depth = 3.
	 */
	public void testCase() {
		TreeNode t1 = new TreeNode(3);
		t1.left = new TreeNode(9);
		t1.right = new TreeNode(20);
		t1.right.left = new TreeNode(15);
		t1.right.right = new TreeNode(7);
		System.out.println(maxDepth(t1));
	}
}
