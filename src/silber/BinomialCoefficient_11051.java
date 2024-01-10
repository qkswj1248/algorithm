package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinomialCoefficient_11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        long result = 1;
        int j = 1;
        if(K < N-K){
            K = (N-K);
        }
        for(int i=N; i>=K+1; i--){
                result *= i;
                result /= j;
                if(result > 10007){
                    result %= 10007;
                }
                j++;
            System.out.println("result = " + result);
        }

//        for(int i=1; i<=N-K; i++){
//            result /= i;
//        }

        System.out.print(result);

    }
}
