package ex2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp = new int[1000001];

    public static int solution(int sol){
        int i,j,k;
        if(sol == 1 || sol == 2 || sol == 3 || dp[sol] != 0){
            return dp[sol];
        }

        if(sol % 3 == 0 ){
            i = solution(sol / 3) + 1;
        }
        else
            i = Integer.MAX_VALUE;
        
        if (sol % 2 == 0){
            j = solution(sol / 2) + 1;
        }
        else
            j = Integer.MAX_VALUE;

        k = solution(sol - 1) + 1;

        
        dp[sol] = Math.min(i, Math.min(j, k));

        return dp[sol];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        String s = bf.readLine(); //String
        int idx = Integer.parseInt(s); //Int
        dp[0] = Integer.MAX_VALUE;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        System.out.println(solution(idx));
    }
}
