// import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 4, 1, 2, 3, 4 };
		Integer[] result = sum(array);
		for(int n: result) {
			System.out.println(n);
		}
	}
	public static Integer[] sum(Integer[] arr) {
		// int k = 0;
		// for(int n: arr) {
		// 	System.out.println(String.valueOf(k) + ": " + String.valueOf(n));
		// 	k++;
		// }		
		if(arr.length <= 1) return arr;
		int half = (int)Math.floor(arr.length / 2) + (arr.length % 2);
		// System.out.println(Math.ceil(arr.length / 2));
		Integer[] result = new Integer[half];
		for(int i = 0; i < half; i++) {
			if(i * 2 + 1 == arr.length) {
				result[i] = arr[i * 2];
			} else {
				result[i] = arr[i * 2] + arr[i * 2 + 1];
			}
		}
		return sum(result);
	}
}
