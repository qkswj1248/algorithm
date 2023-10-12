package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci_2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = 0;
        long n1 = 0;
        long n2 = 1;
        if(n == 1){
            result = 1;
        }
        for(int i=1; i<n; i++){
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        System.out.print(result);

    }
}
