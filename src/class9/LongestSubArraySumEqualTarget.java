package class9;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 7/24/2017.
 */
public class LongestSubArraySumEqualTarget {
	public int longest(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int temp = sum - target;
			if(map.containsKey(temp)) {
				res = Math.max(res, i - map.get(temp));
			}
			//earliest position
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return res == Integer.MIN_VALUE ? 0 : res;
	}
}
