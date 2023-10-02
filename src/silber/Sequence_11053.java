package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
DP 문제를 푸는 데 중요한 것
작은 문제가 큰 문제를 해결하는 데 도움을 준다는 것
(피보나치 수열 같이)
반복되서 사용되는 작은 문제가 무엇인지 파악하는 게 제일 중요하다
 */
public class Sequence_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int n = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        int count[] = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int max = 1;
        int result = 1;
        count[0] = 1;
        for(int i=1; i<n; i++){
            max = 0;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && max < count[j]){
                    max = count[j];
                }
            }
            count[i] = max + 1;
            result = Math.max(result, count[i]);
        }

        System.out.println(result);

    }
}
