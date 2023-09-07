package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Josephus_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }

        int i = 0;
        while(!list.isEmpty()){
            i = (i+(k-1)) % list.size();
            sb.append(list.remove(i)).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        System.out.print(sb);
    }
}
