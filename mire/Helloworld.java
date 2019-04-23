// import java.util.Scanner;

public class Helloworld {
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		scanTest();
	}
	public static void scanTest() {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println(Prime.isPrime(scan.nextInt()) ? "素数です！" : "合成数です！");
		scan.close();
	}
}
