package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimumCost_1916 {
    static int n;
    static boolean[] visited;
    static int maxNum = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] city = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j){
                    continue;
                }
                city[i][j] = maxNum;
            }
        }

        for(int i=0; i<m; i++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());
            if(a == b){
                cost = 0;
            }
            if(city[a][b] > cost){
                city[a][b] = cost;
            }
        }

        token = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(token.nextToken());
        int end = Integer.parseInt(token.nextToken());

        find(city, start, start, 0, end);
        System.out.print(city[start][end]);

    }

    private static void find(int[][] city, int start, int now, int cost, int end) {
        System.out.print("now = " + now + ", ");
        System.out.println("cost = " + cost);
        visited[now] = true;

        for(int i=1; i<=n; i++){
            if(!visited[i] && city[now][i] != maxNum && city[start][i] > (cost + city[now][i])){
                System.out.println("갱신 " + i);
                city[start][i] = cost + city[now][i];
            }
        }

        for(int i=1; i<=n; i++){
            if(!visited[i] && city[now][i] != maxNum && city[start][end] > cost+city[now][i]){
                System.out.println("반복");
//                System.out.println("선택됨 cost + city["+now+"]["+i+"] : " + (cost + city[now][i]));
                visited[i] = true;
                find(city, start, i, city[now][i] + cost, end);
                visited[i] = false;
            }
        }

    }
}
