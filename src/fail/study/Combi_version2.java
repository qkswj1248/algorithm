package fail.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복 조합 구현하기
/*
- 입력
3 5
1 2 3 4 5
- 출력
1 1 1
1 1 2
1 1 3
1 1 4
1 1 5
1 2 3
1 2 4
1 2 5
1 3 4
1 3 5
1 4 5
2 3 4

 */
public class Combi_version2 {
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

        int[] com = new int[M];
        start(arr, com, 0, 0, N, M);
    }

    static void start(int[] arr, int[] com, int index, int depth, int n, int m){

        if(depth == m){
            for(int i=0;i<m;i++){
                System.out.print(com[i] +  " ");
            }
            System.out.println();
            return;
        }

        for(int i=index; i<n; i++){
            com[depth] = arr[i];
            start(arr, com, i, depth+1, n, m);
            com[depth] = 0;
        }

    }

}
