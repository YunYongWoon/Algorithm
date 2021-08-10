package ex7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int geti(){
        return x;
    }

    public int getj(){
        return y;
    }
}

public class Main {
    static int N,M;
    static int[][] graph = new int[1001][1001];
    static Queue<Pair> que = new LinkedList<>();
    static int[] di = {1,-1,0,0};
    static int[] dj = {0,0,1,-1};

    static int bfs(){
        int ans = 1;
        while(!que.isEmpty()){
            Pair thisPair = que.poll();
            int i = thisPair.geti();
            int j = thisPair.getj();
            for(int k=0;k<4;k++){
                int nexti = i + di[k];
                int nextj = j + dj[k];

                if(nexti < 1 || nextj < 1 || nexti > N || nextj > M || graph[nexti][nextj] != 0)
                    continue;
                
                if(graph[nexti][nextj] == 0){
                    que.add(new Pair(nexti,nextj));
                    graph[nexti][nextj] = graph[i][j]+1;
                    ans = graph[nexti][nextj];
                }
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<M;j++){
                if(graph[i][j] == 0)
                    return -1;
            }
        }
        
        return ans-1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=M;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1){
                    que.add(new Pair(i,j));
                }
            }
        }
        System.out.println(bfs());       
    }
}
