package ex3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int answer = 0;
		String[][] map = new String[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = bf.readLine().split("");
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int result = solution(map, i, j);
				if (result > answer) {
					answer = result;
				}
			}
		}
		System.out.println(answer);
	}

	static int solution(String[][] map, int i, int j) {
		int up = check(map, i, j, i - 1, j);
		int down = check(map, i, j, i + 1, j);
		int left = check(map, i, j, i, j - 1);
		int right = check(map, i, j, i, j + 1);
		int[] arr = {up, down, left, right};
		Arrays.sort(arr);
		return arr[3];
	}

	static int check(String[][] map, int i, int j, int ii, int jj) {
		if (ii < 0 || ii >= map.length || jj < 0 || jj >= map.length) {
			return 0;
		}
		swap(map, i, j, ii, jj);
		int a = count(map, i, j);
		int b = count(map, ii, jj);
		swap(map, i, j, ii, jj);

		return a > b ? a : b;
	}

	static void swap(String[][] map, int i, int j, int ii, int jj) {
		String temp = map[i][j];
		map[i][j] = map[ii][jj];
		map[ii][jj] = temp;
	}

	static int count(String[][] map, int i, int j) {
		int row = 0;
		int col = 0;

		for (int ii = i; ii >= 0; ii--) {
			if (map[ii][j].equals(map[i][j])) {
				col++;
			} else {
				break;
			}
		}

		for (int ii = i; ii < map.length; ii++) {
			if (map[ii][j].equals(map[i][j])) {
				col++;
			} else {
				break;
			}
		}

		for (int jj = j; jj >= 0; jj--) {
			if (map[i][jj].equals(map[i][j])) {
				row++;
			} else {
				break;
			}
		}

		for (int jj = j; jj < map.length; jj++) {
			if (map[i][jj].equals(map[i][j])) {
				row++;
			} else {
				break;
			}
		}

		return row > col ? row - 1 : col - 1;
	}
}
