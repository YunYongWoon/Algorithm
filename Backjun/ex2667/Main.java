package ex2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[][] graph = new int[26][26];
    static ArrayList<Integer> houseCount = new ArrayList<>();
    static int testCase = 0;
    static int answer = 0;
    static int apartCount = 0;

    static boolean dfs(int i, int j){
        if(i<1 || j<1 || i > testCase || j > testCase)
            return false;

        if(graph[i][j] == 1){
            graph[i][j] = 0;
            apartCount++;
            dfs(i+1,j);
            dfs(i-1,j);
            dfs(i,j+1);
            dfs(i,j-1);
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(bf.readLine());

        for(int i=1;i<=testCase;i++){
            String s = bf.readLine();
            String[] strArr = s.split("");
            for(int j=1;j<=testCase;j++){
                graph[i][j] = Integer.parseInt(strArr[j-1]);
            }
        }

        for(int i=1;i<=testCase;i++){
            for(int j=1;j<=testCase;j++){
                if(dfs(i,j)){
                    answer++;
                    houseCount.add(apartCount);
                    apartCount = 0;
                }
            }
        }

        Collections.sort(houseCount);
        System.out.println(answer);
        for(int i : houseCount){
            System.out.println(i);
        }
    }
}
