package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Procession_2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int a[][] = new int[N][M];

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                a[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        token = new StringTokenizer(br.readLine());
        int N2 = Integer.parseInt(token.nextToken());
        int M2 = Integer.parseInt(token.nextToken());

        int b[][] = new int[N2][M2];

        for(int i=0; i<N2; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<M2; j++){
                b[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int r[][] = new int[N][M2];

        for(int i=0; i<N; i++){
            for(int j=0; j<M2; j++){
                for(int k=0; k<M; k++){
                    r[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            for(int j=0; j<M2; j++){
                sb.append(r[i][j]).append(' ');
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
