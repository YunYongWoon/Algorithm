package ex2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	public int i,j;
	public int time;

	public Node(int i, int j, int time) {
		this.i = i;
		this.j = j;
		this.time = time;
	}
}

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String rcInput[] = bf.readLine().split(" ");
		int answer = 0;

		int r = Integer.parseInt(rcInput[0]);
		int c = Integer.parseInt(rcInput[1]);

		// 맵 생성
		int map[][] = new int[r][c];
		for (int i = 0; i < r; i++) {
			String mapInput[] = bf.readLine().split("");
			for (int j = 0; j < c; j++) {
				if (mapInput[j].equals("W")) {
					map[i][j] = -1;
				} else {
					map[i][j] = 0;
				}
			}
		}
		
		// solution
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == -1) {
					continue;
				} else {
					map[i][j] = bfs(map, r, c, i, j);
				}
			}
		}

		// answer
		for (int[] row : map) {
			for (int n : row) {
				if (n > answer) {
					answer = n;
				}
			}
		}

		System.out.println(answer);
	}

	static int bfs(int map[][], int row, int col, int startI, int startJ) {
		boolean isVisited[][] = new boolean[row][col];
		Queue<Node> que = new LinkedList<>();
		int di[] = {1, -1, 0, 0};
		int dj[] = {0, 0, 1, -1};
		int result = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == -1) {
					isVisited[i][j] = false;
				} else {
					isVisited[i][j] = true;
				}
			}
		}

		// bfs
		que.add(new Node(startI, startJ, 0));
		isVisited[startI][startJ] = false;
		while (!que.isEmpty()) {
			Node thisNode = que.poll();
			result = thisNode.time;
			for (int i = 0; i < 4; i++) {
				if (thisNode.i + di[i] < 0 || thisNode.i + di[i] >= row 
				|| thisNode.j + dj[i] < 0 || thisNode.j + dj[i] >= col
				|| !isVisited[thisNode.i + di[i]][thisNode.j + dj[i]]) {
					continue;
				}
				que.add(new Node(thisNode.i + di[i], thisNode.j + dj[i], thisNode.time + 1));
				isVisited[thisNode.i + di[i]][thisNode.j + dj[i]] = false;
			}
		}

		return result;
	}
}
