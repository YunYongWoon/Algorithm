package ex1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int five = 0;
        
        while(n>=5){
            five += n / 5;
            n /= 5;
        }
        
        System.out.println(five);
    }
}
