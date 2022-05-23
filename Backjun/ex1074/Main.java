package ex1074;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int min = 0;

		for (int i = N; i >= 0; i--) {
			int range = (int) Math.pow(2, i);

			if (r < range / 2 && c < range / 2) {
				continue;
			} else if (r < range / 2 && c >= range / 2) {
				c -= range / 2;
				min += range * range / 4;
			} else if (r >= range / 2 && c < range / 2) {
				r -= range / 2;
				min += range * range / 2;
			} else {
				r -= range / 2;
				c -= range / 2;
				min += range * range / 4 * 3;
			}
		}
		System.out.println(min);
		sc.close();
	}
}