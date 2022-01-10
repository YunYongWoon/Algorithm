package ex1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String[] input = bf.readLine().split("");

        Stack<String> stack1= new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for (String string : input) {
            stack1.push(string);
        }
        int M = Integer.parseInt(bf.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            switch (st.nextToken()) {
                case "L":
                    if(!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                    break;
                    case "D":
                    if(!stack2.isEmpty()){
                        stack1.push(stack2.pop());
                    }
                    break;
                case "B":
                    if(!stack1.isEmpty()){
                        stack1.pop();
                    }
                    break;
                case "P":
                    stack1.push(st.nextToken());
                    break;
            }
        }

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        while(!stack2.isEmpty()){
            sb.append(stack2.pop());
        }

        System.out.println(sb);
    }
}
