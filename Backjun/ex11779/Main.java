package ex11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    private int dist, node;

    public Node(int node, int dist) {
        this.dist = dist;
        this.node = node;
    }

    public int getDist() {
        return dist;
    }

    public int getNode() {
        return node;
    }

    @Override
    public int compareTo(Node o) {
        return dist - o.getDist();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        int n, m, start, end, count = 1;
        ArrayList<Node>[] map = new ArrayList[1001];
        PriorityQueue<Node> que = new PriorityQueue<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());

        for(int i=0;i<n+1;i++){
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            map[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        int[] visited = new int[n + 1];
        int[] beforeNode = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        end = Integer.parseInt(st.nextToken());

        visited[start] = 0;
        beforeNode[start] = -1;
        que.offer(new Node(start,0));
        
        while (!que.isEmpty()) {
            Node thisN = que.poll();
            int thisNode = thisN.getNode();
            int dist = thisN.getDist();

            if(thisNode == end){
                break;
            }

            for (Node node : map[thisNode]) {
                int nextNode = node.getNode();
                int nextDist = node.getDist();

                if(dist + nextDist < visited[nextNode]){
                    visited[nextNode] = dist + nextDist;
                    que.offer(new Node(nextNode, visited[nextNode]));
                    beforeNode[nextNode] = thisNode;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int beforeNodeNum = beforeNode[end];
        while (beforeNodeNum != -1) {
            stack.push(beforeNodeNum);
            beforeNodeNum = beforeNode[beforeNodeNum];
            count++;
        }
        System.out.println(visited[end]);
        System.out.println(count);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.print(sb);
    }
}
