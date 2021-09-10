package ex15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static void permutation(int[] input, int[] output, boolean[] visited, int depth, int total, int choose, int point){
        if(depth == choose){
            print(output);
            return;
        }
        for(int i=0;i<total;i++){
            if(!visited[i] && point < input[i]){
                output[depth] = input[i];
                visited[i] = true;
                permutation(input, output, visited, depth+1, total, choose, output[depth]);
                visited[i] = false;
            }
        }
    }

    static void print(int[] arr){

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i != arr.length-1)
                System.out.print(" ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        int N,M;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] inputArr = new int[N];
        boolean[] visited = new boolean[N];
        int[] outputArr = new int[M];

        for(int i=0;i<N;i++){
            inputArr[i] = i+1;
        }

        permutation(inputArr,outputArr,visited,0,N,M,0);
    }
}
