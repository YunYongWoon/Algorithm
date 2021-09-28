package ex11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int realNum;
    int absNum;
    public Node(int i){
        realNum = i;
        absNum = (int)Math.abs(i);
    }

    public int getRealNum(){
        return realNum;
    }

    public int getAbsNum(){
        return absNum;
    }

    @Override
    public int compareTo(Node o) {
        if(absNum > o.getAbsNum()) 
            return 1;
        else if (absNum < o.getAbsNum()) 
            return -1;
        else{
            if(realNum >= o.getRealNum())
                return 1;
            else
                return -1;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        int count;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());

        for(int i=0;i<count;i++){
            int next = Integer.parseInt(bf.readLine());
            if(next == 0){
                if(pq.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pq.poll().getRealNum());
            }
            else
                pq.add(new Node(next));
        }
    }
}
