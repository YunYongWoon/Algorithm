package ex1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N;
        int[][] arr;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] strings = bf.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(strings[j]);
            }
        }
        solution(arr, 0, 0, N);

        System.out.println(sb);
    }

    static void solution(int[][] arr, int i, int j, int N) {
        if(check(arr,i,j,N)){
            sb.append(arr[i][j]);
            return;
        } else {
            sb.append("(");
            solution(arr, i, j, N/2);
            solution(arr, i, j + N/2, N/2);
            solution(arr, i + N/2, j, N/2);
            solution(arr, i + N/2, j + N/2, N/2);
            sb.append(")");
        }
    }

    static boolean check(int[][] arr, int i, int j, int N) {
        int checker = arr[i][j];
        for (int ii = i; ii < i + N; ii++) {
            for (int jj = j; jj < j + N; jj++) {
                if(checker != arr[ii][jj]){
                    return false;
                }
            }
        }
        return true;
    }
}