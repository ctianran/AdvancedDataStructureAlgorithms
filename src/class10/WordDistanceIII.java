package class10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 7/28/2017.
 */
public class WordDistanceIII {
	//Time: O(n)
	//Space: O(k)
	public int shortestDistance(String[] dict, List<String> words) {
		Map<String, Integer> map = new HashMap<>();
		for(String s : words) {
			map.put(s, 0);
		}
		int slow = 0;
		int nonZero = 0;
		int res = Integer.MAX_VALUE;
		for(int fast = 0; fast < dict.length; fast++) {
			//add current fast to sliding window
			Integer fastCount = map.get(dict[fast]);
			if(fastCount == null) {
				continue;
			}
			if(fastCount == 0) {
				nonZero++;
			}
			map.put(dict[fast], fastCount + 1);

			//move slow
			while(nonZero == map.size()) {
				//update solution
				res = Math.min(res, fast - slow);
				//remove slow from the sliding window
				Integer slowCount = map.get(dict[slow]);
				if(slowCount != null) {
					if(slowCount == 1) {
						nonZero--;
					}
					map.put(dict[slow], slowCount - 1);
				}
				slow++;
			}
		}
		return res;
	}


}
