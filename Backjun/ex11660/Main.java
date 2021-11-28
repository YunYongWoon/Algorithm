package ex11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        int N,M;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[][] map = new int[1024][1024];
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            for(int j=1;j<N;j++){
                map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int startI = Integer.parseInt(st.nextToken()) - 1;
            int startJ = Integer.parseInt(st.nextToken()) - 1;
            int endI = Integer.parseInt(st.nextToken()) - 1;
            int endJ = Integer.parseInt(st.nextToken()) - 1;
            int answer = 0;

            for(int j = startI;j<=endI;j++){
                if(startJ == 0){
                    answer += map[j][endJ];
                } else {
                    answer += map[j][endJ] - map[j][startJ-1];
                }
            }

            sb.append(answer + "\n");
        }
        System.out.println(sb);       
    }
}