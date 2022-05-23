package ex10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		Stack<Integer> stack = new Stack<>(); 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int inputCase = Integer.parseInt(bf.readLine());
		int answer = 0;

		for(int i = 0; i < inputCase; i++) {
			int input = Integer.parseInt(bf.readLine());
			if (input == 0) {
				stack.pop();
			} else {
				stack.push(input);
			}
		}

		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
		System.out.println(answer);
	}
}
