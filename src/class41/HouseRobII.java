package class41;

/**
 * Created by Tianran on 7/30/2017.
 */
public class HouseRobII {
	//break the cycle
	//1. pick nums[0], the search range is: subarray(0, n - 2)
	//2. not pick nums[0], the search rang is: subarray(1, n - 1)
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		//pick nums[0]
		int num1 = helper(nums, 0, nums.length -2);
		//not pick nums[0]
		int num2 = helper(nums, 1, nums.length - 1);

		return Math.max(num1, num2);
	}

	private int helper(int[] nums, int left, int right) {
		int num1 = nums[left];
		int num2 = Math.max(nums[left], nums[left + 1]);
		for(int i = left + 2; i <= right; i++) {
			int temp = Math.max(num1 + nums[i], num2);
			num1 = num2;
			num2 = temp;
		}
		return num2;
	}
}
