package ex3649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = bf.readLine()) != null) {
			int size = Integer.parseInt(s) * 10000000;
			int testCase = Integer.parseInt(bf.readLine());
			int[] arr = new int[testCase];

			for (int i = 0; i < testCase; i++) {
				arr[i] = Integer.parseInt(bf.readLine());
			}
			Arrays.sort(arr);
			int start = 0;
			int end = testCase - 1;
			boolean isPlug = false;
			while (start < end) {
				if (arr[start] + arr[end] > size) {
					end--;
				} else if (arr[start] + arr[end] < size) {
					start++;
				} else {
					isPlug = true;
					break;
				}
			}
			if (isPlug) {
				System.out.println("yes " + arr[start] + " " + arr[end]);
			} else {
				System.out.println("danger");
			}
		}
	}
}
