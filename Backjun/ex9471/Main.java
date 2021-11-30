package ex9471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int testCase = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        testCase = Integer.parseInt(bf.readLine());

        for(int i=0;i<testCase;i++){
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int ans = findKm(M);
            sb.append(num + " " + ans + "\n");
        }

        System.out.println(sb);
    }

    static int findKm(int M){
        int first = 1;
        int second = 1;
        int count = 1;
        while(true){
            if(first == 1 && second == 0){
                count++;
                break;
            }
            count++;
            int temp = second;
            second = (first + second) % M;
            first = temp;
        }
        return count;
    }
}
