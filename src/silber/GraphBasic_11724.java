package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class GraphBasic_11724 {

    static LinkedList<Integer> graph[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int count = 0;

        graph = new LinkedList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i=0; i<m; i++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                count++;
                DFS(i, visited);
            }
        }

        System.out.print(count);

    }

    public static void DFS(int n, boolean[] visited){
        visited[n] = true;

        Iterator nodes = graph[n].iterator();
        while(nodes.hasNext()){
            int a = (int) nodes.next();
            if(!visited[a]){
                DFS(a, visited);
            }
        }
    }

}
