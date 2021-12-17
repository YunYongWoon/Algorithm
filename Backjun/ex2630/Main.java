package ex2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] map;
    static int zero = 0, one = 0;
    public static void main(String[] args) throws IOException{
        int N;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        map = new String[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = st.nextToken();
            }
        }

        solve(N, 0, 0);

        System.out.println(zero);
        System.out.println(one);
    }

    static void solve(int N, int i, int j){
        if(!check(N,i,j)) {
            solve(N/2, i,j);
            solve(N/2, i+N/2, j);
            solve(N/2, i, j+N/2);
            solve(N/2, i+N/2, j+N/2);
        } else {
            return;
        }
    }

    static boolean check(int N, int i, int j){
        String checker = map[i][j];
        for(int ii = i; ii<N+i; ii++){
            for(int jj=j;jj<N+j;jj++){
                if(!checker.equals(map[ii][jj])){
                    return false;
                }
            }
        }

        if(checker.equals("1")){
            one++;
        } else if(checker.equals("0")){
            zero++;
        }
        return true;
    }
}
