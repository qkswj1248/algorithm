package fail;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PrinterQueue_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int max = Integer.parseInt(token.nextToken());
            int save = Integer.parseInt(token.nextToken());

//            int[] arr = new int[max];
            LinkedList<int[]> queue = new LinkedList<>();
            token = new StringTokenizer(br.readLine());

            for(int j=0; j<max; j++){
                // {위치, 중요도}
                queue.offer(new int[] {j, Integer.parseInt(token.nextToken())});
            }

            int count = 1;

            while(!queue.isEmpty()){
                int[] front = queue.poll();

                int max_num = -1;

                for(int j=0; j<queue.size(); j++){
                    if(front[1] < queue.get(j)[1]){
                        max_num = j;
                    }
                }

                if(max_num != -1){
                    queue.offer(front);
                    for(int k=0; k<max_num; k++){
                        queue.offer(queue.poll());
                    }
                    front = queue.poll();
                }

                if(front[0] == save){
                    sb.append(count).append("\n");
                    break;
                }else{
                    count++;
                }


            }


        }

        System.out.println(sb);

    }
}
