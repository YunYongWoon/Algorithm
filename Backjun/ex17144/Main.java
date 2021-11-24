package ex17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R,C,T;
    static int [][][] map;
    static int aircon1, aircon2;
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        boolean isAirconInput = true;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C][2];
        for(int i = 0;i<R;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<C;j++){
                map[i][j][0] = Integer.parseInt(st.nextToken());
                if(isAirconInput && map[i][j][0] == -1){
                    aircon1 = i;
                    aircon2 = aircon1+1;
                    isAirconInput = false;
                }
            }
        }

        for(int t=0;t<T;t++){
            // 1. 먼지 퍼트리기
            spreadDust();
            addDust();
            // showMap1();
            // 2. 에어컨 가동
            airconUpOn();
            airconDownOn();
        }
        // showMap1();
        System.out.println(answer());
    }

    static void spreadDust(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                int count = 4;
                boolean upBlock = false;
                boolean downBlock = false;
                boolean rightBlock = false;
                boolean leftBlock =false;
                if(map[i][j][0] != -1){
                    int dust = map[i][j][0] / 5;

                    if(i - 1 < 0 || map[i-1][j][0] == -1){
                        upBlock = true;
                        count--;
                    }

                    if(i+1>=R || map[i+1][j][0] == -1){
                        downBlock = true;
                        count--;
                    }

                    if(j-1 < 0 || map[i][j-1][0] == -1){
                        leftBlock = true;
                        count--;
                    }

                    if(j+1>=C){
                        rightBlock = true;
                        count--;
                    }

                    map[i][j][0] -= dust*count;

                    if(!upBlock){
                        map[i-1][j][1] += dust;
                    }
                    if(!downBlock){
                        map[i+1][j][1] += dust;
                    }
                    if(!leftBlock){
                        map[i][j-1][1] += dust;
                    }
                    if(!rightBlock){
                        map[i][j+1][1] += dust;
                    }
                }
            }
        }
    }

    static void addDust(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                map[i][j][0] += map[i][j][1];
                map[i][j][1] = 0;
            }
        }
    }

    static void airconUpOn(){
        int ariconSwitch = 0;
        int curI = aircon1-1;
        int curJ = 0;

        while(ariconSwitch<4){
            switch(ariconSwitch){
                case 0:
                    if(curI - 1 < 0){
                        curI = 0;
                        ariconSwitch++;
                        break;
                    }
                    map[curI][0][0] = map[curI-1][0][0];
                    curI--;
                    break;
                case 1:
                    if(curJ + 1 >= C){
                        curJ = C-1;
                        ariconSwitch++;
                        break;
                    }
                    map[0][curJ][0] = map[0][curJ+1][0];
                    curJ++;
                    break;
                case 2:
                    if(curI+1 > aircon1){
                        curI = aircon1;
                        ariconSwitch++;
                        break;
                    }
                    map[curI][C-1][0] = map[curI+1][C-1][0];
                    curI++;
                    break;
                case 3:
                    if(curJ - 1 < 1){
                        curJ = 0;
                        ariconSwitch++;
                        break;
                    }
                    map[aircon1][curJ][0] = map[aircon1][curJ-1][0];
                    curJ--;
                default:
                    break;          
            }
        }
        map[aircon1][1][0] = 0;
    }

    static void airconDownOn(){
        int ariconSwitch = 0;
        int curI = aircon2+1;
        int curJ = 0;

        while(ariconSwitch<4){
            switch(ariconSwitch){
                case 0:
                    if(curI+1 >= R){
                        curI = R-1;
                        ariconSwitch++;
                        break;
                    }
                    map[curI][0][0] = map[curI+1][0][0];
                    curI++;
                    break;
                case 1:
                    if(curJ + 1 >= C){
                        curJ = C-1;
                        ariconSwitch++;
                        break;
                    }
                    map[R-1][curJ][0] = map[R-1][curJ+1][0];
                    curJ++;
                    break;
                case 2:
                    if(curI-1 < aircon2){
                        curI = aircon2;
                        ariconSwitch++;
                        break;
                    }
                    map[curI][C-1][0] = map[curI-1][C-1][0];
                    curI--;
                    break;
                case 3:
                    if(curJ - 1 < 1){
                        curJ = 0;
                        ariconSwitch++;
                        break;
                    }
                    map[aircon2][curJ][0] = map[aircon2][curJ-1][0];
                    curJ--;
                default:
                    break;          
            }
        }
        map[aircon2][1][0] = 0;
    }

    static int answer(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j][0] != -1){
                    answer += map[i][j][0];
                }
            }
        }
        return answer;
    }

    // static void showMap1(){
    //     System.out.println();

    //     for(int i=0;i<R;i++){
    //         for(int j=0;j<C;j++){
    //             System.out.print(map[i][j][0] + " ");
    //         }
    //         System.out.println();
    //     }
    // }
}
