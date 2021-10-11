package ex9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Node{
    int num;
    String ans;
    public Node(int num, String ans){
        this.num = num;
        this.ans = ans;
    }

    public int getNum(){
        return num;
    }

    public String getAns(){
        return ans;
    }
}

public class Main {
    static boolean[] visited;
    static Queue<Node> que;

    static Node changeD(Node thisNode){
        int num = thisNode.getNum() * 2;
        if(num > 9999)
            num = num % 10000;
        String ans = thisNode.getAns() + "D";
        return new Node(num,ans);
    }
    static Node changeS(Node thisNode){
        int num = thisNode.getNum() - 1;
        if(num < 0)
            num = 9999;
        String ans = thisNode.getAns() + "S";
        return new Node(num,ans);      
    }
    static Node changeL(Node thisNode){
        int move = thisNode.getNum() / 1000;
        int num = (thisNode.getNum() % 1000)*10 + move;
        String ans = thisNode.getAns() + "L";
        return new Node(num,ans);
    }
    static Node changeR(Node thisNode){
        int move = thisNode.getNum() % 10;
        int num = (thisNode.getNum() / 10) + move * 1000;
        String ans = thisNode.getAns() + "R";
        return new Node(num,ans);
    }

    static String solution(int input, int output, String answer){
        que.add(new Node(input, answer));
        visited[input] = true;

        Node thisNode;
        while(true){ 
            thisNode = que.poll();
            if(thisNode.getNum() == output)
                break;

            Node D = changeD(thisNode);
            Node S = changeS(thisNode);
            Node L = changeL(thisNode);
            Node R = changeR(thisNode);

            if(!visited[D.getNum()]){
                que.add(D);
                visited[D.getNum()] = true;
            }
            if(!visited[S.getNum()]){
                que.add(S);
                visited[S.getNum()] = true;
            }
            if(!visited[L.getNum()]){
                que.add(L);
                visited[L.getNum()] = true;
            }
            if(!visited[R.getNum()]){
                que.add(R);
                visited[R.getNum()] = true;
            }
        }
        return thisNode.getAns();
    }
    public static void main(String[] args) throws IOException{
        int testCase, input, output;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(bf.readLine());

        for(int i = 0; i<testCase; i++){
            visited = new boolean[10001];
            que = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(bf.readLine());
            input = Integer.parseInt(st.nextToken());
            output = Integer.parseInt(st.nextToken());
            System.out.println(solution(input, output, ""));
        }

    }
}

