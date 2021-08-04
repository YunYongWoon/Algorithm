package ex2178;

import java.io.*;
import java.util.*;

class Node{
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}

public class Main {
    public static Integer[][] graph;
    public static int n,m;
    public static int count = 0; 
    // 방향 - 위 아래 좌 우
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};


    static int bfs(int x, int y){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x,y));

        while(!que.isEmpty()){
            Node node = que.poll();
            for(int i=0;i<4;i++){
                int nextX = node.getX() + dx[i];
                int nextY = node.getY() + dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m )
                    continue;
                if(graph[nextX][nextY] == 0)
                    continue;

                if(graph[nextX][nextY] == 1){
                    que.add(new Node(nextX, nextY));
                    graph[nextX][nextY] = graph[node.getX()][node.getY()]+1;
                }
            }
        }
        return graph[n-1][m-1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        // n,m 입력
        n = Integer.parseInt(st.nextToken()) + 1;
        m = Integer.parseInt(st.nextToken()) + 1;

        // 그래프 생성
        graph = new Integer[n][m];
        // 그래프 초기화
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m ; j++){
                graph[i][j] = 0;
            }
        }
        // 그래프에 미로 입력
        for(int i = 1; i<n; i++){
            String str = bf.readLine();
            String[] arr = str.split("");
            for(int j = 1; j<m ; j++){
                graph[i][j] = Integer.parseInt(arr[j-1]);
            }
        }
        
        System.out.print(bfs(1,1));
    }
}
