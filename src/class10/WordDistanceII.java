package class10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianran on 7/26/2017.
 */
public class WordDistanceII {
	Map<String, List<Integer>> map;
	public WordDistanceII(String[] words) {
		map = new HashMap<>();
		for(int i = 0; i < words.length; i++) {
			List<Integer> list = map.get(words[i]);
			if(list == null) {
				list = new ArrayList<>();
			}
			list.add(i);
			map.put(words[i], list);
		}
	}

	public int getDistance(String word1, String word2) {
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		if(list1 == null || list2 == null) {
			return 0;
		}
		int i = 0;
		int j = 0;
		int res = Integer.MAX_VALUE;
		while(i < list1.size() && j < list2.size()) {
			res = Math.min(res, Math.abs(list1.get(i) - list2.get(j)));
			if(list1.get(i) < list2.get(j)) {
				i++;
			} else {
				j++;
			}
		}
		return res;
	}
}

