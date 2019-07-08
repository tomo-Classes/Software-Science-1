// import java.io.BufferedReader;
// import java.io.FileInputStream;
// import java.io.InputStreamReader;
import java.util.Random;

public class BubbleSort {
	public static void main(String[] args) {
		int n = 30000;
		int x[] = new int[n];
		Random rnd = new Random(100);
		for(int i = 0; i < n; i++) {
			x[i] = rnd.nextInt(10000);
		}
		// FileInputStream fi = new FileInputStream("./data.txt");
		// InputStreamReader is = new InputStreamReader(fi);
		// BufferedReader br = new BufferedReader(is);
		// String line;
		// while((line = br.readLine()) != null) {
		// 	String[] arr = line.split(",");
		// 	for(String str: arr) {
		// 		System.out.println(str);
		// 	}
		// }
		long start = System.currentTimeMillis();
		for(int i = 0; i < n - 1; i++) {
			for(int j = n - 1; j > i; j--) {
				int t = x[j];
				x[j] = x[j - 1];
				x[j - 1] = t;
			}
		}
		long stop = System.currentTimeMillis();
		System.out.println("cpu time = " + (stop - start) + "msec");
	}
}
