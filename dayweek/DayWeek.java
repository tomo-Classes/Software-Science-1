import java.util.Scanner;

public class DayWeek {
	private static String[] dow = { "土", "日", "月", "火", "水", "木", "金" };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("年 -> ");
		int y = scanner.nextInt();
		System.out.print("月 -> ");
		int m = scanner.nextInt();
		System.out.print("日 -> ");
		int d = scanner.nextInt();
		scanner.close();
		String date = Integer.toString(y) + "年" + Integer.toString(m) + "月" + Integer.toString(d) + "日";
		System.out.println(date + " " + dow[zeller(y, m, d)] + "曜日");
	}
	public static int zeller(int y, int m, int d) {
		// 参考: https://ja.wikipedia.org/wiki/%E3%83%84%E3%82%A7%E3%83%A9%E3%83%BC%E3%81%AE%E5%85%AC%E5%BC%8F
		if(y < 0)
			y += 1;
		if(m <= 2) {
			y -= 1;
			m += 12;
		}
		int c = (int)(y / 100);
		y = y % 100;
		int gamma = -2 * c + (int)(c / 4);
		int h = (d + (int)((26 * (m + 1)) / 10) + y + (int)(y / 4) + gamma) % 7;
		return h;
	}
}
