package ex10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int i,j;
    public Node(int i, int j){
        this.i = i;
        this.j = j;
    }

    public int getI(){
        return i;
    }

    public int getJ(){
        return j;
    }
}

public class Main {
    static boolean[][] visited = new boolean[100][100];
    static String[][] graph = new String[100][100];
    static Queue<Node> queue = new LinkedList<>();
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    static void nonRGBCount(int i, int j, int N){
        queue.add(new Node(i,j));
        visited[i][j] = true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int thisI = node.getI();
            int thisJ = node.getJ();
            String thisRGB = graph[thisI][thisJ];
            System.out.println(thisRGB);

            for(int k=0;k<4;k++){
                if(thisI + di[k] < 0 || thisI + di[k] >= N || thisJ + dj[k] < 0 || thisJ + dj[k] >= N){
                    continue;
                }    
                String nextRGB = graph[thisI + di[k]][thisJ + dj[k]] ;
                boolean nextVisited = visited[thisI + di[k]][thisJ + dj[k]];
                if(nextVisited || !thisRGB.equals(nextRGB)){
                    continue;
                }
                else {
                    queue.add(new Node(thisI + di[k],thisJ + dj[k]));
                    visited[thisI + di[k]][thisJ + dj[k]] = true;
                }
            }
        }
    }

    static void RGBCount(int i, int j, int N){
        queue.add(new Node(i,j));
        visited[i][j] = false;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int thisI = node.getI();
            int thisJ = node.getJ();
            String thisRGB = graph[thisI][thisJ];
            System.out.println(thisRGB);

            for(int k=0;k<4;k++){
                if(thisI + di[k] < 0 || thisI + di[k] >= N || thisJ + dj[k] < 0 || thisJ + dj[k] >= N){
                    continue;
                }    
                String nextRGB = graph[thisI + di[k]][thisJ + dj[k]] ;
                boolean nextVisited = visited[thisI + di[k]][thisJ + dj[k]];
                if(!nextVisited || !thisRGB.equals(nextRGB)){
                    continue;
                }
                else {
                    queue.add(new Node(thisI + di[k],thisJ + dj[k]));
                    visited[thisI + di[k]][thisJ + dj[k]] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        int N;
        int nonRGB = 0;
        int RGB = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        for(int i =0;i<N;i++){
            graph[i] = bf.readLine().split("");
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    nonRGBCount(i, j, N);
                    nonRGB++;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j].equals("R")){
                    graph[i][j] = "G";
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]){
                    RGBCount(i, j, N);
                    RGB++;
                }
            }
        }

        System.out.println(nonRGB + " " + RGB);

    }
}
