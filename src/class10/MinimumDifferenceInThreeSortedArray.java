package class10;

/**
 * Created by Tianran on 7/28/2017.
 */
public class MinimumDifferenceInThreeSortedArray {
	public int minDiff(int[] arr1, int[] arr2, int[] arr3) {
		int i = 0;
		int j = 0;
		int k = 0;
		int res = Integer.MAX_VALUE;
		while(i < arr1.length && j < arr2.length && k < arr3.length) {
			int num1 = arr1[i];
			int num2 = arr2[j];
			int num3 = arr3[k];
			int min = Math.min(num1, Math.min(num2, num3));
			int max = Math.max(num1, Math.max(num2, num3));
			res = Math.min(res, max - min);

			if(num1 <= num2 && num1 <= num3) {
				i++;
			} else if (num2 <= num1 && num2 <= num3) {
				j++;
			} else {
				k++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr1 = new int[]{1, 3, 5};
		int[] arr2 = new int[]{2, 4, 6};
		int[] arr3 = new int[]{3, 7, 9};

		MinimumDifferenceInThreeSortedArray sol = new MinimumDifferenceInThreeSortedArray();
		int res = sol.minDiff(arr1, arr2, arr3);
		System.out.println(res);
	}
}
