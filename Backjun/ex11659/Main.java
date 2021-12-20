package ex11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, testCase;
        int[] arr;
        int[] addArr;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        testCase = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        addArr = new int[N];

        st = new StringTokenizer(bf.readLine());

        arr[0] = Integer.parseInt(st.nextToken());
        addArr[0] = arr[0];

        for(int i=1;i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            addArr[i] = n + addArr[i-1];
            arr[i] = n;
        }

        for(int i=0;i<testCase;i++){
            int start, end;
            st = new StringTokenizer(bf.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            System.out.println(addArr[end-1] - addArr[start-1] + arr[start-1]);
        }
    }
}