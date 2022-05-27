package ex7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int i, j, k;
	int time;

	public Pos(int i, int j, int k, int time) {
		this.i = i;
		this.j = j;
		this.k = k;
		this.time = time;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N, M, H;
		int time = 0;
		int[][][] map;
		int[] di = {1, -1, 0, 0, 0, 0};
		int[] dj = {0, 0, 1, -1, 0, 0};
		int[] dk = {0, 0, 0, 0, 1, -1};
		Queue<Pos> que = new LinkedList<>();

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][M][H];

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < M; j++) {
					int input = Integer.parseInt(st.nextToken());
					if (input == 1) {
						que.add(new Pos(i, j, k, 0));
					}
					map[i][j][k] = input;
				}
			}
		}

		// bfs
		while (!que.isEmpty()) {
			Pos thisPos = que.poll();
			time = thisPos.time;
			for (int i = 0; i < 6; i++) {
				if (thisPos.i + di[i] < 0 || thisPos.i + di[i] >= N ||
				thisPos.j + dj[i] < 0 || thisPos.j + dj[i] >= M ||
				thisPos.k + dk[i] < 0 || thisPos.k +dk[i] >= H ||
				map[thisPos.i + di[i]][thisPos.j + dj[i]][thisPos.k + dk[i]] == -1 ||
				map[thisPos.i + di[i]][thisPos.j + dj[i]][thisPos.k + dk[i]] == 1) {
					continue;
				}
				que.add(new Pos(thisPos.i + di[i], thisPos.j + dj[i], thisPos.k + dk[i], thisPos.time + 1));
				map[thisPos.i + di[i]][thisPos.j + dj[i]][thisPos.k + dk[i]] = 1;
			}
		}

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j][k] == 0) {
						time = -1;
					}
				}
			}
		}
		System.out.println(time);
	}
}
