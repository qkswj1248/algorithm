package gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimumCostTest {
    static class Node{
        int v;
        int cost;
        public Node(int v,int cost){
            this.v = v;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean visited[];
    static int dist[];
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
        }

        st = new StringTokenizer(br.readLine());

        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        solution(u);
        System.out.println(dist[v]);
    }

    public static void solution(int start){
        Arrays.fill(dist,INF);
        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()){
            Node now = queue.poll();

            if(!visited[now.v]){
                visited[now.v] = true;
                for(Node next : graph.get(now.v)){
                    if(dist[next.v] > dist[now.v] + next.cost){
                        dist[next.v] = dist[now.v] + next.cost;
                        queue.add(new Node(next.v,dist[next.v]));
                    }
                }
            }
        }
    }
}