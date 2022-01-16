package ex10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = bf.readLine();
        int answer = 0;

        String[] arr = input.split("");
        Integer[] intArr = new Integer[arr.length];

        for(int i=0;i<arr.length;i++){
            intArr[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(intArr,Collections.reverseOrder());

        if(intArr[intArr.length-1] != 0){
            System.out.println(-1);
        } else {
            for (Integer integer : intArr) {
                answer+=integer;
            }

            if(answer % 3 == 0){
                for (Integer integer : intArr) {
                    sb.append(integer);
                }
                System.out.println(sb);
            } else {
                System.out.println(-1);
            }
        }
    }
}