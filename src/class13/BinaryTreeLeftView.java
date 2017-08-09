package class13;

import utility.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Tianran on 8/8/2017.
 */
public class BinaryTreeLeftView {
	//Method1: BFS
	//Time: O(n)
	public List<Integer> leftView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			res.add(queue.peek().val);
			for(int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if(cur.left != null) {
					queue.offer(cur.left);
				}
				if(cur.right != null) {
					queue.offer(cur.right);
				}
			}
		}
		return res;
	}

	//Method2: DFS
	public List<Integer> leftViewII(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		helper(root, 0, res);
		return res;
	}

	private void helper(TreeNode root, int level, List<Integer> res) {
		if(root == null) {
			return;
		}
		if(level == res.size()) {
			res.add(root.val);
		}
		helper(root.left, level + 1, res);
		helper(root.right, level + 1, res);
	}
	
}
