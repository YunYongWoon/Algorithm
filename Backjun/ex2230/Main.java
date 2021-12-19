package ex2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arr = new ArrayList<>();
        int N,M;
        int start = 0, end = 0;
        int answer = Integer.MAX_VALUE;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            arr.add(Integer.parseInt(bf.readLine()));
        }
        Collections.sort(arr);

        while(end < arr.size() && start < arr.size()){            
            int checker = arr.get(end) - arr.get(start);

            if(checker < M){
                end++;
                continue;
            }

            if(checker >= M){
                if(checker < answer){
                    answer = checker;
                }
            }
            start++;
        }

        System.out.println(answer);
    }
}