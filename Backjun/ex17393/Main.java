package ex17393;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Long[] tile;
    static Long[] viscosity;
    static int[] ans;
    static int N;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        tile = new Long[N];
        viscosity = new Long[N];
        ans = new int[N];

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        for(int i=0;i<N;i++){
            tile[i] = Long.parseLong(st.nextToken());
        }
        s = bf.readLine();
        st = new StringTokenizer(s);
        for(int i=0;i<N;i++){
            viscosity[i] = Long.parseLong(st.nextToken());
        }

        for(int i = 0;i<N;i++){
            int start = 0;
            int end = viscosity.length - 1;

            while(start<=end){
                int mid = (start + end) / 2;

                if(viscosity[mid] <= tile[i]){
                    answer = (mid - i);
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }       
            }

            ans[i] = answer;
        }

        for(int list : ans){
            System.out.println(list + "");
        }
    }
}
