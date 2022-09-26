package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StarRecursion {
    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        star = new char[n][n];
        fill(star, n, ' ');

        recursion(n, 0, 0, false);

        for(char[] a : star){
            for(char b : a){
                System.out.print(b);
            }
            System.out.println();
        }
    }

    public static void fill(char[][] arr, int n, char m){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = m;
            }
        }
    }

    public static void recursion(int n, int x, int y, boolean blank) {
        if(blank){
            for(int i=x; i < x + n; i++){
                for(int j=y; j < y + n; j++){
                    star[x][y] = ' ';
                }
            }
            return;
        }

        if(n == 1){
            star[x][y] = '*';
            return;
        }

        int size = n/3;
        int count = 0;
        for(int i = x; i < x + n ; i+=size){
            for(int j = y; j < y + n; j+=size){
                count++;
                if(count == 5){
                    recursion(size, i, j, true);
                }else{
                    recursion(size, i, j, false);
                }
            }
        }

    }
}
