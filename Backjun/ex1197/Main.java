package ex1197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V, E;
	static Edge[] edges;
	static int[] parents;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		V = Integer.parseInt(input[0]);
		E = Integer.parseInt(input[1]);

		parents = new int[V + 1];
		for (int i = 0; i <= V; i++){
			parents[i] = i;
		}		
		
		edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			edges[i] = new Edge(Integer.parseInt(input[0]),Integer.parseInt(input[1]),Integer.parseInt(input[2]));
		}

		Arrays.sort(edges);

		int answer = 0;
		int count = 0;

		while (count < V - 1) {
			for (Edge edge : edges) {
				if (union(edge.from, edge.to)) {
					answer += edge.weight;
					count++;
				}
			}
		}

		System.out.println(answer);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) {
			return false;
		}
		parents[aRoot] = bRoot;
		return true;
	}

	static int find(int a) {
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = find(parents[a]);
	}
}
