package ex23889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Info implements Comparable<Info>{
	int pos;
	int count;

	public Info(int pos, int count) {
		this.pos = pos;
		this.count = count;
	}

	@Override
	public int compareTo(Info o) {
		if (this.count > o.count) {
			return -1;
		} else if(this.count < o.count) {
			return 1;
		} else {
			if (this.pos < o.pos) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	
}

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();

		int N, M, K;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		st = new StringTokenizer(bf.readLine());
		arr[0] = 0;
		for (int i = 1; i < N + 1; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		
		int tmp = Integer.parseInt(st.nextToken());
		List<Info> list = new ArrayList<>();
		for (int i = 0; i < K - 1; i++) {
			int nextTmp = Integer.parseInt(st.nextToken());
			list.add(new Info(tmp, arr[nextTmp - 1] - arr[tmp - 1]));
			tmp = nextTmp;
		}
		list.add(new Info(tmp, arr[N] - arr[tmp - 1]));
		Collections.sort(list);

		int[] answer = new int[M];
		for (int i = 0; i < M; i++) {
			answer[i] = list.get(i).pos;
		}
		Arrays.sort(answer);
		for (int i : answer) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}
