package class13;

import utility.TreeNode;

/**
 * Created by Tianran on 8/7/2017.
 */
public class InorderIteratorII {

	public static TreeNode firstNode(TreeNode root) {
		if(root == null) {
			return root;
		}
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}

	public static TreeNode next(TreeNode cur) {
		if(cur == null) {
			return cur;
		}
		if(cur.right != null) {
			return firstNode(cur.right);
		}
		while(cur.parent != null && cur.parent.left != cur) {
			cur = cur.parent;
		}
		return cur.parent;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n2.parent = n1;
		n3.parent = n1;
		n2.right = n4;
		n4.parent = n2;
		n3.left = n5;
		n5.parent = n3;

		InorderIteratorII iter = new InorderIteratorII();
		TreeNode cur = iter.firstNode(n1);
		while(cur != null) {
			System.out.println(cur.val);
			cur = iter.next(cur);
		}
	}
}
