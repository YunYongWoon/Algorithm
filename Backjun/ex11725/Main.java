package ex11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        int n;
        Queue<Integer> que = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        ArrayList<Integer>[] map = new ArrayList[n+1];
        int[] headArr = new int[n+1];
        StringTokenizer st;
        for(int i=0;i<n+1;i++){
            map[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x].add(y);
            map[y].add(x);
        }

        que.add(1);
        while(!que.isEmpty()){
            int head = que.poll();
            for (int i : map[head]) {
                if(headArr[i] == 0){
                    que.add(i);
                    headArr[i] = head;
                }
            }
        }
        for(int i=2;i<headArr.length;i++){
            System.out.println(headArr[i]);
        }
    }
}
