package ex1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Number implements Comparable<Number>{
    int num;
    public Number(int num){
        this.num = num;
    }

    public int getNum(){
        return this.num;
    }

    @Override
    public int compareTo(Number o) {
        if(this.num - o.getNum() < 0)
            return -1;
        return 1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        int N;
        PriorityQueue<Number> pq = new PriorityQueue<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++){
            int x = Integer.parseInt(bf.readLine());
            if(x == 0){
                if(pq.size() != 0){
                    int y = pq.poll().getNum();
                    System.out.println(y);
                }
                else
                    System.out.println(0);
            }
            else{
                pq.offer(new Number(x));
            }
        }
    }
}
