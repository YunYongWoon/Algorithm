package ex12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    private int x, count;

    public Pos(int x, int count) {
        this.x = x;
        this.count = count;
    }

    public int getX() {
        return x;
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    static int N, M;
    static int arrivedTime = 0;
    static int arrivedCase = 0;
    static int[] visited = new int[100001];
    static Queue<Pos> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        que.add(new Pos(N, 1));
        visited[N] = 1;
        while (!que.isEmpty()) {
            Pos thisPos = que.poll();
            int thisX = thisPos.getX();
            int thisCount = thisPos.getCount();

            if(arrivedTime == 0){
                if(thisX == M){
                    arrivedTime = thisCount;
                    arrivedCase++;
                    continue;
                }
                if (thisX + 1 < 100001 && (visited[thisX + 1] == thisCount + 1 || visited[thisX+1] == 0)) {
                    visited[thisX + 1] = thisCount + 1;
                    que.add(new Pos(thisX + 1, thisCount + 1));
                } 
                if (thisX - 1 >= 0 && (visited[thisX - 1] == thisCount + 1 || visited[thisX-1] == 0)) {
                    visited[thisX - 1] = thisCount + 1;
                    que.add(new Pos(thisX - 1, thisCount + 1));
                }
                if (thisX * 2 < 100001 && (visited[thisX * 2] == thisCount + 1 || visited[thisX*2] == 0)) {
                    visited[thisX * 2] = thisCount + 1;
                    que.add(new Pos(thisX * 2, thisCount + 1));
                }
            } else {
                if(thisX == M && thisCount == arrivedTime){
                        arrivedCase++;
                }
            }
        }
        System.out.println(arrivedTime-1);
        System.out.print(arrivedCase);
    }
}
