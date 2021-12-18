package ex6581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        String str = "", answer = "";
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while ((str = bf.readLine()) != null) {
            st = new StringTokenizer(str);
        
            while (st.hasMoreElements()) {
                String nextWord = st.nextToken();

                if (nextWord.equals("<br>")) {
                    sb.append(answer.trim()).append("\n");
                    answer = "";
                } else if (nextWord.equals("<hr>")) {
                    if (answer.length() != 0) {
                        sb.append(answer.trim()).append("\n");
                        answer = "";
                    }
                    sb.append("-".repeat(80)).append("\n");
                } else {
                    if ((answer + nextWord).length() > 80) {
                        sb.append(answer.trim()).append("\n");
                        answer = "";
                    } 
                    answer += nextWord + " ";
                }
            }
        }
        sb.append(answer.trim());
        System.out.println(sb);
    }
}