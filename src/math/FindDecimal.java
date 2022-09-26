package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1929 : 소수 구하기
 * (3과 16 사이의 소수)
 * -입력-
 * 3 16
 * -출력-
 * 3
 * 5
 * 7
 * 11
 * 13
 */
public class FindDecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int key = 0;
        int count = 0;
        int a = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);

        for(int i=a; i<=n; i++) {
            if(i == 1)
                ++i;
            System.out.println("i: " + i);
            for(int j=2; j*j<=i; j++) { //j<i
                //2x2, 3x3, 4x4, 5x5 순으로 늘어난다.
                //여기서 3x3아래에 있는 것은 2와 3만 가지고도 나눠진다.
                System.out.print(j + ", ");
                count++;
                if(i%j == 0) {
                    key = 1;
                    break;
                }
            }
            System.out.println();
            if(key == 0) {
                sb.append(i).append('\n');
            }
            key = 0;
        }
        System.out.println("----------결과-----------");
        System.out.println(sb);
        System.out.println("count : " + count);
    }
}
