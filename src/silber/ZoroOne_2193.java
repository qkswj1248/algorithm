package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZoroOne_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(fibonacci(n));
    }

    public static long fibonacci(int n){
        if(n == 1 || n == 2){
            return 1;
        }

        long a = 1;
        long b = 1;
        long result = 0;
        for(int i=2; i<n; i++){
            result = a+b;
            b = a;
            a = result;
        }
        return result;
    }

}
