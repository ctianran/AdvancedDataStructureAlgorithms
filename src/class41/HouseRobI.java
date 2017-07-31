package class41;

/**
 * Created by Tianran on 7/30/2017.
 *
 *
 */
public class HouseRobI {
	//with possible negative values
	//must include the amount at index i
	//Time: O(n^2)
	//Space: O(n)

	public int robI(int[] nums) {
		if(nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = nums[1];
		for(int i = 2; i < nums.length; i++) {
			dp[i] = nums[i];
			for(int j = 0; j < i - 1; j++) {
					dp[i] = Math.max(dp[i], dp[j] + nums[i]);
			}
		}
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	//Time: O(n)
	//Space: O(n)
	//largest amount robbed from 0 to i, may or may not include i
	//dp[i] = Max(dp[i-2] + nums[i], dp[i-1])
	public int robII(int[] nums) {
		if(nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
		}
		return dp[nums.length - 1];
	}

	//Time: O(n)
	//Space: O(1)
	public int robIII(int[] nums) {
		if(nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		int num1 = nums[0];
		int num2 = Math.max(nums[0], nums[1]);
		for(int i = 2; i < nums.length; i++) {
				int cur = Math.max(num2, num1 + nums[i]);
				num1 = num2;
				num2 = cur;
		}
		return num2;
	}

	//with non-negative values;
	//dp[i] = max(dp[i-2], dp[i-3]) + nums[i];
	//i-3, i-2, i-1, i
	public int robIV(int[] nums) {
		if(nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		//base case
		if(nums.length == 1) {
			return nums[0];
		}
		if(nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int num0 = nums[0];
		int num1 = Math.max(nums[0], nums[1]);
		int num2 = nums[0] + nums[2];
		for(int i = 3; i < nums.length; i++) {
			int temp = Math.max(nums[i-2], nums[i-3]) + nums[i];
			num0 = num1;
			num1 = num2;
			num2 = temp;
		}
		return Math.max(num1, num2);
	}
}
