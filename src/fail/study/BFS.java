package fail.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    public static void main(String[] args) throws IOException {
        BFS test = new BFS(11);

        test.addEdge(1, 2);
        test.addEdge(1, 3);
        test.addEdge(1, 4);
        test.addEdge(2, 5);
        test.addEdge(3, 6);
        test.addEdge(3, 7);
        test.addEdge(4, 8);
        test.addEdge(5, 9);
        test.addEdge(6, 10);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        test.BFSStart(n);
    }
    private int V;
    // 각 노드마다 연관된 노드를 표현해야 하므로 LinkedList를 배열로 만든다.
    private LinkedList<Integer> adj[];

    BFS(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void BFSStart(int s){
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0){
            s = queue.poll();
            System.out.println("s = " + s);

            // 해당 노드와 인접한 노드 모두 가져오기
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()){
                int n = i.next();

                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }

            }
        }


    }

}
