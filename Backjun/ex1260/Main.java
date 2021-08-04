package ex1260;

import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] dfsVisited = new boolean[1001];
    public static boolean[] bfsVisited = new boolean[1001];
    public static Integer[][] graph = new Integer[1001][1001];

    static void dfs(int d, int count){
        dfsVisited[d] = true;
        System.out.print(d);

        for(int i = 1;i<=count;i++){
            if(graph[d][i] != 0 && !dfsVisited[i]){
                System.out.print(" ");
                dfs(i,count);
            }
        }
    }

    static void bfs(int b, int count){
        Queue<Integer> que = new LinkedList<>();
        que.add(b);
        bfsVisited[b] = true;

        while(que.peek() != null){
            int next = que.poll();
            System.out.print(next);

            for(int i=1;i<=count;i++){
                if(graph[next][i] != 0 && !bfsVisited[i]){
                    que.add(i);
                    bfsVisited[i] = true;
                }
            }
            System.out.print(" ");
        }
    }

    public static void main(String[] args) throws IOException{
        int n,m,v;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        // n,m,v 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        //Init
        for(int i = 1; i < 1001; i++){         
            dfsVisited[i] = false;
            bfsVisited[i] = false;
            for(int j=1; j<1001; j++){
                graph[i][j] = 0;
            }
        }

        // Node 생성
        for(int i=0;i<m;i++){
            String k = bf.readLine();
            StringTokenizer kst = new StringTokenizer(k);
            int x = Integer.parseInt(kst.nextToken());
            int y = Integer.parseInt(kst.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(v,n);
        System.out.println();
        bfs(v,n);
    }
}
