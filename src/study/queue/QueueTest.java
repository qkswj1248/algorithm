package study.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int element = -1;
        int last = -1;
        for(int i=0; i<n; i++){
            String commend = br.readLine();
            if (commend.contains("push")) {
                element = Integer.parseInt(commend.substring(5));
                System.out.println("element : " + element);
                System.out.println("test : " + queue.add(element));
                sb.append(element);
                last = element;
            } else if (commend.equals("pop")) {
                if(queue.isEmpty())
                    sb.append(-1);
                else
                    sb.append(queue.poll());
            } else if (commend.equals("size")) {
                sb.append(queue.size());
            } else if (commend.equals("empty")) {
                if(queue.isEmpty())
                    sb.append(1);
                else
                    sb.append(0);
            } else if (commend.equals("front")) {
                if(queue.isEmpty())
                    sb.append(-1);
                else
                    sb.append(queue.peek());
            } else if (commend.equals("back")){
                if(queue.isEmpty())
                    sb.append(-1);
                else
                    sb.append(last);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

}
