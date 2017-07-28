package class10;

/**
 * Created by Tianran on 7/26/2017.
 */
public class WordDistanceI {
	public int shortestDistance(String[] words, String word1, String word2) {
		if(words == null || words.length <= 1) {
			return 0;
		}
		int pos1 = -1;  //most recent position for word1
		int pos2 = -1;  //most recent position for word2
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)) {
				pos1 = i;
			}
			if(words[i].equals(word2)) {
				pos2 = i;
			}
			if(pos1 != -1 && pos2 != -1) {
				res = Math.min(res, Math.abs(pos1 - pos2));
			}
		}
		return res;
	}
}
