package ex1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int dp(int i, int j, int[][] tri){
        int add = 0;
        if(j-1 >= 0){
            add = Math.max(tri[i-1][j-1], tri[i-1][j]);
        }
        else{
            add = tri[i-1][j];
        }
        return add;
    }
    public static void main(String[] args) throws IOException{
        int n,answer = 0;
        int[][] tri;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        tri = new int[n][n];
        tri[0][0] = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i=1;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<i+1;j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1;i<n;i++){
            for(int j=0;j<i+1;j++){
                tri[i][j] = tri[i][j] + dp(i,j,tri);
            }
        }

        for (int max : tri[n-1]) {
            if(answer < max){
                answer = max;
            }
        }

        System.out.println(answer);
    }
}
