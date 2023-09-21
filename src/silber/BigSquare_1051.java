package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BigSquare_1051 {

    static int[][] arr;
    static int M;
    static int N;
    static int MAX = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            char[] ch = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                arr[i][j] = ch[j] - '0';
            }
        }

        // 시작할 점 정하기
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                findSquare(i, j);
            }
        }

        System.out.println(MAX);

    }

    private static void findSquare(int a, int b) {
        int base = arr[a][b];

        // 같은 줄 base 값 찾기
        for(int i=b+1; i<M; i++){
            if(base == arr[a][i]){
                int ln = i-b;
                // 세로 크기가 넘으면 멈추기
                if(a+ln >= N){
                    break;
                }
                // 세로 줄 base 값 찾기
                if(base == arr[a+ln][b] && base == arr[a+ln][i]){
                    // 넓이 비교하기
                    int area = (i-b+1) * (i-b+1);
                    if(MAX < area){
                        MAX = area;
                        System.out.println("base : " + base);
                        System.out.println("(a,b) : " + a + "," + b);
                        System.out.println("(a+ln,b+ln) : " + (a+ln) + "," + (b+ln));
                    }
                }
            }
        }

    }
}
