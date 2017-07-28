package class9;

/**
 * Created by Tianran on 7/24/2017.
 *
 * Given an array containing only positive integers, find the shortest subarray of which the sum > target
 * non-fixed size sliding window
 *
 * e.g.
 *               [1, 3, 2, 2, 4, 1], target = 5
 *
 * prefix sum:[0, 1, 4, 6, 8, 12, 13]
 *     index:  0  1  2  3  4  5   6
 *
 * sol: find the shortest sliding window of index i, j, such that s[j] - s[i] > target
  */
public class ShortestPosSubArraySumGreaterThanTarget {
	public int shortest(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int[] prefix = new int[nums.length + 1];
		for(int i = 1; i <= nums.length; i++) {
			prefix[i] = prefix[i-1] + nums[i-1];
		}
		int res = Integer.MAX_VALUE;
		int slow = 0;
		int fast = 1;
		while(fast < prefix.length) {
			if(prefix[fast] - prefix[slow] > target) {
				res = Math.min(res, fast - slow);
				slow++;
			} else {
				fast++;
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 3, 2, 2, 4, 1};
		ShortestPosSubArraySumGreaterThanTarget sol = new ShortestPosSubArraySumGreaterThanTarget();
		int res = sol.shortest(nums, 5);
		System.out.println(res);
	}
}
