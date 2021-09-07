package ex1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int idx, dist;

    public Node(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }

    public int getIdx(){
        return this.idx;
    }

    public int getDist(){
        return this.dist;
    }

    @Override
    public int compareTo(Node o) {
        if(this.dist < o.dist)
            return -1;
        return 1;
    }
}

public class Main {
    public static final int INF = (int)1e9;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] distance = new int[1001];

    public static void dajkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int dist = node.getDist();
            int idx = node.getIdx();

            if(distance[idx] < dist) continue;

            for(int i=0;i<graph.get(idx).size();i++){
                int cost = distance[idx] + graph.get(idx).get(i).getDist();

                if(cost<distance[graph.get(idx).get(i).getIdx()]){
                    distance[graph.get(idx).get(i).getIdx()] = cost;
                    pq.offer(new Node(graph.get(idx).get(i).getIdx(),cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        int N,M,start,end;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<Node>());
        }
        Arrays.fill(distance, INF);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
        }

        st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dajkstra(start);

        System.out.println(distance[end]);
    }
}
