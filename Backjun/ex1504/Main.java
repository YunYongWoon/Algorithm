package ex1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    
    private int pos, dist;

    public Node(int pos, int dist) {
        this.pos = pos;
        this.dist = dist;
    }

    public int getPos() {
        return pos;
    }

    public int getDist() {
        return dist;
    }

    @Override
    public int compareTo(Node o) {
        return dist - o.getDist();
    }
}

public class Main {
    static ArrayList<Node>[] map = new ArrayList[801];
    static final int MAX = 200000001;
    public static void main(String[] args) throws IOException {
        int N, E, wayPoint1, wayPoint2;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int[] wp1, wp2;

        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a].add(new Node(b, c));
            map[b].add(new Node(a, c));
        }

        st = new StringTokenizer(bf.readLine());
        wayPoint1 = Integer.parseInt(st.nextToken());
        wayPoint2 = Integer.parseInt(st.nextToken());

        wp1 = djikstra(wayPoint1, N);
        wp2 = djikstra(wayPoint2, N);

        int case1 = wp1[1] + wp1[wayPoint2] + wp2[N]; //1 -> wp1 -> wp2 -> N
        int case2 = wp1[N] + wp2[wayPoint1] + wp2[1]; //N -> wp1 -> wp2 -> 1
        int case3 = wp1[N] + 2*wp2[wayPoint1] + wp1[1]; //1 -> wp1 -> wp2 -> wp1 -> N
        int case4 = wp2[N] + 2*wp2[wayPoint1] + wp2[1]; //N -> wp2 -> wp1 -> wp2 -> N

        int answer1 = (case1 > MAX && case2 > MAX) ? -1 : Math.min(case1,case2);
        int answer2 = (case3 > MAX && case4 > MAX) ? -1 : Math.min(case3,case4);
        int answer = (answer1 == -1 && answer2 == -1) ? -1 : Math.min(answer1,answer2);
        System.out.println(answer);
    }

    static int[] djikstra(int startPoint, int nodeCount){
        int[] djikstraMap = new int[nodeCount+1];
        Arrays.fill(djikstraMap, MAX);
        boolean[] check = new boolean[nodeCount+1];
  
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(startPoint, 0));
        djikstraMap[startPoint] = 0;

        while(!que.isEmpty()){
            Node thisNode = que.poll();
            int thisNodePos = thisNode.getPos();
            if(check[thisNodePos]){
                continue;
            }
            check[thisNodePos] = true;
            for (Node node : map[thisNodePos]) {
                int nextNodePos = node.getPos();
                int nextNodeDist = node.getDist();

                if(djikstraMap[thisNodePos] + nextNodeDist < djikstraMap[nextNodePos]){
                    djikstraMap[nextNodePos] = djikstraMap[thisNodePos] + nextNodeDist;
                    que.offer(new Node(nextNodePos, djikstraMap[nextNodePos]));
                }
            }
        }
        return djikstraMap;
    }
}
