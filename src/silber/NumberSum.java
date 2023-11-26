package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long count = 0;
        long sum = 0;
        for(long i=1; sum<=s*2; i++){
            sum = i*i + i;
            count = i;
        }
        count--;
        System.out.print(count);
    }
}
