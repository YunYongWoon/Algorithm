package ex14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dice{
    int[][] diceMap = new int[4][3];

    public void move(int pos){
        int temp;
        switch(pos){
            case 1:
                temp = diceMap[1][1];
                diceMap[1][1] = diceMap[1][0];
                diceMap[1][0] = diceMap[3][1];
                diceMap[3][1] = diceMap[1][2];
                diceMap[1][2] = temp;
                break;
            case 2:
                temp = diceMap[1][1];
                diceMap[1][1] = diceMap[1][2];
                diceMap[1][2] = diceMap[3][1];
                diceMap[3][1] = diceMap[1][0];
                diceMap[1][0] = temp;
                break;
            case 3:
                temp = diceMap[1][1];
                diceMap[1][1] = diceMap[0][1];
                diceMap[0][1] = diceMap[3][1];
                diceMap[3][1] = diceMap[2][1];
                diceMap[2][1] = temp;
                break;
            case 4:
                temp = diceMap[1][1];
                diceMap[1][1] = diceMap[2][1];
                diceMap[2][1] = diceMap[3][1];
                diceMap[3][1] = diceMap[0][1];
                diceMap[0][1] = temp;
                break;
            default:
                break;
        }
    }

    public int getDown(){
        return diceMap[3][1];
    }

    public void setDown(int down){
        diceMap[3][1] = down;
    }

    public int getUp(){
        return diceMap[1][1];
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N,M,x,y,k;
        int[] dx = {0,0,0,-1,1};
        int[] dy = {0,1,-1,0,0};
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }      
        
        st = new StringTokenizer(bf.readLine());
        Dice dice = new Dice();
        while(st.hasMoreTokens()){
            int command = Integer.parseInt(st.nextToken());

            if(x+dx[command] < 0 || x+dx[command] >= N || y+dy[command] < 0 || y+dy[command] >= M){
                continue;
            } else {
                x += dx[command];
                y += dy[command];
                dice.move(command);

                if(map[x][y] == 0){
                    map[x][y] = dice.getDown();
                } else {
                    dice.setDown(map[x][y]);
                    map[x][y] = 0;
                }

                System.out.println(dice.getUp());
            }
        }

    }
}
