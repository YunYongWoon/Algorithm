package ex13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node {
    private int pos, time;

    public Node(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }

    public int getPos(){
        return pos;
    }

    public int getTime(){
        return time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        int start, finish, ans = 0;
        boolean[] visited = new boolean[200001];
        Deque<Node> deq = new LinkedList<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        start = Integer.parseInt(st.nextToken());
        finish = Integer.parseInt(st.nextToken());

        deq.addLast(new Node(start, 0));
        visited[start] = true;

        while (!deq.isEmpty()) {
            Node thisNode = deq.pollFirst();
            int thisPos = thisNode.getPos();
            int thisTime = thisNode.getTime();

            if (thisPos == finish) {
                System.out.println(thisTime);
                break;
            }

            if (thisPos * 2 <= 100000 && !visited[thisPos * 2]) {
                deq.addFirst(new Node(thisPos * 2, thisTime));
                visited[thisPos*2] = true;
            }

            if (thisPos + 1 <= 100000 && !visited[thisPos + 1]) {
                deq.addLast(new Node(thisPos + 1, thisTime + 1));
                visited[thisPos+1] = true;
            }

            if (thisPos - 1 >= 0 && !visited[thisPos - 1]) {
                deq.addLast(new Node(thisPos - 1, thisTime + 1));
                visited[thisPos-1] = true;
            }
        }
    }
}
