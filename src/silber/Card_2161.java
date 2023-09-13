package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Card_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int k=1; k<=n; k++){
            for(int i=1; i<=k; i++){
                queue.add(i);
            }

            while(!queue.isEmpty()){
                sb.append(queue.remove()).append(' ');
                if(queue.isEmpty()){
                    break;
                }
                queue.add(queue.remove());
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
