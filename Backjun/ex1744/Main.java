package ex1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        int N, answer = 0;
        int[] arr;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> waitStack = new Stack<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);

        for (Integer integer : arr) {
            if(integer >= 1){
                stack.push(integer);
            } else {
                waitStack.push(integer);
            }
        }
        answer = solution(answer, stack);

        while(!waitStack.isEmpty()){
            stack.push(waitStack.pop());
        }
        answer = solution(answer, stack);

        System.out.println(answer);
    }

    static int solution(int answer, Stack<Integer> stack){
        while(!stack.isEmpty()){
            int first = stack.pop();
            if(stack.isEmpty()){
                answer += first;
                break;
            }
            int second = stack.pop();

            if(first + second < first * second){
                answer += first * second;
            } else {
                answer += first;
                stack.push(second);
            }
        }
        return answer;
    }
}