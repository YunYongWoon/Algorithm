package ex1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dp(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < 3; j++) {
                int a = (1+j) % 3;
                int b = (2+j) % 3;
                arr[i][j] = arr[i][j] + Math.min(arr[i-1][a],arr[i-1][b]);
            }
        }
        return Math.min(Math.min(arr[arr.length-1][0],arr[arr.length-1][1]),arr[arr.length-1][2]);
    }

    public static void main(String[] args) throws IOException {
        int N;
        int[][] arr;
        StringTokenizer st;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dp(arr));
    }
}
