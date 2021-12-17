package ex17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        int N,M;
        HashMap<String, String> map = new HashMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for(int i=0;i<M;i++){
            String password = map.get(bf.readLine());
            sb.append(password + "\n");
        }

        System.out.println(sb);
    }
}