package fail.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 큰 수의 법칙
/*
- 입력
8 3 5 (M, K, N)
5 4 3 2 1
- 출력
5+5+
 */
public class BigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());

        int[] numbers = new int[N];
        token = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        int first = numbers[N-1];
        int second = numbers[N-2];

        int sum = 0;
        if(first == second){
            sum += first * M;
        }else if(first > second){
            sum += first * K * (M / K);
            sum += second * (M % K);
        }

        System.out.println(sum);

    }
}
