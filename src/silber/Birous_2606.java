package silber;

import java.io.*;
import java.util.*;

public class Birous_2606 {
    static int N;
    static LinkedList<Integer> graph[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        N = Integer.parseInt(br.readLine()) + 1;
        int l = Integer.parseInt(br.readLine());

        // 그래프 초기화하기
        graph = new LinkedList[N];
        for(int i=0; i<N; i++){
            graph[i] = new LinkedList<>();
        }

        // 노선 배열에 표시하기
        boolean line[][] = new boolean[N][N];
        for(int i=0; i<l; i++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            line[a][b] = true;
            line[b][a] = true;
        }

        // 노선 그래프에 입력하기
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                if(line[i][j])
                    graph[i].add(j);

        boolean[] visited = new boolean[N];
        DFS(1, visited);

        System.out.print(count);

    }
    //아니 static은 초기화 안해준다니까 기억하기!!!
    static int count = -1;
    static void DFS(int v, boolean[] visited){
        visited[v] = true;
        count++;

        Iterator list = graph[v].iterator();
        while(list.hasNext()){
            int node = (int)list.next();
            if(!visited[node]){
                DFS(node, visited);
            }

        }

    }

}
