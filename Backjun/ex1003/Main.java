package ex1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Pair {
	Integer x;
	Integer y;
	public Pair(Integer x, Integer y) {
		this.y = y;
		this.x = x;
	}
	public Integer first() {
		return x;
	}
	public Integer second() {
		return y;
	}
}

public class Main {
    static int call0 = 0;
    static int call1 = 0;
    static Pair[] fibo = new Pair[41];

    static Pair fibonacci(int n){
        if(n == 0){
            call0++;
            return fibo[n];
        }
        else if(n == 1){
            call1++;
            return fibo[n];
        }
        else if(fibo[n] != null){
            return fibo[n];
        }

        fibo[n] = new Pair(fibonacci(n-1).first() + fibonacci(n-2).first(),fibonacci(n-1).second() + fibonacci(n-2).second());
        return fibo[n];
    }
    public static void main(String[] args) throws IOException{
        fibo[0] = new Pair(1,0);
        fibo[1] = new Pair(0,1);
 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        int[] testCaseArr = new int[testCase];

        for(int i=0;i<testCase;i++){
            testCaseArr[i] = Integer.parseInt(bf.readLine());
        }

        for(int i : testCaseArr){
            System.out.println(fibonacci(i).first()+" "+fibonacci(i).second());
        }
    }
}
