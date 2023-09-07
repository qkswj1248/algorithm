package fail.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 순열 구현하기
/*
- 입력
5 3 (5개 중에 3개 구하기)
1 2 3 4 5
- 출력
1 2 3
1 2 4
1 2 5
1 3 4
1 3 5
1 4 5
1 5 3
.
.
.

 */
public class Permutation {

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
        boolean[] visited = new boolean[N];
        start(arr, per, 0, N, M, visited);
//        start2(arr, 0, N, M);

        System.out.println("count = " + count);

    }

    static int count = 0;

    private static void start(int[] arr, int[] per, int depth, int N, int M, boolean[] visited) {

        count++;

        if(depth == M){
            for(int i=0; i<M; i++){
                System.out.print(per[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=depth; i<N; i++){
            if(!visited[i]){
                per[depth] = arr[i];
                visited[i] = true;
                System.out.println(Arrays.toString(visited));
                start(arr, per, depth+1, N, M, visited);
                per[depth] = 0;
                visited[i] = false;
            }
        }

    }

    static void start2(int[] arr, int depth, int N, int M){

        count++;

        if(depth == M){
            for(int i=0; i<M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // i=depth 부터 시작하는 이유는 1 2 3도 포함해야하기 때문
        for(int i=depth; i<N; i++){
            swap(arr, i, depth);
            System.out.println(Arrays.toString(arr));
            System.out.println("depth : " + depth);
            //depth가 M의 크기로 넘겨질 때는 출력을 할 때다
            start2(arr, depth+1, N, M);
            swap(arr, i, depth);
        }
    }

    private static void swap(int[] arr, int i, int now) {
        int temp = arr[i];
        arr[i] = arr[now];
        arr[now] = temp;
    }

}
