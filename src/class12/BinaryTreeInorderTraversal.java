package class12;


import utility.TreeNode;

/**
 * Created by Tianran on 8/6/2017.
 */
public class BinaryTreeInorderTraversal {

	public static TreeNode firstNode(TreeNode root) {
		if(root == null) {
			return null;
		}
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}

	public static TreeNode nextNode(TreeNode cur) {
		if(cur == null) {
			return null;
		}
		//case1: current node has right subtree
		if(cur.right != null) {
			return firstNode(cur.right);
		}
		//case2: current node does not have right subtree, then we need to trace back to parents
		while(cur.parent != null && cur.parent.left != cur) {
			cur = cur.parent;
		}
		return cur.parent;
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
