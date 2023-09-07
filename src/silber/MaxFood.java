package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 개미 전사 - 가장 식량을 많이 얻는 방법은?
/*
- 입력
4
1 3 1 5
- 출력
8
 */
public class MaxFood {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int n = Integer.parseInt(br.readLine());
        int sum[] = new int[n];
        int num[] = new int[n];

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(token.nextToken());
        }

        sum[0] = num[0];
        sum[1] = num[1];
        sum[2] = num[0] + num[2];
        sum[3] = num[1] + num[3];

        for(int i=4; i<n; i++){
            sum[i] = num[i] + Math.max(sum[i-2], sum[i-3]);
        }

        System.out.println(Arrays.toString(sum));

        System.out.print(Math.max(sum[n-2], sum[n-1]));


    }
}
