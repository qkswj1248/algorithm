package fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Tomato_7576 {
    static int map[][];
    static int M;
    static int N;
    static int dateMax;
    static int zeroCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        dateMax = N*M;

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(token.nextToken());
                if(map[i][j] == 0){
                    zeroCount++;
                }
            }
        }

        if(zeroCount == 0){
            dateMax = 0;
        }else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        int max = BFS(j, i);
                        dateMax = Math.min(dateMax, max);
                    }
                }
            }
            dateMax -= 1;
            if(zeroCount > 0){
                dateMax = -1;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print(dateMax);

    }

    static LinkedList<int[]> queue = new LinkedList<>();
    static int[] x = {1, 0, -1, 0};
    static int[] y = {0, 1, 0, -1};

    static int testCnt = 0;

    static int BFS(int j, int i){
        int max = 0;
        queue.add(new int[]{j, i});

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for(int k=0; k<4; k++){
                int a = now[0] + x[k];
                int b = now[1] + y[k];

                if(a >= 0 && b >= 0 && a < M && b < N){
                    if(map[b][a] != -1 && (map[b][a] == 0 || map[b][a] > map[now[1]][now[0]])){
                        System.out.println("넣을 곳 수 : " + map[b][a] + ", 현재 있는 곳 수 : " + map[now[1]][now[0]]);
                        testCnt++;
                        System.out.println("queue.add : (" + b + ", " + a + ")  testCnt : " + testCnt);
                        queue.add(new int[]{a, b});
                        if(map[b][a] == 0){
                            zeroCount--;
                        }
                        map[b][a] = map[now[1]][now[0]] + 1;
//                        max = Math.max(max, map[b][a]);
                        max = map[b][a];
                    }
                }

            }
        }//while

        return max;
    }//DFS

}
