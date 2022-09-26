package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9/22일 성공! 백준 2839 설탕배달
 * 5와 3으로 나눴을 때 몫이 최소로 나오게하기
 */
public class FiveAndThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0, m = n % 5;

        if(n == 4 || n == 7) {
            result = -1;
        }else if(m == 0){
            result = n/5;
        }else if(m == 1 || m == 3){
            result = n/5 + 1;
        } else if (m == 2 || m == 4) {
            result = n/5 + 2;
        }

        System.out.println(result);

    }
}
