package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DFSAndBFS_1260 {
    //노드 수
    static int N;
    static LinkedList<Integer> graph[];

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken()) + 1;
        int M = Integer.parseInt(token.nextToken());
        int V = Integer.parseInt(token.nextToken());

        graph = new LinkedList[N];
        // 초기화하기
        for(int i=0; i<N; i++){
            graph[i] = new LinkedList<>();
        }

        boolean[][] nodes = new boolean[N][N];
        // 해당 노드에 연결된 노드 번호 넣기
        for(int i=0; i<M; i++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            nodes[a][b] = true;
            nodes[b][a] = true;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(nodes[i][j]){
                    graph[i].add(j);
                }
            }
        }

        boolean[] visited_d = new boolean[N];
        DFS(V, visited_d);
        sb.append("\n");
        boolean[] visited_b = new boolean[N];
        BFS(V, visited_b);

        System.out.print(sb);
    }

    static void DFS(int v, boolean[] visited){
        visited[v] = true;
        sb.append(v).append(" ");

        Iterator nodes = graph[v].iterator();
        while(nodes.hasNext()){
            int node = (int) nodes.next();
            if(!visited[node]){
                DFS(node, visited);
            }
        }

    }

    //static은 배열도 초기화 해야하는 듯
    static LinkedList<Integer> queue = new LinkedList<>();
    static void BFS(int v, boolean[] visited){
        visited[v] = true;
        queue.add(v);

        while(!queue.isEmpty()){
            int q = queue.poll();
            sb.append(q).append(" ");

            Iterator nodes = graph[q].iterator();
            while(nodes.hasNext()){
                int node = (int) nodes.next();
                if(!visited[node]){
                    queue.add(node);
                    visited[node] = true;
                }
            }

        }

    }


}
