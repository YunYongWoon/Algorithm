package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] array;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N];

        s = bf.readLine();
        st = new StringTokenizer(s);
        for(int i=0;i<N;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int start = 0;
        int end = array[array.length-1];
        int mid;

        while(start<end){
            mid = (start + end) / 2;
            int length = 0;

            for(int i=0;i<array.length;i++){
                if(array[i] - mid > 0){
                    length += array[i] - mid;
                }
            }
            if(M > length){
                end = mid - 1;
            }
            else{
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
