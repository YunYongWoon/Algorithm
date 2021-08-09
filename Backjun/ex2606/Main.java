package ex2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] dfsVisited = new boolean[101];
    public static Integer[][] graph = new Integer[101][101];
    public static int count = 0;

    static void dfs(int start, int testCase){
        dfsVisited[start] = true;
        count++;
        for(int i = 0; i <= testCase ; i++){
            if(!dfsVisited[i] && graph[start][i] == 1){
                dfs(i,testCase);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        int net = Integer.parseInt(bf.readLine()); 

        for(int i=0;i<=testCase;i++){
            for(int j=0;j<=testCase;j++){
                graph[i][j] = 0;
            }
        }

        for(int i=0;i<net;i++){
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int fir = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            graph[fir][sec] = 1;
            graph[sec][fir] = 1;
        }

        dfs(1,testCase);

        System.out.println(count-1);
    }
}
