package ex11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pos {
	int i, j;
	char value;
	
	public Pos(int i, int j, char value) {
		this.i = i;
		this.j = j;
		this.value = value;
	}
}

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[12][6];
		boolean isCrash = true;
		int time = 0;
		
		// MAP input
		for (int i = 0; i < 12; i++) {
			String inputString = bf.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = inputString.charAt(j);
			}
		}
			
		// crash block
		while (isCrash) {
			// crash block
			isCrash = crashBlock(map);
			// block down
			if (!isCrash) {
				break;
			}
			blockDown(map);
			time++;
		}
		
		System.out.println(time);
	}
	
	static boolean crashBlock(char[][] map) {
		Queue<Pos> que = new LinkedList<>();
		boolean isCrash = false;
		int[] di = {1, -1, 0, 0};
		int[] dj = {0, 0, 1, -1};
		
		for (int i = 11; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				LinkedList<Pos> crashedBlock = new LinkedList<>();
				boolean[][] isVisited = new boolean[12][6];
				int crashCount = 0;
				if (map[i][j] != '.') {
					Pos firstPos = new Pos(i, j, map[i][j]);
					que.add(firstPos);
					crashedBlock.add(firstPos);
					isVisited[i][j] = true;
					crashCount++;
					while (!que.isEmpty()) {
						Pos thisPos = que.poll();
						int thisI = thisPos.i;
						int thisJ = thisPos.j;
						for (int k = 0; k < 4; k++) {
							if (thisI + di[k] < 0 || thisI + di[k] >= 12 
									|| thisJ + dj[k] < 0 || thisJ + dj[k] >= 6 
									|| map[thisI + di[k]][thisJ + dj[k]] != thisPos.value
									|| isVisited[thisI + di[k]][thisJ + dj[k]]) {
								continue;
							}
							Pos nextPos = new Pos(thisI + di[k], thisJ + dj[k], thisPos.value);
							isVisited[thisI + di[k]][thisJ + dj[k]] = true;
							que.add(nextPos);
							crashedBlock.add(nextPos);
							crashCount++;
						}
					}
					
					if (crashCount >= 4) {
						for (Pos pos : crashedBlock) {
							map[pos.i][pos.j] = '.';
						}
						isCrash = true;
					}
				}
			}
		}
		return isCrash;
	}
	
	static void blockDown(char[][] map) {
		for (int j = 0; j < 6; j++) {
			for (int i = 11; i >= 0; i--) {
				if (map[i][j] == '.') {
					int pointCount = 0;
					while (i - pointCount >= 0 && map[i - pointCount][j] == '.') {
						pointCount++;
					}
					if (i - pointCount < 0) {
						break;
					}
					
					int downPos = i - pointCount;
					
					while (downPos >= 0) {
						map[downPos + pointCount][j] = map[downPos][j];
						map[downPos][j] = '.';
						downPos--;
					}
				}	
			}
		}
	}
}
