import java.util.Random;

public class HeapSort {
	public static void main(String[] args) {
		for(int k = 0; k < 100; k++) {
			int n = 100000;
			int x[] = new int[n];
			Random rand = new Random(100);
			for(int i = 0; i < n; i++) {
				x[i] = rand.nextInt(1000000);
			}
			long start = System.currentTimeMillis();
			sort(x);
			long stop = System.currentTimeMillis();
			System.out.print((stop - start) + ",");
		}
	}
	public static int[] sort(int[] array) {
		int i = 0;
		while(++i < array.length) {
			upheap(array, i);
		}
		while(--i > 0) {
			swap(array, 0, i);
			downheap(array, i);
		}
		return array;
	}
	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	private static void upheap(int[] array, int n) {
		while(n > 0) {
			int m = parent(n);

			if(array[m] < array[n]) {
				swap(array, m, n);
			} else {
				break;
			}

			n = m;
		}
	}
	private static void downheap(int[] array, int n) {
		int m = 0;
		int tmp = 0;

		while(true) {
			int l_chld = left_child(m);
			int r_chld = right_child(m);

			if(l_chld >= n) {
				break;
			}

			if(array[l_chld] > array[tmp]) {
				tmp = l_chld;
			}
			if((r_chld < n) && (array[r_chld] > array[tmp])) {
				tmp = r_chld;
			}

			if(tmp == m) {
				break;
			}
			swap(array, tmp, m);

			m = tmp;
		}
	}
	private static int left_child(int i) {
		return (((i) + 1) * 2 - 1);
	}
	private static int right_child(int i) {
		return (((i) + 1) * 2);
	}
	private static int parent(int i) {
		return (((i) + 1) / 2 - 1);
	}
	
	// debug
	private static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(i != 0)
				System.out.print(", ");
			System.out.print(array[i]);
		}
		System.out.println("");
	}
}
