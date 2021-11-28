package ex2407;
/*
nCm = nPm / m!
    = n! / ((n-m)! * m!)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        int n,m;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;

        for(int i=0;i<m;i++){
            a = a.multiply(new BigInteger(String.valueOf(n-i)));
            b = b.multiply(new BigInteger(String.valueOf(1+i)));
        }

        System.out.println(a.divide(b));
    }
}
