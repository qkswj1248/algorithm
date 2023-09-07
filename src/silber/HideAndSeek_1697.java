package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class HideAndSeek_1697 {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        if(N > K){
            System.out.print(N-K);
        }else if(N == K){
            System.out.print(0);
        }else{
            visited = new boolean[K*2];
            System.out.print(BFS(N, K));
        }

    }

    static LinkedList<Integer> queue = new LinkedList<>();
    static int[] method = {-1, +1, 2};

    static int BFS(int v, int end){
        visited[v] = true;
        queue.add(v);
        queue.add(-1);

        int count = 0;

        while(!queue.isEmpty()){
            int now = queue.poll();
            // 현재 몇번째 줄(?)인지 알기위해 -1을 넣는다.
            if(now == -1){
                queue.add(now);
                now = queue.poll();
                count++;
            }
            for(int i=0; i<3; i++){
                // -1 , +1, *2 중 하나 적용해서 next 구하기
                int next;
                if(method[i] == 2){
                    next = now * 2;
                }else{
                    next = now + method[i];
                }

                // 다음 수가 최대값보다 10 이상 크거나 0 보다 작으면 돌아가기
                if(next >= (end*2) || next < 0) continue;

                // 다음 수가 end와 같다면 다음 수이므로 count + 1 하고 return하기
                if(next == end){
                    return count + 1;
                }

                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }

        }

        return 0;
    }

}
