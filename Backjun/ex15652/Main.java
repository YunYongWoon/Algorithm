package ex15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        int N,M;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] inputArr = new int[N];
        int[] outputArr = new int[M];
        boolean[] visited = new boolean[N];

        for(int i=0;i<N;i++){
            inputArr[i] = i+1;
        }

        permutation(inputArr,outputArr,visited,0,N,M,0);

    }

    private static void permutation(int[] inputArr, int[] outputArr, boolean[] visited, int depth, int n, int m, int point) {
        if(depth == m){
            print(outputArr);
            visited[outputArr[0]-1] = true;
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i] && point <= inputArr[i]){
                outputArr[depth] = inputArr[i];
                permutation(inputArr, outputArr, visited, depth+1, n, m, outputArr[depth]);
            }
        }
    }

    private static void print(int[] outputArr) {
        for(int i=0;i<outputArr.length;i++){
            System.out.print(outputArr[i]);
            if(i<outputArr.length-1)
                System.out.print(" ");
        }
        System.out.println();
    }
}
