package ex2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean end = false;
    static void per(int[] arr, int[] output, boolean[] visited, int depth, int n, int r, String[] testCase) {
        if(depth == r) {
            if(check(output, testCase)) {
                for(int i:output){
                    System.out.print(i);
                }    
                end = true;
                return;
            }
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                per(arr, output, visited, depth + 1, n, r, testCase);
                visited[i] = false; 
                if(end) break;
            }
        }
    }

    static boolean check(int[] arr, String[] list) {
        int count = list.length;
        for (int i = 0; i < count; i++) {
            if(list[i].equals(">") && arr[i] > arr[i+1] || list[i].equals("<") && arr[i] < arr[i+1])
                continue;   
            else 
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int k;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(bf.readLine());
        String[] testCase = new String[k];
        boolean[] visited = new boolean[k+1];
        int[] output = new int[k+1];
        int[] minArr = new int[k+1];
        int[] maxArr = new int[k+1];

        for (int i = 0; i <= k; i++) {
            minArr[i] = i;
            maxArr[i] = 9-i;
        }

        String sample = bf.readLine();
        testCase = sample.split(" ");

        per(maxArr, output, visited, 0, k+1, k+1, testCase);
        end = false;
        System.out.println();
        per(minArr, output, visited, 0, k+1, k+1, testCase);
    }
}
