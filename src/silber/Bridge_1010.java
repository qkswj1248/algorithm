package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bridge_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            token = new StringTokenizer(br.readLine());
            int result = 1;
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            a = Math.max(b-a, a);

            System.out.println("a : " + a + ", b : " + b);

            int max = 1000000;
            int div = b-a;
            for(int j=b; j>a; j--){
                result *= j;
                if(result%div == 0 && div > 1){
                    div--;
                    result /= div;
                    System.out.println("result : " + result + ", div : " + div);
                }
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
}
