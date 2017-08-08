package class13;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tianran on 8/7/2017.
 */
public class SecondLargestNodeInBST {
	public List<Integer> reverseInorder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.offerFirst(cur);
				cur = cur.right;
			} else {
				cur = stack.pollFirst();
				res.add(cur.val);
				cur = cur.left;
			}
		}
		return res;
	}
	//Method1: reverse inorder traversal and use count to get the second largest number
	public int secondLargest(TreeNode root) {
		if(root == null || root.left == null && root.right == null) {
			return Integer.MIN_VALUE;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		int count = 0;
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.offerFirst(cur);
				cur = cur.right;
			} else {
				cur = stack.pollFirst();
				count++;
				if(count == 2) {
					return cur.val;
				}
				cur = cur.left;
			}
		}
		return Integer.MIN_VALUE;
	}
	//Method2: use parent pointer implement firstNode() and nextNode() in reverse inorder.
	//return nextNode(firstNode()) -> second largest
	public static TreeNode firstNode(TreeNode root) {
		if(root == null) {
			return null;
		}
		while(root.right != null) {
			root = root.right;
		}
		return root;
	}

	public static TreeNode nextNode(TreeNode cur) {
		if(cur == null) {
			return null;
		}
		if(cur.left != null) {
			return firstNode(cur.left);
		}
		while(cur.parent != null && cur.parent.right != cur) {
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

		SecondLargestNodeInBST sol = new SecondLargestNodeInBST();
		List<Integer> res = sol.reverseInorder(n1);
		System.out.println(res);

		int secondLargest = sol.secondLargest(n1);
		System.out.println(secondLargest);

		System.out.println(nextNode(firstNode(n1)).val);
	}
}
