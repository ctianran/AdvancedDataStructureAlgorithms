package class10;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 7/25/2017.
 */
public class LongestSubArrayAverageLessThanTarget {
	public int longestAverage(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		//pre-process, all the element - target
		int[] array = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			array[i] = nums[i] - target;
		}

		//prefix sum for the processed array
		int[] prefix = new int[array.length + 1];
		for(int i = 1; i < prefix.length; i++) {
			prefix[i] = prefix[i-1] + array[i-1];
		}

		//iterate prefixSum array from right to left, get elements in monotonically decreasing order,
		//and store the indices
		List<Integer> listR = new ArrayList<>();
		int cur = prefix.length -1;
		for(int i = cur - 1; i >= 0; i--) {
			if(prefix[cur] > prefix[i]) {
				listR.add(cur);
				cur = i;
			}
		}
		//Collections.reverse(listR);
		//iterate prefixSum array from left to right, get elements in monotonically increasing order,
		//and store the indices
		List<Integer> listL = new ArrayList<>();
		cur = 0;
		for(int i = cur + 1; i < prefix.length - 1; i++) {
			if(prefix[cur] < prefix[i]) {
				listL.add(cur);
				cur = i;
			}
 		}

 		//get the longest subarray sum in two sorted array
		return helper(prefix, listL, listR);
	}

	private int helper(int[] prefix, List<Integer> listL, List<Integer> listR) {
		int i = 0;
		int j = listR.size() - 1;
		int res = 0;
		while(i < listL.size() && j >= 0) {
			int left = listL.get(i);
			int right = listR.get(j);
			if(prefix[right] - prefix[left] < 0) {
				res = Math.max(res, right - left);
				j--;
			} else {
				i++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, -3, 6, -2, -2, 2};
		LongestSubArrayAverageLessThanTarget sol = new LongestSubArrayAverageLessThanTarget();
		int res = sol.longestAverage(nums, 0);
		System.out.println(res);
	}
}
