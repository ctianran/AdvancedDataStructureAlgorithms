package class11;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tianran on 8/4/2017.
 */
public class SubStringsWithoutDuplicates {
	public int countSubstrings(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		Set<Character> set = new HashSet<>();
		int slow = 0;
		int fast = 0;
		int res = 0;
		while(fast < s.length()) {
			//find the corresponding slow for the current fast pointer
			if(set.contains(s.charAt(fast))){
				set.remove(s.charAt(slow++));
			} else {
				set.add(s.charAt(fast++));
				res += fast - slow;
			}
		}
		return res;
	}
	//with optimization
	public int countSubstringsI(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		Set<Character> set = new HashSet<>();
		int slow = 0;
		int fast = 0;
		int res = 0;
		while(fast < s.length()) {
			//find the corresponding slow for the current fast pointer
			if(!set.add(s.charAt(fast))) {
				while(s.charAt(slow) != s.charAt(fast)) {
					set.remove(s.charAt(slow++));
				}
				slow++;
			}
			fast++;
			res += fast - slow;
		}
		return res;
	}
	public static void main(String[] args) {
		SubStringsWithoutDuplicates sol = new SubStringsWithoutDuplicates();
		String s = "abbc";
		int res = sol.countSubstringsI(s);
		System.out.println(res);
	}
}
