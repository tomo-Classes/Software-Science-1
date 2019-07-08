import java.util.Random;
public class BubbleSort{
	public static void main(String[] args){
		for(int k = 1; k <= 100; k++){
			int n = 100000;
			int x[] = new int[n];
			Random rand = new Random(100);
			for(int i = 0; i < n; i++){
				x[i] = rand.nextInt(1000000);
			}
			long start = System.currentTimeMillis();
			for(int i = 0; i < n - 1; i++){
				for(int j = n - 1; j > i; j--){
					if(x[j] < x[j - 1]){
						int t = x[j];
						x[j] = x[j - 1];
						x[j - 1] = t;
					}
				}
			}
			long stop = System.currentTimeMillis();
			System.out.print((stop - start) + ",");
		}
	}
}
