package ex2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        int n;
        int[][] arr,min,max;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][3];
        min = new int[n][3];
        max = new int[n][3];
        StringTokenizer st;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        min[0] = arr[0];
        max[0] = arr[0];

        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                switch(j){
                    case 0:
                        min[i][j] = arr[i][j] + Math.min(min[i-1][0],min[i-1][1]);
                        max[i][j] = arr[i][j] + Math.max(max[i-1][0],max[i-1][1]);
                        break;
                    case 1:
                        min[i][j] = arr[i][j] + Math.min(Math.min(min[i-1][0],min[i-1][1]),min[i-1][2]);
                        max[i][j] = arr[i][j] + Math.max(Math.max(max[i-1][0],max[i-1][1]),max[i-1][2]);
                        break;
                    case 2:
                        min[i][j] = arr[i][j] + Math.min(min[i-1][1],min[i-1][2]);
                        max[i][j] = arr[i][j] + Math.max(max[i-1][1],max[i-1][2]);
                        break;
                }
            }
        }

        System.out.println(Math.max(Math.max(max[n-1][0],max[n-1][1]),max[n-1][2]) + " " + Math.min(Math.min(min[n-1][0],min[n-1][1]),min[n-1][2]));
    }
}
