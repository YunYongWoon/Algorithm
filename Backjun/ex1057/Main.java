package ex1057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        int total, a, b;
        int ans = 1;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        total = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if(a>b){
            int c = a;
            a = b;
            b = c;
        }

        while(total>1){
            if(a-b == -1 && a%2==1){
                break;
            } else {
                a = (a+1)/2;
                b = (b+1)/2;
                total/=2;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
