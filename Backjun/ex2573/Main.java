package ex2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
    int i,j;
    public Pos(int i, int j){
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static int n, m;
    static int[][][] map;
    static int answer = 0;
    static int[] di = { 1, -1, 0, 0 };
    static int[] dj = { 0, 0, 1, -1 };
    static Queue<Pos> que = new LinkedList<>();
    static boolean isMelt = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
            }
        }

        boolean trigger = true;

        while (trigger) {
            isMelt = false;
            melt();  
            trigger = check();
        }
        if(!isMelt) answer = 0;

        System.out.println(answer);
    }

    static void melt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j][0] != 0) {
                    isMelt = true;
                    int iceMelt = 0;
                    for (int k = 0; k < 4; k++) {
                        if (i + di[k] >= 0 && i + di[k] < n && j + dj[k] >= 0 && j + dj[k] < m) {
                            if(map[i+di[k]][j+dj[k]][0] == 0){
                                iceMelt++;
                            }
                        }
                    }
                    map[i][j][1] = map[i][j][0] - iceMelt > 0 ? map[i][j][0] - iceMelt : 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j][0] = map[i][j][1];
                map[i][j][1] = 0;
            }
        }
    }

    static boolean check() {
        int iceberg = 0;
        answer++;
        if(!isMelt){
            return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j][0] != 0 && map[i][j][1] != 1){
                    iceberg++;
                    que.add(new Pos(i,j));
                    map[i][j][1] = 1;
                    bfs();
                }

                if(iceberg > 1){
                    return false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j][1] = 0;
            }
        }

        return true;
    }

    static void bfs(){
        while(!que.isEmpty()){
            Pos thisPos = que.poll();
            int thisI = thisPos.i;
            int thisJ = thisPos.j;

            for (int k = 0; k < 4; k++) {
                if (thisI + di[k] >= 0 && thisI + di[k] < n && thisJ + dj[k] >= 0 && thisJ + dj[k] < m) {
                    if(map[thisI+di[k]][thisJ+dj[k]][0] != 0 && map[thisI+di[k]][thisJ+dj[k]][1] == 0){
                        que.add(new Pos(thisI+di[k], thisJ+dj[k]));
                        map[thisI+di[k]][thisJ+dj[k]][1] = 1;
                    }
                }
            }
        }
    }
}