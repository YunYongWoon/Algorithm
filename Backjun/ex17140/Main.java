package ex17140;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair>{
	int num = 0, count = 0;

	public Pair(int num , int count) {
		this.num = num;
		this.count = count;
	}

	public void countUp() {
		count++;
	}

	@Override
	public int compareTo(Pair o) {
		if (this.count > o.count) {
			return 1;
		} else if (this.count < o.count) {
			return -1;
		} else {
			if (this.num > o.num) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int r, c, k;
		int[][] map = new int[100][100];

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = solution(map, r, c, k);
		System.out.println(answer);
	}

	static int solution(int[][] map, int r, int c, int k) {
		int time = 0;
		int rMax = 3;
		int cMax = 3;

		while (time < 101) {
			if (map[r - 1][c - 1] == k) {
				return time;
			}
			if (rMax >= cMax) {
				cMax = R(map, rMax, cMax);
			} else {
				rMax = C(map, rMax, cMax);
			}
			time++;
		}
		return -1;
	}

	static int R(int[][] map, int rMax, int cMax) {
		int newCMax = 0;

		for (int i = 0; i < rMax; i++) {
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			LinkedList<Integer> list = new LinkedList<>();
			Pair[] pairArr = new Pair[101];

			for (int j = 0; j < cMax; j++) {
				int arrNum = map[i][j];
				if (arrNum == 0) {
					continue ;
				}

				if (pairArr[arrNum] == null) {
					pairArr[arrNum] = new Pair(arrNum, 1);
					list.add(arrNum);
				} else {
					pairArr[arrNum].countUp();
				}
			}

			for (int idx : list) {
				pq.add(pairArr[idx]);
			}

			int cMaxCount = 0;
			while (cMaxCount < 100 && !pq.isEmpty()) {
				Pair thisPair = pq.poll();
				map[i][cMaxCount] = thisPair.num;
				map[i][cMaxCount + 1] = thisPair.count;
				cMaxCount += 2;
			}

			if (cMaxCount > newCMax) {
				newCMax = cMaxCount;
			} 

			while (cMaxCount < cMax) {
				map[i][cMaxCount] = 0;
				cMaxCount++;
			}
		}

		return newCMax;
	}

	static int C(int[][] map, int rMax, int cMax) {
		int newRMax = 0;

		for (int j = 0; j < cMax; j++) {
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			LinkedList<Integer> list = new LinkedList<>();
			Pair[] pairArr = new Pair[101];
			// 수 세기
			for (int i = 0; i < rMax; i++) {
				int arrNum = map[i][j];
				if (arrNum == 0) {
					continue;
				}

				if (pairArr[arrNum] == null) {
					pairArr[arrNum] = new Pair(arrNum, 1);
					list.add(arrNum);
				} else {
					pairArr[arrNum].countUp();
				}
			}

			// 우선순위 큐에 add
			for (int idx : list) {
				pq.add(pairArr[idx]);
			}

			// 맵에 다시 입력
			int rMaxCount = 0;
			while (rMaxCount < 100 && !pq.isEmpty()) {
				Pair thisPair = pq.poll();
				map[rMaxCount][j] = thisPair.num;
				map[rMaxCount + 1][j] = thisPair.count;
				rMaxCount += 2;
			}

			if (rMaxCount > newRMax) {
				newRMax = rMaxCount;
			}
			while (rMaxCount < rMax) {
				map[rMaxCount][j] = 0;
				rMaxCount++;
			}
			
		}

		return newRMax;
	}
}
