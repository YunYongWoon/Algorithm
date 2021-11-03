package ex10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int Upperfind(int x, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == x) {
                start = mid+1;
                ans = mid + 1;
            } else if(arr[mid] < x) {
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return ans;
    }
    static int Lowerfind(int x, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == x) {
                end = mid - 1;
                ans = mid;
            } else if (arr[mid] < x){
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        int N,M;
        int[] input;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(bf.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        for(int i=0;i<M;i++){
            int x = Integer.parseInt(st.nextToken());
            int ans = Upperfind(x,input) - Lowerfind(x,input);
            sb.append(ans + " ");
        }
        System.out.println(sb);
    }
}
