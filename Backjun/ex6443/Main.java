package ex6443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int testcase;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		int depth;
		String input;
		char[] inputArr, outputArr;
		boolean[] usedArr;

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		testcase = Integer.parseInt(bf.readLine());
		for (int i = 0; i < testcase; i++) {
			input = bf.readLine();
			inputArr = input.toCharArray();
			Arrays.sort(inputArr);
			depth = inputArr.length;
			outputArr = new char[depth];
			usedArr = new boolean[depth];
			solution(inputArr, outputArr, usedArr, depth, 0);
		}
		System.out.print(sb);
	}

	static void solution(char[] inputArr, char[] outputArr, boolean[] usedArr, int depth, int current) {
		if(current == depth){
			sb.append(String.valueOf(outputArr) + "\n");
			return;
		}
		for (int i = 0; i < depth; i++) {
			if (outputArr[current] != inputArr[i] && !usedArr[i]){
				outputArr[current] = inputArr[i];
				usedArr[i] = true;
				solution(inputArr, outputArr, usedArr, depth, current + 1);
				usedArr[i] = false;
			}
		}
		outputArr[current] = 0;
		return;
	}
}
