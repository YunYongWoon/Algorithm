package ex9935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] testStr = bf.readLine().toCharArray();
        char[] checkStr = bf.readLine().toCharArray();
        int testStrLength = testStr.length;
        int checkStrLength = checkStr.length;
        int thisLength = testStrLength;
        for (int i = 0; i < thisLength; i++) {
            stack.add(testStr[i]);

            if (stack.size() >= checkStrLength) {
                boolean bomb = true;
                if (stack.peek() == checkStr[checkStrLength - 1]) {
                    for (int j = 0; j < checkStrLength; j++) {
                        if (checkStr[j] != stack.get(stack.size() - checkStrLength + j)) {
                            bomb = false;
                            break;
                        }
                    }
                    if (bomb) {
                        for (int j = 0; j < checkStrLength; j++) {
                            stack.pop();
                        }
                        testStrLength -= checkStrLength;
                    }
                }
            }
        }

        for(char c : stack){
            bw.write(c);
        }

        if (testStrLength == 0) {
            System.out.println("FRULA");
        } else { 
            bw.flush();
        }
    }
}