package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Island_4963 {
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        while(true) {
            token = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(token.nextToken());
            int h = Integer.parseInt(token.nextToken());
            if(w == 0 || h == 0){
                break;
            }
            int land[][] = new int[h][w];
            for(int i=0; i<h; i++){
                token = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    land[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            // dfs bfs 함수를 만들고, for문으로 돌리기~
            int count = 0;
            visited = new boolean[h][w];
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(land[i][j] == 1 && visited[i][j] == false){
                        bfs(land, w, h, j, i);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');

        }
        System.out.print(sb);
    }

    static Queue<Node> queue = new LinkedList<>();

    /*
    0 0 0
    0 1 0
    0 0 0
     */

    // 대각선도 포함하므로 이것도 고려하기~
    static int dirW[] = {1, 1, 0, -1, -1, -1, 0, 1};
    static int dirH[] = {0, 1, 1, 1, 0, -1, -1, -1};

    static void bfs(int[][] rand, int w, int h, int nw, int nh){
        visited[nh][nw] = true;
        queue.add(new Node(nw, nh));

        while(!queue.isEmpty()){
            Node now = queue.poll();
            // 동서남북, 움직여도 되는 곳인지 확인하기
            for(int i=0; i<dirW.length; i++){
                int roundW = now.w + dirW[i];
                int roundH = now.h + dirH[i];
                if(roundW < 0 || roundW >= w){
                    continue;
                }
                if(roundH < 0 || roundH >= h){
                    continue;
                }
                if(rand[roundH][roundW] == 1 && !visited[roundH][roundW]){
                    queue.add(new Node(roundW, roundH));
                    visited[roundH][roundW] = true;
                }
            }
        }

    }

}

class Node{
    int w;
    int h;

    Node(int w, int h){
        this.w = w;
        this.h = h;
    }
}
