package problems;

import problems.dto.TreeNode;

public class RangeSumOfBst_938 {

	public int rangeSumBST(TreeNode root, int L, int R) {
		int sum = 0;
		if (root == null) return 0;
		if (root.val >= L && root.val <= R) {
			sum = root.val;
		}

		if (root.val >= L || root.val >= R) {
			sum += rangeSumBST(root.left, L, R);
		}

		if (root.val <= R || root.val <= L) {
			sum += rangeSumBST(root.right, L, R);
		}
		return sum;
	}

	public int rangeSumBST_Brute(TreeNode root, int L, int R) {
		int sum = 0;
		if (root == null) return 0;
		if (root.val >= L && root.val <= R) {
			sum = root.val;
		}
		sum += rangeSumBST_Brute(root.left, L, R) + rangeSumBST_Brute(root.right, L, R);
		return sum;
	}


	private TreeNode root;

	private void put(int value) {
		root = put(root, value);
	}

	private TreeNode put(TreeNode node, int value) {
		if (node == null) return new TreeNode(value);
		if (value < node.val) {
			node.left = put(node.left, value);
		} else if (value > node.val) {
			node.right = put(node.right, value);
		} else {
			node.val = value;
		}
		return node;
	}

	/**
	 * Example 1:
	 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
	 * Output: 32
	 */
	public void init() {
		root = null;
		put(10);
		put(5);
		put(15);
		put(3);
		put(7);
		put(18);
		System.out.println(rangeSumBST(root, 7, 15));
	}

	/**
	 * Example 2:
	 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
	 * Output: 23
	 */
	public void init2() {
		root = null;
		put(10);
		put(5);
		put(15);
		put(3);
		put(7);
		put(13);
		put(18);
		put(1);
		put(6);
		System.out.println(rangeSumBST(root, 6, 10));
	}
}
