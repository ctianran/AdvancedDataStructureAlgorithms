package class9;

import java.util.TreeSet;

/**
 * Created by Tianran on 7/24/2017.
 */
public class ClosestSubArraySum {
	public int closest(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(0);
		int sum = 0;
		int diff = Math.abs(nums[0] - target);
		int res = nums[0];
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int temp = sum - target;
			if(treeSet.ceiling(temp) != null) {
				int high = treeSet.ceiling(temp);
				if(Math.abs(target - (sum - high)) < diff) {
					diff = Math.abs(target - (sum - high));
					res = sum - high;
				}
			}
			if(treeSet.floor(temp) != null) {
				int low = treeSet.floor(temp);
				if(Math.abs(target - (sum - low)) < diff) {
					diff = Math.abs(target - (sum - low));
					res = sum - low;
				}
			}
			treeSet.add(sum);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {2, 2, 5};
		ClosestSubArraySum sol = new ClosestSubArraySum();
		int res = sol.closest(nums, 10);
		System.out.println(res);
	}
}
