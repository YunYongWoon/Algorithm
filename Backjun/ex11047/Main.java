package ex11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        int count,goal;
        int result = 0;
        int[] money;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        count = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        money = new int[count];

        for(int i=0;i<count;i++){
            money[i] = Integer.parseInt(bf.readLine());
        }

        while(count>0){
            if(goal-money[count-1] < 0){
                count--;
            }
            else{
                goal -= money[count-1];
                result++;
            }
        }
        System.out.println(result);
    }
}
