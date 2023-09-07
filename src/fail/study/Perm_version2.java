package fail.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복 순열 구현하기
/*
- 입력
5 3
1 2 3 4 5
- 출력
1 1 1
1 1 2
1 1 3
1 1 4
1 1 5
1 2 1
1 2 2
.
.
.

 */
public class Perm_version2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[] arr = new int[N];

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int[] per = new int[M];
        start(arr, per,0, N, M);
    }

    private static void start(int[] arr, int[] per, int depth, int n, int m) {

        if(depth == m){
            for(int i=0; i<m; i++){
                System.out.print(per[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            per[depth] = arr[i];
            start(arr, per, depth+1, n, m);
            per[depth] = 0;
        }

    }
}
