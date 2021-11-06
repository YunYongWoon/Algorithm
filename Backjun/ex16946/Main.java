package ex16946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int i, j;

    public Pos(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}

public class Main {
    static int N, M;
    static int[] di = { 1, -1, 0, 0 };
    static int[] dj = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Queue<Pos> que = new LinkedList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][][] map = new int[N][M][2];
        int[] countArr = new int[N*M/2+2];

        for (int i = 0; i < N; i++) {
            String[] split = bf.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j][0] = Integer.parseInt(split[j]);
            }
        }

        int group = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j][0] == 0 && map[i][j][1] == 0) {
                    que.add(new Pos(i, j));
                    map[i][j][1] = group;
                    int count = 1;
                    while (!que.isEmpty()) {
                        Pos thisPos = que.poll();
                        for (int k = 0; k < 4; k++) {
                            int nextI = thisPos.getI() + di[k];
                            int nextJ = thisPos.getJ() + dj[k];
                            if (nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= M || map[nextI][nextJ][0] == 1
                                    || map[nextI][nextJ][1] != 0) {
                                continue;
                            }
                            que.add(new Pos(nextI, nextJ));
                            count++;
                            map[nextI][nextJ][1] = group;
                        }
                    }
                    countArr[group] = count;
                    group++;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j][0] == 1){
                    HashSet<Integer> hash = new HashSet<>();
                    for(int k=0;k<4;k++){
                        if(i + di[k] >=0 && i + di[k] < N && j+dj[k] >=0 && j+dj[k] < M && !hash.contains(map[i+di[k]][j+dj[k]][1])){
                            hash.add(map[i+di[k]][j+dj[k]][1]);
                        }
                    }
                    int total = 1;
                    for (int k : hash) {
                        total += countArr[k];           
                    }
                    map[i][j][0] = total % 10;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j][0]);
            }
            if(i<N-1)
                sb.append("\n");
        }
        System.out.println(sb);
    }
}
