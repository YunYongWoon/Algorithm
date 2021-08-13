package ex1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    private int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {
    public static int T;
    public static int M, N, K;
    public static int[][] graph = new int[50][50];
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int[] answer;
    static Queue<Node> que = new LinkedList<Node>();

    public static void bfs(int x, int y) {
        que.add(new Node(x, y));
        graph[y][x] = 0;
        while (!que.isEmpty()) {
            Node thisNode = que.poll();
            for (int i = 0; i < 4; i++) {
                int nextNodeX = thisNode.getX() + dx[i];
                int nextNodeY = thisNode.getY() + dy[i];
                if (nextNodeX < 0 || nextNodeX > M - 1 || nextNodeY < 0 || nextNodeY > N - 1
                        || graph[nextNodeY][nextNodeX] == 0) {
                    continue;
                }

                else {
                    que.add(new Node(nextNodeX, nextNodeY));
                    graph[nextNodeY][nextNodeX] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        answer = new int[T];

        for (int testCase = 0; testCase < T; testCase++) {
            String str = bf.readLine();
            StringTokenizer st = new StringTokenizer(str);
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            for (int i = 0; i < K; i++) {
                int x, y;
                str = bf.readLine();
                st = new StringTokenizer(str);
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                graph[y][x] = 1;
            }
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1) {
                        bfs(j, i);
                        count++;
                    }
                }
            }
            answer[testCase] = count;
        }

        for(int ans : answer){
            System.out.println(ans);
        }
    }
}
