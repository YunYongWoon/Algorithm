package ex1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();

        int count = 0;

        String[] arr = s.split(" ");

        for(String text : arr){
            if(text == "")
                count++;
        }

        System.out.println(arr.length-count);
    }
}
