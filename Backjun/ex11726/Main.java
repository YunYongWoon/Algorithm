package ex11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException{
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        String s = bf.readLine(); //String
        int idx = Integer.parseInt(s); //Int

        for(int i = 3;i<idx+1;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[idx]);
    }
}
