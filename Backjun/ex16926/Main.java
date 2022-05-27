package ex16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N, M, R;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int mod = Math.min(N, M) / 2;
		for (int i = 0; i < mod; i++) {
			spinArr(arr, N, M, i, R);
		}
		printAnswer(arr, N, M);
	}

	static void spinArr(int[][] arr, int N, int M, int depth, int R) {
		int posI = depth;
		int posJ = depth;
		for (int i = 0; i < R; i++) {
			int temp = arr[posI][posJ];
			while (posJ < M - depth - 1) {
				arr[posI][posJ] = arr[posI][posJ + 1];
				posJ++;
			}
			while (posI < N - depth - 1) {
				arr[posI][posJ] = arr[posI + 1][posJ];
				posI++;
			}
			while (posJ > depth) {
				arr[posI][posJ] = arr[posI][posJ - 1];
				posJ--;
			}
			while (posI > depth) {
				arr[posI][posJ] = arr[posI - 1][posJ];
				posI--;
			}
			arr[posI + 1][posJ] = temp;
		}
	}

	static void printAnswer(int[][] arr, int N, int M) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++){
				sb.append(arr[i][j]);
				if (j < M - 1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
