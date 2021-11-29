package ex11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        int n, ans = 1;
        int[] arr = new int[1001];
        int[] dp = new int[1001];

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;
        // dp
        for(int i=1;i<n;i++){
            int thisValue = 0;
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]){
                    thisValue = Math.max(thisValue,dp[j]);
                } 
            }
            dp[i] = thisValue+1;
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}