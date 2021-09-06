package ex1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        int N,M;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();

        for(int i=0;i<N;i++){
            String name = bf.readLine();
            map.put(Integer.toString(i+1),name);
            map.put(name,Integer.toString(i+1));
        }

        for(int i=0;i<M;i++){
            String test = bf.readLine();
            System.out.println(map.get(test));
        }
    }
}
