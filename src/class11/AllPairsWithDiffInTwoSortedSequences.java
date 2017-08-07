package class11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tianran on 8/4/2017.
 */
public class AllPairsWithDiffInTwoSortedSequences {
	//Time: O(m + n) moving the sliding window

	public List<List<Integer>> allPairs(double[] nums1, double[] nums2) {
		List<List<Integer>> res = new ArrayList<>();
		int fast = 0;
		int slow = 0;
		for(int i = 0; i < nums2.length; i++) {
			while(slow < nums1.length && nums1[slow] <= nums2[i] - 1) {
				slow++;
			}
			while(fast < nums1.length && nums1[fast] <= nums2[i] + 1) {
				fast++;
			}
			for(int j = slow; j < fast; j++) {
				res.add(Arrays.asList(j, i));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		AllPairsWithDiffInTwoSortedSequences sol = new AllPairsWithDiffInTwoSortedSequences();
		double[] nums1 = new double[] {0.1, 0.4, 1.2};
		double[] nums2 = new double[] {1.5, 1.8};
		List<List<Integer>> res = sol.allPairs(nums1, nums2);
		System.out.println(res);
	}
}
