package ex5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        int count = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        String s = bf.readLine(); //String
        int pay = 1000 - Integer.parseInt(s); //Int

        int[] charge = {500,100,50,10,5,1};

        for(int i=0;i<charge.length;i++){   
            count += pay / charge[i];
            pay = pay % charge[i];

            if(pay == 0)
                break;
        }

        System.out.println(count);
    }
}
