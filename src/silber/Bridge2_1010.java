package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bridge2_1010 {

    static int[][] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;
        int n = Integer.parseInt(br.readLine());

        num = new int[31][31];

        for(int i=0; i<n; i++) {
            token = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(token.nextToken());
            int a = Integer.parseInt(token.nextToken()); // 큰수
            if(a != b){
                b = Math.min(b, a-b);
            }
            sb.append(combi(a, b)).append('\n');
        }

        System.out.print(sb);
    }

    private static int combi(int a, int b) {
        if(num[a][b] != 0){
            return num[a][b];
        }
        if(a == b){
            return 1;
        }
        if(b == 1){
            return a;
        }
        num[a][b] = combi(a-1, b) + combi(a-1, b-1);
        return num[a][b];
    }
}
