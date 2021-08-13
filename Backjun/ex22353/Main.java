package ex22353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        double a,d,k; 
        double answer = 0f;
        double step = 1f;
        double prevPct = 1f;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        a = Double.parseDouble(st.nextToken());
        d = Double.parseDouble(st.nextToken());
        k = Double.parseDouble(st.nextToken());

        while(d<100){
            answer += step++ * a * (d/100) * prevPct;
            prevPct = prevPct * (1f - d/100);
            d *= (1 + k/100);
        }
        answer += step * a * prevPct;

        System.out.printf("%.6f",answer);
    }
}
