package class9;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 7/24/2017.
 *
 * Given array with possible negative integers, find the shortest subarray of which the sum == target
 * e.g nums = [3, 0, -1, -3, 4], target = 3
 *
 * prefixSum = [3, 3, 2, -1, 3]
 */
public class ShortestSubArraySumEqualTarget {
	public int shortest(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int temp = sum - target;
			if(map.containsKey(temp)) {
				res = Math.min(res, i - map.get(temp));
			}
			map.put(sum, i);
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
