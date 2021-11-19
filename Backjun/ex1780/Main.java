package ex1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static int a = 0, b = 0, c = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, n);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    static void solve(int i, int j, int count) {
        if (check(i, j, count)) {
            int number = map[i][j];
            switch (number) {
            case -1:
                a++;
                break;
            case 0:
                b++;
                break;
            case 1:
                c++;
                break;
            default:
                break;
            }
        } else {
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    solve(i + count / 3 * k, j + count / 3 * l, count / 3);
                }
            }
        }
    }

    static boolean check(int i, int j, int count) {
        int check = map[i][j];
        for (int k = i; k < i + count; k++) {
            for (int l = j; l < j + count; l++) {
                if (map[k][l] != check) {
                    return false;
                }
            }
        }
        return true;
    }
}
