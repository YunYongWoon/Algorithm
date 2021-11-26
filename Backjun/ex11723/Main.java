package ex11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] array = new boolean[21];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int M = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            String method = st.nextToken();
            int x = 0;
            if(st.hasMoreTokens()){
                x = Integer.parseInt(st.nextToken());
            }

            switch (method) {
                case "add":
                    add(x);
                    break;
                case "remove":
                    remove(x);
                    break;
                case "check":
                    check(x);
                    break;
                case "toggle":
                    toggle(x);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }

    static void add(int x) {
        array[x] = true;
    }

    static void remove(int x) {
        array[x] = false;
    }

    static void check(int x) {
        if(array[x]){
            sb.append("1\n");
        } else {
            sb.append("0\n");
        }
    }

    static void toggle(int x) {
        array[x] = !array[x];
    }

    static void all() {
        Arrays.fill(array, true);
    }

    static void empty() {
        Arrays.fill(array, false);
    }
}
