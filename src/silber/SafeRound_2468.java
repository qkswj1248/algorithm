package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafeRound_2468 {
    static int rand[][];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        n = Integer.parseInt(br.readLine());
        rand = new int[n][n];
        boolean visited[][];

        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0; i<n; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                rand[i][j] = Integer.parseInt(token.nextToken());
                min = Math.min(min, rand[i][j]);
                max = Math.max(max, rand[i][j]);
            }
        }
        int maxCount = 0;
        for(int i=max; i>=min; i--){
            int count = 0;
            visited = new boolean[n][n];
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(rand[j][k] >= i && !visited[j][k]){
                        dfs(j, k, i, visited);
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.print(maxCount);
    }

    static int[] widthDir = {1, 0, -1, 0};
    static int[] heightDir = {0, 1, 0, -1};

    static void dfs(int h, int w, int base, boolean[][] visited){
        visited[h][w] = true;

        for(int i=0; i<4; i++){
            int nextW = widthDir[i] + w;
            int nextH = heightDir[i] + h;
            if(nextW < 0 || nextW >= n){
                continue;
            }
            if(nextH < 0 || nextH >= n){
                continue;
            }
            if(rand[nextH][nextW] >= base && !visited[nextH][nextW]){
                dfs(nextH, nextW, base, visited);
            }
        }

    }

}
