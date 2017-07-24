package class9;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tianran on 7/24/2017.
 */
public class NumberOfSubArraySumEqualTarget {
	public int countSubArrays(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int res = 0;
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int temp = sum - target;
			if(map.containsKey(temp)) {
				res += map.get(temp);
			}
			Integer count = map.get(sum);
			if(count == null) {
				map.put(sum, 1);
			} else {
				map.put(sum, count + 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {2, 2, 2};
		NumberOfSubArraySumEqualTarget sol = new NumberOfSubArraySumEqualTarget();
		int res = sol.countSubArrays(nums, 4);
		System.out.println(res);
	}
}
