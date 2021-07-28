// 개미병사 문제 풀이
package DP;

import java.util.Scanner;

public class Main{
    public static int[] dp = new int[100];

    public static int solution(int idx, int[] arr){


        if(idx == 0 || idx == 1){
            return Math.max(dp[0],dp[1]);
        }
        if(dp[idx] != 0){
            return Math.max(dp[idx-1], dp[idx-2]+arr[idx]);
        }

        dp[idx] = Math.max(solution(idx-1,arr),solution(idx-2,arr)+arr[idx]);

        return dp[idx];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int idx = sc.nextInt();
        int block[] = new int[idx];

        for(int i = 0;i<idx;i++){
            block[i] = sc.nextInt();
        }  
        dp[0] = block[0];
        dp[1] = Math.max(block[0], block[1]);
        
        System.out.println(solution(idx - 1,block));
    }
}