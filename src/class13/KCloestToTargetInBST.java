package class13;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tianran on 8/8/2017.
 */
public class KCloestToTargetInBST {
	//with parent pointer
	//Time: O(logn + k)
	public List<Integer> kClosest(TreeNode root, int target, int k) {
		List<Integer> res = new ArrayList<>();
		if(root == null || k <= 0) {
			return res;
		}
		TreeNode closest = getClosest(root, target);
		if(closest == null) {
			return res;
		}
		res.add(closest.val);
		TreeNode left = prevNode(closest);
		TreeNode right = nextNode(closest);
		while(k > 1) {
			if(left == null) {
				res.add(right.val);
				right = nextNode(right);
			} else if (right == null) {
				res.add(left.val);
				left = prevNode(left);
			} else if (Math.abs(left.val - target) <= Math.abs(right.val - target)) {
				res.add(left.val);
				left = prevNode(left);
			} else {
				res.add(right.val);
				right = nextNode(right);
			}
			k--;
		}
		return res;
	}

	private TreeNode getClosest(TreeNode root, int target) {
		TreeNode res = root;
		TreeNode cur = root;
		while(cur != null) {
			if(cur.val == target) {
				return cur;
			} else {
				if(Math.abs(cur.val - target) < Math.abs(res.val - target)) {
					res = cur;
				}
				if(cur.val < target) {
					cur = cur.right;
				} else {
					cur = cur.left;
				}
			}
		}
		return res;
	}

	private TreeNode nextNode(TreeNode cur) {
		if(cur == null) {
			return null;
		}
		if(cur.right != null) {
			TreeNode temp = cur.right;
			while(temp.left != null) {
				temp = temp.left;
			}
			return temp;
		}

		while(cur.parent != null && cur.parent.left != cur) {
			cur = cur.parent;
		}
		return cur.parent;
	}

	private TreeNode prevNode(TreeNode cur) {
		if(cur == null) {
			return null;
		}
		if(cur.left != null) {
			TreeNode temp = cur.left;
			while(temp.right != null) {
				temp = temp.right;
			}
			return temp;
		}
		while(cur.parent != null && cur.parent.right != cur) {
			cur = cur.parent;
		}
		return cur.parent;
	}

	//without parent pointer, use two stacks
	//Time: O(n + k)
	public List<Integer> kClosestII(TreeNode root, int target, int k) {
		List<Integer> res = new ArrayList<>();
		if(root == null || k <= 0) {
			return res;
		}
		Deque<Integer> s1 = new LinkedList<>();
		Deque<Integer> s2 = new LinkedList<>();

		inorder(root, target, s1);  // predecessor
		inorderRev(root, target, s2); //successor

		while(k > 0) {
			if(s1.isEmpty()) {
				res.add(s2.pollFirst());
			} else if(s2.isEmpty()) {
				res.add(s1.pollFirst());
			} else if(Math.abs(s1.peekFirst() - target) <= Math.abs(s2.peekFirst() - target)) {
				res.add(s1.pollFirst());
			} else {
				res.add(s2.pollFirst());
			}
			k--;
		}
		return res;
	}

	private void inorder(TreeNode root, int target, Deque<Integer> stack) {
		if(root == null) {
			return;
		}
		inorder(root.left, target, stack);
		if(root.val > target) {
			return;
		}
		stack.offerFirst(root.val);
		inorder(root.right, target, stack);
	}

	private void inorderRev(TreeNode root, int target, Deque<Integer> stack) {
		if(root == null) {
			return;
		}
		inorderRev(root.right, target, stack);
		if(root.val <= target) {
			return;
		}
		stack.offerFirst(root.val);
		inorderRev(root.left, target, stack);
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(10);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.parent = n1;
		n3.parent = n1;
		n2.right = n4;
		n4.parent = n2;
		n3.left = n5;
		n5.parent = n3;

		KCloestToTargetInBST sol = new KCloestToTargetInBST();
		List<Integer> res = sol.kClosest(n1, 4, 3);
		List<Integer> res2 = sol.kClosestII(n1, 4, 3);
		System.out.println(res);
		System.out.println(res2);
	}
}
