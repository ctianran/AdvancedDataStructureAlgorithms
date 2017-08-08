package class12;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tianran on 8/7/2017.
 */
public class BinaryTreePostOrderTraversal {
	//Method1: use stack
	public List<Integer> postOrder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		TreeNode prev = null;
		while(!stack.isEmpty()) {
			TreeNode cur = stack.peekFirst();
			if(prev == null || cur == prev.left || cur == prev.right) {
				if(cur.left != null) {
					stack.offerFirst(cur.left);
				} else if (cur.right != null) {
					stack.offerFirst(cur.right);
				} else {
					stack.pollFirst();
					res.add(cur.val);
				}
			} else if (prev == cur.left && cur.right == null || prev == cur.right) {
					stack.pollFirst();
					res.add(cur.val);
			} else {
					stack.offerFirst(cur.right);
			}
			prev = cur;
		}
		return res;
	}

	//Method2: use parent pointer
	public static TreeNode firstNode(TreeNode root) {
		if(root == null) {
			return null;
		}
		while(root.left != null || root.right != null) {
			if(root.left != null) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return root;
	}

	public static TreeNode nextNode(TreeNode cur) {
		if(cur == null) {
			return null;
		}
		if(cur.parent == null) {
			return null;
		}
		if(cur.parent.left == cur) {
			return cur.parent.right == null ? cur.parent : firstNode(cur.parent.right);
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

		BinaryTreePostOrderTraversal sol = new BinaryTreePostOrderTraversal();
		List<Integer> res = sol.postOrder(n1);
		System.out.println(res);
	}
}
