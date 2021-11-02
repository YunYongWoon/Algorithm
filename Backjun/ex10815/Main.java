package ex10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, M;
        int[] input;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        input = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        M = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<M;i++){
            int check = Integer.parseInt(st.nextToken());
            int answer = 0;
            int head = 0;
            int tail = N - 1;
            while(head<=tail){
                int mid = (head+tail) / 2;
                if(input[mid] == check){
                    answer = 1;
                    break;
                }
                else if(input[mid] > check){
                    tail = mid-1;
                }
                else{
                    head = mid + 1;
                }
            }
            System.out.print(answer + " ");
        }
    }
}
