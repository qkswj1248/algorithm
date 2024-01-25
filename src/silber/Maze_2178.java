package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maze_2178 {
    static int n;
    static int m;
    static int minCount = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        int map[][] = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            char[] line = br.readLine().toCharArray();
            for(int j=0; j<n; j++){
                map[i][j] = line[j] - '0';
            }
        }

        dfs(map, visited, 0, 0, 1);
        System.out.print(minCount);

    }
    static int vertical[] = {0, 1, 0, -1};
    static int horizontal[] = {1, 0, -1, 0};

    static void dfs(int[][] map, boolean[][] visited, int a, int b, int count){
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        if(a == n-1 && b == m-1){
            minCount = Math.min(minCount, count);
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]){
                    System.out.print('1');
                }else{
                    System.out.print('0');
                }
            }
            System.out.println();
        }

        for(int i=0; i<4; i++){
            int nowA = a + vertical[i];
            int nowB = b + horizontal[i];

            if(nowA < 0 || nowA >= n){
                continue;
            }
            if(nowB < 0 || nowB >= m){
                continue;
            }
            if(map[nowA][nowB] == 1 && !visited[nowA][nowB]){
                visited[a][b] = true;
                dfs(map, visited, nowA, nowB, count+1);
                visited[a][b] = false;
            }
        }

    }

}
