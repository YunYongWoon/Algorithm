package ex11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int idx;
    static int[] time;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        idx = Integer.parseInt(bf.readLine());

        time = new int[idx];
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        for(int i=0;i<idx;i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        for(int i=1;i<idx;i++){
            time[i] += time[i-1];
        }

        for(int i=0;i<idx;i++){
            ans += time[i];
        }

        System.out.println(ans);
    }
}