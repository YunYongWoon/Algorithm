package ex10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        int n;
        long b;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        int[][] matrix = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        matrix = pow(matrix,b);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(matrix[i][j]%1000 + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int[][] pow(int[][] matrix,long b){
        if(b == 1){
            return matrix;
        }
        int[][] mat = pow(matrix,b/2);
        int[][] result = powMatrix(mat, mat);

        if(b%2 == 0){
            return result;
        } else {
            return powMatrix(result,matrix);
        }
    }

    static int[][] powMatrix(int[][] mat1, int[][] mat2){
        int n = mat1.length;
        int[][] matrix = new int[n][n];

        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                int value = 0;
                for(int k=0;k<n;k++){
                    value += mat1[i][k] * mat2[k][j];
                }
                matrix[i][j] = value % 1000;
            }
        }

        return matrix;
    }
}
