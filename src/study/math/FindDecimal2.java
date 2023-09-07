package study.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2581 : 소수
 * (60이상 100이하중 소수 찾기)
 *  -입력-
 *  60
 *  100
 *  -출력-
 *  620
 *  61
 *
 */
public class FindDecimal2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int key = 0;
        int first = -1;
        int sum = 0;

        for(int i=a; i<=n; i++) {
            if(i == 1){
                if(n == 1)
                    break; // 1 1에서 예외가 발생하므로 넣음
                ++i;
            }
            for(int j=2; j*j<=i; j++) {
                if(i%j == 0) {
                    key = 1;
                    break;
                }
            }
            if(key == 0){
                sum += i;
                if(first == -1)
                    first = i;
            }
            key = 0;
        }
        if(first == -1){
            System.out.println(first);
        }else{
            System.out.println(sum);
            System.out.println(first);
        }
    }
}
