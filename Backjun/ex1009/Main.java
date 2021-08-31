package ex1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        int a,b,ans;

        for(int i=0;i<testCase;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ans = 1;

            for(int j=0;j<b;j++){
                ans = (ans * a) % 10;
            }

            if(ans == 0){
                ans = 10;
            }

            System.out.println(ans);
        }

    }
}

