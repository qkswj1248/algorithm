package fail.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

// 스택, 재귀 중 재귀로 구현한다.
public class DFS {
    public static void main(String[] args) throws IOException {
        DFS test = new DFS(11);

        test.addEdge(1, 2);
        test.addEdge(1, 5);
        test.addEdge(1, 9);
        test.addEdge(2, 3);
        test.addEdge(3, 4);
        test.addEdge(5, 6);
        test.addEdge(5, 8);
        test.addEdge(6, 7);
        test.addEdge(9, 10);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        test.DFSStart(n);
    }
    static private int V;
    static private LinkedList<Integer> adj[];

    // 노드 수를 받고 그만큼 LinkedList 만들어서 초기화하기
    DFS(int v){
        V = v;
        // 일단 v(노드) 개수만큼 LinkedList 선언하기
        adj = new LinkedList[v];

        // 선언한 노드들마다 new로 해서 생성하기
        for(int i=0; i<v; ++i)
            adj[i] = new LinkedList<>();
    }
    // 각 노드에 연결된 노드의 수를 추가하기 ex) 5는 6과 8이 연결되있다.
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // 시작노드 받아서 DFS 탐색하기
    void DFSStart(int v){
        // 노드 수 만큼 boolean 배열 만들어서 방문한 노드 체크하기
        boolean visited[] = new boolean[V];

        DFSUtil(v, visited);
    }

    void DFSUtil(int v, boolean[] visited) {
        // 먼저 노드 방문 체크하고 시작하기
        visited[v] = true;
        System.out.println(v + "방문함 ");

        // 노드와 연관된 노드들을 받기
        ListIterator<Integer> it = adj[v].listIterator();
        while (it.hasNext()){
            int n = it.next();
            System.out.println("n = " + n);
            // 연결된 노드가 방문 안한 노드라면 다시 방문하기
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }

    }


}
