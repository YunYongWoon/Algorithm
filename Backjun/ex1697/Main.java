package ex1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node{
    int n,depth;
    public Node(int n, int depth){
        this.n = n;
        this.depth = depth;
    }

    public int getN(){
        return this.n;
    }

    public int getDepth(){
        return this.depth;
    }
}

public class Main {
    static Queue<Node> q = new LinkedList<>();
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException{
        int N,K;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(new Node(N,0),K);
    }
    private static void bfs(Node node, int end) {
        q.add(node);
        visited[node.getN()] = true;
        while(true){
            Node thisNode = q.poll();
            int thisN = thisNode.getN();
            int thisDepth = thisNode.getDepth();

            if(thisN == end){
                System.out.println(thisNode.getDepth());
                break;
            }


            if(thisN - 1 >= 0){
                if(!visited[thisN - 1]){
                    q.add(new Node(thisN - 1,thisDepth+1));
                    visited[thisN - 1] = true;
                }
            }
            if(thisN + 1 <= 100000){
                if(!visited[thisN + 1]){
                    q.add(new Node(thisN + 1,thisDepth+1));
                    visited[thisN + 1] = true;
                }
            }
            if(thisN * 2 <= 100000){
                if(!visited[thisN * 2]){
                    q.add(new Node(thisN * 2,thisDepth+1));
                    visited[thisN * 2] = true;
                }
            }
        }
    }
}
