package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze2_2178 {
    static int n;
    static int m;
    static int minCount = Integer.MAX_VALUE;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        int map[][] = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            char[] line = br.readLine().toCharArray();
            for(int j=0; j<m; j++){
                map[i][j] = line[j] - '0';
            }
        }

        bfs(map);
        System.out.print(minCount);

    }
    static int vertical[] = {0, 1, 0, -1};
    static int horizontal[] = {1, 0, -1, 0};
    static Queue<Node2> queue = new LinkedList<>();

    static void bfs(int[][] map){
        queue.add(new Node2(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node2 now = queue.poll();
            if(now.h == n-1 && now.w == m-1){
                minCount = Math.min(minCount, now.count);
                return;
            }

            for(int i=0; i<4; i++){
                int nowW = now.w + horizontal[i];
                int nowH = now.h + vertical[i];

                if(nowH < 0 || nowH >= n){
                    continue;
                }
                if(nowW < 0 || nowW >= m){
                    continue;
                }
                if(map[nowH][nowW] == 1 && !visited[nowH][nowW]){
                    queue.add(new Node2(nowW, nowH, now.count+1));
                    visited[nowH][nowW] = true;
                }

            }

        }

    }

}

class Node2{
    int w;
    int h;
    int count;
    Node2(int w, int h, int count){
        this.w = w;
        this.h = h;
        this.count = count;
    }
}
