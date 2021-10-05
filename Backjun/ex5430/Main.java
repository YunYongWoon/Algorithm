package ex5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        int testCase, arrCase;
        boolean reverse = true;
        String[] command, arr;
        String error = "error";
        Deque<String> deq = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        testCase = Integer.parseInt(bf.readLine());

        for (int i = 0; i < testCase; i++) {
            StringBuilder sb = new StringBuilder();
            String str = bf.readLine();
            command = str.split("");
            arrCase = Integer.parseInt(bf.readLine());
            str = bf.readLine();
            str = str.substring(1, str.length() - 1);
            arr = str.split(",");
            for (int j = arr.length - 1; j >= 0; j--) {
                deq.addFirst(arr[j]);
            }
            for (String s : command) {
                if (s.equals("R")) {
                    reverse = !reverse;
                } else if (s.equals("D")) {
                    if (reverse) {
                        deq.pollFirst();
                    } else {
                        deq.pollLast();
                    }
                    arrCase--;
                }
            }
            if (arrCase < 0) {
                System.out.println(error);
            } else {
                sb.append("[");
                while (!deq.isEmpty()) {
                    if(reverse)
                        sb.append(deq.pollFirst());
                    else
                        sb.append(deq.pollLast());
                    if (!deq.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
            deq.clear();
            reverse = true;
        }
    }
}
