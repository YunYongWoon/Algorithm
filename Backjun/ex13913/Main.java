package ex13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Pos{
    int x,count;
    Pos beforePos;

    public Pos(int x, int count, Pos beforePos){
        this.x = x;
        this.count = count;
        this.beforePos = beforePos;
    }

    public int getX(){
        return x;
    }

    public int getCount(){
        return count;
    }

    public Pos getBefore(){
        return beforePos;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        int N,M;
        Queue<Pos> que = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited[N] = true;
        que.add(new Pos(N,0,null));

        while(!que.isEmpty()){
            Pos thisPos = que.poll();
            int thisX = thisPos.getX();
            int thisCount = thisPos.getCount();

            if(thisX == M){
                System.out.println(thisCount);
                int[] history = new int[thisCount+1];
                history[0] = N;
                while(true){
                    if(thisPos.getBefore() == null){
                        break;
                    }
                    history[thisPos.getCount()] = thisPos.getX();
                    thisPos = thisPos.getBefore();
                }
                for (int i : history) {
                    System.out.print(i + " ");
                }
                break;
            }

            if(thisX+1 < 100001 && !visited[thisX+1]){
                visited[thisX+1] = true;
                que.add(new Pos(thisX+1,thisCount+1,thisPos));
            }
            if(thisX-1 >= 0 && !visited[thisX-1]){
                visited[thisX-1] = true;
                que.add(new Pos(thisX-1,thisCount+1,thisPos));
            }
            if(thisX*2 < 100001 && !visited[thisX*2]){
                visited[thisX*2] = true;
                que.add(new Pos(thisX*2,thisCount+1,thisPos));
            }
        }      
    }
}
