package ex16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
    int i,j;

    public Pos(int i, int j){
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static int[][] map = new int[51][51];
    static int N,L,R;
    static boolean trigger = false;
    static int answer = 0;
    static int[] di = {1,-1,0,0};
    static int[] dj = {0,0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j] =Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(answer-1);
    }

    static void solution(){
        int total;
        Queue<Pos> dfs = new LinkedList<>();
        Queue<Pos> que = new LinkedList<>();

        while(true){
            boolean[][] isVisited = new boolean[51][51];
            boolean isChanged = true;
            answer++;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    total = 0;
                    if(!isVisited[i][j]){
                        dfs.add(new Pos(i,j));
                        que.add(new Pos(i,j));
                        isVisited[i][j] = true;
                    }
    
                    while(!dfs.isEmpty()){
                        Pos thisPos = dfs.poll();
                        total += map[thisPos.i][thisPos.j];
    
                        for(int k=0;k<4;k++){
                            int nextI = thisPos.i + di[k];
                            int nextJ = thisPos.j + dj[k];
    
                            if(nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < N && !isVisited[nextI][nextJ]){
                                int gap = Math.abs(map[thisPos.i][thisPos.j] - map[nextI][nextJ]);
    
                                if(gap >= L && gap <= R){
                                    isChanged = false;
                                    dfs.add(new Pos(nextI,nextJ));
                                    que.add(new Pos(nextI,nextJ));
                                    isVisited[nextI][nextJ] = true;
                                }
                            }
                        }
                    }
    
                    if(!que.isEmpty()){
                        int avg = total / que.size();
        
                        while(!que.isEmpty()){
                            Pos thisPos = que.poll();
                            map[thisPos.i][thisPos.j] = avg;
                        }
                    }
                }
            }

            if(isChanged){
                return;
            } 
        }      
    }
}
