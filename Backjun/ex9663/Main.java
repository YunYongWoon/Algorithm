package ex9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int output = 0;

    public static void main(String[] args) throws IOException {
        int n;
        int[] arr;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];

        solve(arr, n, 0);
        System.out.println(output);
    }

    static void solve(int[] arr, int n, int depth) {
        if (depth == n) {
            output++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(arr, i, depth)) {
                arr[depth] = i;
                solve(arr, n, depth + 1);
            }
        }
        return;
    }

    static boolean check(int[] arr, int pos, int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == pos || Math.abs(arr[i] - pos) == Math.abs(i - depth)) {
                return false;
            }
        }
        return true;
    }
}
