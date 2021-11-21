package ex9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int testCase = 0;
        int arrLength = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        testCase = Integer.parseInt(bf.readLine());

        for (int test = 0; test < testCase; test++) {
            arrLength = Integer.parseInt(bf.readLine());
            int[][] dpList = new int[2][100001];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < arrLength; j++) {
                    dpList[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // dp 구현
            dpList[0][1] += dpList[1][0];
            dpList[1][1] += dpList[0][0];

            for (int i = 2; i < arrLength; i++) {
                dpList[0][i] += Math.max(dpList[1][i - 1], dpList[1][i - 2]);
                dpList[1][i] += Math.max(dpList[0][i - 1], dpList[0][i - 2]);
            }

            System.out.println(Math.max(dpList[0][arrLength-1],dpList[1][arrLength-1]));
        }
    }
}
