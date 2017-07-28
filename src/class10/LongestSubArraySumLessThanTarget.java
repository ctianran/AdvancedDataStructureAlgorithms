package class10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tianran on 7/25/2017.
 */
public class LongestSubArraySumLessThanTarget {
	//Time: O(n^2)
	public int longest(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int[] prefix = new int[nums.length + 1];
		for(int i = 1; i < prefix.length; i++) {
			prefix[i] = prefix[i-1] + nums[i-1];
		}

		int res = Integer.MIN_VALUE;
		for(int j = 0; j < prefix.length; j++) {
			for(int i = 0; i < j; i++) {
				if(prefix[j] - prefix[i] < target) {
					res = Math.max(res, j - i);
					break;
				}
			}
		}
		return res;
	}
	//optimization Time: O(n)
	public int longestI(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		//get prefix sum for the input array
		int[] prefix = new int[nums.length + 1];
		for(int i = 1; i < prefix.length; i++) {
			prefix[i] = prefix[i - 1] + nums[i - 1];
		}

		//iterate from right to left, get the elements in monotonically decreasing, store the indices
		List<Integer> list1 = new ArrayList<>();
		int cur = prefix.length - 1;
		for(int i  = cur - 1; i >= 0; i--) {
			if(prefix[cur] > prefix[i]) {
				list1.add(cur);
				cur = i;
			}
		}
		Collections.reverse(list1);
		//iterate from left to right, get the elements in monotonically increasing, store the indices
		List<Integer> list2 = new ArrayList<>();
		cur = 0;
		for(int i = cur + 1; i < prefix.length; i++) {
			if(prefix[cur] < prefix[i]) {
				list2.add(cur);
				cur = i;
			}
		}
		//get the longest subarray sum, in sorted arrays.
		return helper(prefix, list1, list2, target);
	}

	private int helper(int[] prefix, List<Integer> list1, List<Integer> list2, int target) {
		int i = 0;
		int j = 0;
		int res = 0;
		while(j < list1.size() && i < list2.size()) {
			if(prefix[list1.get(j)] - prefix[list2.get(i)] < target) {
				res = Math.max(res, list1.get(j) - list2.get(i));
				j++;
			} else {
				i++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, -3, 6, -2, -2, 2};
		LongestSubArraySumLessThanTarget sol = new LongestSubArraySumLessThanTarget();
		int res = sol.longest(nums, 0);
		int res1 = sol.longestI(nums, 0);
		System.out.println(res);
		System.out.println(res1);
	}
}
