package ex2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] dpArr;
    static int[] dpResult;

    static int dp(int idx){
        if(dpResult[idx] != 0){
            return dpResult[idx];
        } else {
            dpResult[idx] = Math.max(dp(idx-2), dp(idx-3) + dpArr[idx-1]) + dpArr[idx];
        }
        return dpResult[idx];
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        dpArr = new int[300];
        dpResult = new int[300];

        for(int i=0;i<N;i++){
            dpArr[i] = Integer.parseInt(bf.readLine());
        }
        dpResult[0] = dpArr[0];
        dpResult[1] = dpArr[0] + dpArr[1];
        dpResult[2] = Math.max(dpArr[0],dpArr[1]) + dpArr[2];
        System.out.println(dp(N-1));
    }
}
