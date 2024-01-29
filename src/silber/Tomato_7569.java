package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato_7569 {
    static int M; // 가로
    static int N; // 세로
    static int H; // 높이
    static int tomatoCount = 0;
    static int maxTomatoCount;
    static boolean[][][] visited;
    static Queue<TomatoLocation> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());
        int box[][][] = new int[H][N][M];
        visited = new boolean[H][N][M];

        maxTomatoCount = M * N * H;
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                token = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    int num = Integer.parseInt(token.nextToken());
                    if(num == 1){
                        tomatoCount++;
                        queue.add(new TomatoLocation(k, j, i));
                        visited[i][j][k] = true;
                    }
                    if(num == -1){
                        maxTomatoCount--;
                    }
                    box[i][j][k] = num;
                }
            }
        }

        if(tomatoCount == 0){
            System.out.print("-1");
        }else if(tomatoCount == maxTomatoCount){
            System.out.print("0");
        }else{
            bfs(box);
            if(tomatoCount == maxTomatoCount){
                System.out.print(today);
            }else{
                System.out.print("-1");
            }
        }

    }

    static int today = 1;
    static int[] moveM = {0,0,-1,1,0,0};
    static int[] moveN = {1,-1,0,0,0,0};
    static int[] moveH = {0,0,0,0,1,-1};
    private static void bfs(int[][][] box) {
        queue.add(new TomatoLocation(-3, -3, -3));

        while(!queue.isEmpty()){
            TomatoLocation now = queue.poll();

            if(tomatoCount == maxTomatoCount){
                break;
            }
            if(now.m == -3){
                if(queue.isEmpty()){
                    return;
                }
                today += 1;
                queue.add(now);
                now = queue.poll();
            }

            for(int i=0; i<6; i++){
                int[] maxNum = {M, N, H};
                int[] next = {now.m + moveM[i], now.n + moveN[i], now.h + moveH[i]};
                boolean key = false;
                for(int j=0; j<next.length; j++){
                    if(next[j] < 0 || next[j] >= maxNum[j]){
                        key = true;
                    }
                }
                if(key){
                    continue;
                }
                if(box[next[2]][next[1]][next[0]] == 0
                        && !visited[next[2]][next[1]][next[0]]){
                    box[next[2]][next[1]][next[0]] = today;
                    queue.add(new TomatoLocation(next[0], next[1], next[2]));
                    tomatoCount++;
                    visited[next[2]][next[1]][next[0]] = true;
                }
            }

        }
    }
}

class TomatoLocation{
    int m;
    int n;
    int h;

    TomatoLocation(int m, int n, int h){
        this.m = m;
        this.n = n;
        this.h = h;
    }
}
