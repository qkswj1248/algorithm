package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chess_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        boolean board[][] = new boolean[N][M];
        int result = Integer.MAX_VALUE;

        // true 은 W false 는 B
        for(int i=0; i<N; i++){
            char[] line = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(line[j] == 'W'){
                    board[i][j] = true;
                }
            }
        }

        for(int i=0; i<N-7; i++){
            for(int j=0; j<M-7; j++){
                result = Math.min(result, painting(i, j, board));
            }
        }

        System.out.print(result);
    }

    public static int painting(int n, int m, boolean[][] board){
        boolean now;
        boolean temp = true; // W로 시작
        int count = 0;
        for(int i=n; i<n+8; i++){
            for(int j=m; j<m+8; j++){
                now = board[i][j];
                if(now != temp){
                    count++;
                    now = temp;
                }
                temp = !now;
            }
            temp = !temp;
        }

        return Math.min(count, 64-count);
    }

}
