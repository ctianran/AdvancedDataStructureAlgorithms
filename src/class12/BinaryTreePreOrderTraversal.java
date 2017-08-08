package class12;

import utility.TreeNode;

/**
 * Created by Tianran on 8/7/2017.
 */
public class BinaryTreePreOrderTraversal {
	public static TreeNode firstNode(TreeNode root) {
		return root;
	}

	public static TreeNode nextNode(TreeNode cur) {
		if(cur == null) {
			return null;
		}
		if(cur.left != null) {
			return cur.left;
		}
		if(cur.right != null) {
			return cur.right;
		}
		while(cur.parent != null && (cur.parent.right == cur || cur.parent.right == null)) {
			cur = cur.parent;
		}
		if(cur.parent == null) {
			return null;
		}
		return firstNode(cur.parent.right);
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.parent = n1;
		n3.parent = n1;
		n2.left = n4;
		n2.right = n5;
		n4.parent = n2;
		n5.parent = n2;

		TreeNode cur = firstNode(n1);
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = nextNode(cur);
		}
	}
}
