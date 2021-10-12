package ex16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    private long num;
    private int count;
    public Node(long num, int count){
        this.count = count;
        this.num = num;
    }

    public int getCount(){
        return count;
    }

    public long getNum(){
        return num;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        long start, end;
        int answer;
        Queue<Node> que = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());

        que.add(new Node(start,1));

        while(true){ 
            Node thisNode = que.poll();
            if(thisNode.getNum() == end){
                answer = thisNode.getCount();
                break;
            }
            if(thisNode.getNum() > end){
                if(que.isEmpty()){
                    answer = -1;
                    break;
                }
                continue;
            }
            que.add(new Node(thisNode.getNum()*2L,thisNode.getCount()+1));
            que.add(new Node(thisNode.getNum()*10L+1L,thisNode.getCount()+1));        
        }
        System.out.println(answer);
    }
}
