package ex14442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    private int i, j, count, broken;

    public Node(int i, int j, int count, int broken) {
        this.i = i;
        this.j = j;
        this.count = count;
        this.broken = broken;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getCount() {
        return count;
    }

    public int getBroken() {
        return broken;
    }
}

public class Main {
    static int N, M, K;
    static int[][] graph;
    static boolean[][][] visited;
    static Queue<Node> que = new LinkedList<Node>();
    static int[] di = { 1, -1, 0, 0 };
    static int[] dj = { 0, 0, 1, -1 };

    static int bfs() {
        while (!que.isEmpty()) {
            Node node = que.poll();
            int thisI = node.getI();
            int thisJ = node.getJ();
            int thisCount = node.getCount();
            int thisBroken = node.getBroken();
            if (thisI == N - 1 && thisJ == M - 1) {
                return thisCount;
            }
            for (int i = 0; i < 4; i++) {
                int nextI = thisI + di[i];
                int nextJ = thisJ + dj[i];
                if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < M) {
                    // 벽을 처음 만났을 때
                    if(graph[nextI][nextJ] == 1 && thisBroken < K && !visited[nextI][nextJ][thisBroken + 1]){
                        visited[nextI][nextJ][thisBroken+1] = true;
                        que.add(new Node(nextI,nextJ,thisCount+1, thisBroken + 1));
                    } else if(graph[nextI][nextJ] == 0 && !visited[nextI][nextJ][thisBroken]){
                        visited[nextI][nextJ][thisBroken] = true;
                        que.add(new Node(nextI,nextJ,thisCount+1, thisBroken));
                    }
                } 
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M][K+1];

        for (int i = 0; i < N; i++) {
            String[] split = bf.readLine().split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(split[j]);
            }
        }
        visited[0][0][0] = true;
        que.add(new Node(0, 0, 1, 0));
        System.out.println(bfs());
    }
}
