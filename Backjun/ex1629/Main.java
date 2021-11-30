package ex1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int a,b,c;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(pow(a,b,c));
    }

    static long pow(int a, int b, int c){
        if(b == 0){
            return 1;
        }

        long result = pow(a,b/2,c);
        long remainder = result * result % c;

        if(b % 2 == 0){
            return remainder;
        } else {
            return remainder * a % c;
        }
    }
}