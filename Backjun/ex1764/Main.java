package ex1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        Set<String> set = new HashSet<>();
        LinkedList<String> list = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            set.add(bf.readLine());
        }

        for(int i=0;i<M;i++){
            String tc = bf.readLine();
            if(set.contains(tc)){
                list.add(tc);
            }
        }
        sb.append(list.size() + "\n");
        Collections.sort(list);
        for (String string : list) {
            sb.append(string + "\n");
        }

        System.out.println(sb);
    }
}