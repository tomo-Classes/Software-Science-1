public class Prime {
	public static void main(String[] args) {
		System.out.println(isPrime(2356127));
	}
	public static boolean isPrime(int n) {
		if(n < 2) return false;
		boolean result = true;
		for(int i = 2; i < Math.ceil(Math.sqrt(n)); i++) {
			if(n % i == 0) result = false;
		}
		return result;
	}
}
