package class41;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tianran on 7/31/2017.
 */
public class ShortestSumOfSquaresToTarget {
	public List<Integer> shortestList(int n) {
		int[] dp = new int[n + 1];
		int[] back = new int[n + 1];
		dp[0] = 0;
		for(int i = 1; i <= n; i++) {
			dp[i] = i;
			for(int j = 1; j * j <= i; j++) {
				if(dp[i - j * j] + 1 < dp[i]) {
					back[i] = j;
					dp[i] = dp[i - j * j] + 1;
				}
			}
		}

		List<Integer> res = new ArrayList<>();
		while(n > 0) {
			res.add(back[n]);
			n -= back[n] * back[n];
		}
		return res;
	}

	public static void main(String[] args) {
		ShortestSumOfSquaresToTarget sol = new ShortestSumOfSquaresToTarget();
		List<Integer> res = sol.shortestList(18);
		System.out.println(res);
	}
}
