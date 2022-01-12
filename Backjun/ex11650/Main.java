package ex11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pos implements Comparable<Pos>{
    int x; 
    int y;

    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pos o) {
        if(this.x < o.x){
            return -1;
        } else if(this.x > o.x) {
            return 1;
        } else {
            if(this.y < o.y){
                return -1;
            } else {
                return 1;
            }
        }
    }

    public void print(){
        System.out.println(x + " " + y);
    }

}
public class Main {
    public static void main(String[] args) throws IOException{
        int N;
        PriorityQueue<Pos> que = new PriorityQueue<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            que.add(new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        while(!que.isEmpty()){
            que.poll().print();
        }
    }
}
