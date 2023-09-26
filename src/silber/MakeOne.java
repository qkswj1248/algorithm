package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class MakeOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n+1];
        BFS(n, visited);

        System.out.print(count);

    }

    static LinkedList<Integer> queue = new LinkedList<>();
    static int[] method = {3, 2};
    static int count = 0;

    static void BFS(int node, boolean[] visited){

        queue.add(node);
        queue.add(-5);
        visited[node] = true;

        while(!queue.isEmpty()){

            int now = queue.poll();

            if(now == -5){
                now = queue.poll();
                count++;
                queue.add(-5);
            }

            if(now == 1){
                return;
            }

            // 3, 2로 나눌때
            for(int i=0; i<2; i++){
                if(now % method[i] == 0){
                    int num = now / method[i];
                    if(!visited[num]){
                        queue.add(num);
                        visited[num] = true;
                    }
                }
            }
            // -1 일 때
            if(now > 1 && !visited[now-1]){
                queue.add(now-1);
                visited[now-1] = true;
            }

        }

    }

}
