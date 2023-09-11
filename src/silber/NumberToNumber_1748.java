package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberToNumber_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        int p = (int)Math.log10(n);

        for(int i=p; i>0; i--){
            sum += Math.pow(10, i-1) * i * 9;
        }

        sum += (p+1)*(n-(int)Math.pow(10, p)+1);
        System.out.println(sum);

        /*
        이것도 같은 결과가 나온다(대박!)
        (n-999)*4 + (900*3) + (90*2) + (9*1)
        이걸 풀어서 쓰면
        (n-999) + (n-99) + (n-9) + n 이 된다!!
         */
//        for(int i=1; i<=n; i*=10){
//            sum += (n - i) + 1;
//        }

    }
}
