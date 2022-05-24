package ex14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int i,j;

	public Node(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class Main {
	static int answer = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[][] map;
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// 맵 생성
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solution(map, 0, N, M);
		System.out.println(answer);
	}

	static void solution(int[][] map, int depth, int N, int M) {
		if (depth == 3) {
			int result = countResult(map, N, M);
			if (result > answer) {
				answer = result;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 3;
					solution(map, depth + 1, N, M);
					map[i][j] = 0;
				}
			}
		}
	}

	static int countResult(int[][] map, int N, int M) {
		Queue<Node> que = new LinkedList<>();
		boolean[][] isVisited = new boolean[N][M];
		int[] di = {1, -1, 0, 0};
		int[] dj = {0, 0, 1, -1};
		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j< M; j++) {
				if (map[i][j] == 1 || map[i][j] == 3) {
					isVisited[i][j] = true;
				} 
			}
		}
		
		// bfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j< M; j++) {
				if (map[i][j] == 2 && !isVisited[i][j]) {
					que.add(new Node(i, j));
					isVisited[i][j] = true;
					while (!que.isEmpty()) {
						Node thisNode = que.poll();
						for (int k = 0; k < 4; k++) {
							if (thisNode.i + di[k] < 0 || thisNode.i + di[k] >= N
							|| thisNode.j + dj[k] < 0 || thisNode.j + dj[k] >= M
							|| isVisited[thisNode.i + di[k]][thisNode.j + dj[k]]) {
								continue;
							}
							que.add(new Node(thisNode.i + di[k], thisNode.j + dj[k]));
							isVisited[thisNode.i + di[k]][thisNode.j + dj[k]] = true;
						}
					}
				}
			}
		}

		for(boolean[] row : isVisited) {
			for(boolean node : row) {
				if (!node) {
					count++;
				}
			}
		}
		return count;
	}
}
