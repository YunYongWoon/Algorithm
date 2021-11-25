package ex15657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cur = 0;
    public static void main(String[] args) throws IOException {
        int N, M;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] inputArr = new int[N];
        int[] outputArr = new int[M];

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputArr);

        permutation(inputArr, outputArr, 0, N, M);

        System.out.println(sb);
    }

    private static void permutation(int[] inputArr, int[] outputArr, int depth, int n, int m) {
        if(depth == m){
            for(int i=0;i<outputArr.length;i++){
                sb.append(outputArr[i]);
                if(i<outputArr.length-1)
                    sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<n;i++){
            if(depth == 0){
                outputArr[depth] = inputArr[i];
                permutation(inputArr, outputArr, depth+1, n, m);
            } else {
                if(outputArr[depth-1] <= inputArr[i]){
                    outputArr[depth] = inputArr[i];
                    permutation(inputArr, outputArr, depth+1, n, m);
                }
            }
        }
    }
}
