package class9;

/**
 * Created by Tianran on 7/24/2017.
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
				fast++;
			} else {
				slow++;
			}
		}

		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
