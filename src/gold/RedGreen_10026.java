package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class RedGreen_10026 {
    static int N;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = line.charAt(j);
            }
        }

        boolean[][] visited = new boolean[N][N];
//        Point point;
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
//                    point = new Point(i, j);
                    count++;
//                    BFS(point, visited);
                    DFS(i, j, visited);
                }
            }
        }
        sb.append(count).append(" ");

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 'G')
                    map[i][j] = 'R';
            }
        }

        visited = new boolean[N][N];
        count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
//                    point = new Point(i, j);
                    count++;
//                    BFS(point, visited);
                    DFS(i, j, visited);
                }
            }
        }

        sb.append(count);
        System.out.print(sb);

    }

//    static LinkedList<Point> queue = new LinkedList<>();
    static int[] x = {1, 0, -1, 0};
    static int[] y = {0, 1, 0, -1};

//    static void BFS(Point point, boolean visited[][]){
//        char color = map[point.x][point.y];
//        queue.add(point);
//        visited[point.x][point.y] = true;
//
//        while(!queue.isEmpty()){
//            Point po = queue.poll();
//            visited[po.x][po.y] = true;
//
//            for(int i=0; i<4; i++){
//                int a = po.x + x[i];
//                int b = po.y + y[i];
//                if(a >= 0 && b >= 0 && a < N && b < N){
//                    if(map[a][b] == color && !visited[a][b]){
//                        queue.add(new Point(a, b));
//                        // 이렇게 넣을 때 표시해야 검사할 때 안할 줄 알고 확인하는 경우가 없다.
//                        visited[point.x][point.y] = true;
//                    }
//                }
//            }
//
//        }
//
//    }


    static void DFS(int i, int j, boolean visited[][]){
        char color = map[i][j];
        visited[i][j] = true;

        for(int k=0; k<4; k++){
            int a = i + x[k];
            int b = j + y[k];
            if(a >= 0 && b >= 0 && a < N && b < N){
                if(map[a][b] == color && !visited[a][b]){
                    DFS(a, b, visited);
                }
            }
        }

    }
}
//
//class Point{
//    int x;
//    int y;
//
//    Point(int x, int y){
//        this.x = x;
//        this.y = y;
//    }
//}
