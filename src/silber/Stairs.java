package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 계단 오르기
/*
- 입력
6
10
20
15
25
10
20
- 출력
75
 */
public class Stairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        int[] sum = new int[n];

        for(int i=0; i<n; i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        sum[n-1] = score[n-1];
        sum[n-2] = score[n-2] + score[n-1];
        sum[n-3] = score[n-3] + score[n-1];

        for(int i=n-4; i>=0; i--){
            sum[i] = Math.max(sum[i+1], sum[i+3]) + score[i];
        }


    }
}
