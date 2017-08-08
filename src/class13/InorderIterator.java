package class13;

import utility.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Tianran on 8/7/2017.
 */
public class InorderIterator {
	Deque<TreeNode> stack;
	public InorderIterator(TreeNode root) {
		stack = new LinkedList<>();
		pushLeft(root);
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		if(!hasNext()) {
			throw new NoSuchElementException("No such element");
		}
		TreeNode cur = stack.pollFirst();
		pushLeft(cur.right);
		return cur.val;
	}

	private void pushLeft(TreeNode cur) {
		while(cur != null) {
			stack.offerFirst(cur);
			cur = cur.left;
		}
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

		InorderIterator iter = new InorderIterator(n1);

		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
