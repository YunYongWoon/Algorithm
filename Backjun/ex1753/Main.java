package ex1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int idx,dist;

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
        if(this.dist < o.getDist()){
            return -1;
        }
        return 1;
    }
}

public class Main {
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] distance = new int[20001];
    public final static int INF = (int)1e9;

    public static void dajkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int idx = node.getIdx();
            int dist = node.getDist();

            if(distance[idx] < dist) continue;

            for(int i=0;i<graph.get(idx).size();i++){
                int cost = distance[idx] + graph.get(idx).get(i).getDist();

                if(distance[graph.get(idx).get(i).getIdx()] > cost){
                    distance[graph.get(idx).get(i).getIdx()] = cost;
                    pq.offer(new Node(graph.get(idx).get(i).getIdx(),cost));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        int V,E,K;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(bf.readLine());

        for(int i=0;i<=V;i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v,k));
        }
        Arrays.fill(distance,INF);
        
        dajkstra(K);

        for(int i = 1;i<=V;i++){
            if(distance[i] == INF)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }
    }
}
