package ex1783;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, M;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        System.out.println(solve(N,M)); 
    }

    static int solve(int N, int M){
        if(N==1){
            return 1;
        } 
        if(N==2){
            return 4 < (M+1)/2 ? 4 : (M+1)/2;
        }  
        if(M<7){
            return 4 < M ? 4 : M;
        }       
        return M-2;
    }
}