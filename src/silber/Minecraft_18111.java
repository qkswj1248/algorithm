package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Minecraft_18111 {

    static int N;
    static int M;
    static int inven;
    static int sum;
    static int second = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken()); // 세로
        M = Integer.parseInt(token.nextToken()); // 가로
        int ground[][] = new int[N][M];
        inven = Integer.parseInt(token.nextToken());
        sum = 0;

        // 모든 수 더하고 나눠서 기준점 확인하기
        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<M && token.hasMoreTokens(); j++){
                ground[i][j] = Integer.parseInt(token.nextToken());
                sum += ground[i][j];
            }
        }
        // 땅 높이의 기준점
        int base = sum / (N*M);
        System.out.println("합 : " + sum);
        System.out.println("기준점 : " + base);

        // 인벤토리 기준으로 큰 거, 작은 거 구분
        even(ground, base);
        System.out.println("second = " + second);
        System.out.println("base = " + base);

        if(base*M*N - sum < 0 || inven >= base*M*N - sum){ // 인벤 충분 or 땅 충분
            int pre = second;
            // base + 1 하기
            even(ground, base+1);
            System.out.println("second = " + second);
            if(pre < second){
                second = pre;
            }else{
                base += 1;
            }
            System.out.println("base = " + base);
        }
        System.out.println();

        System.out.println(second + " " + base);

    }

    static void even(int[][] ground, int base){
        System.out.println();
        second = 0;
        // 땅 빼기
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int dif = base - ground[i][j];
                // 땅 캐기
                if(dif < 0){
                    inven += dif;
                    second += 2 * Math.abs(dif);
                }else if(dif > 0){
                    // 인벤토리 빼기
                    inven -= dif;
                    second += 1 * dif;
                }
                System.out.print(dif + " ");
            }
            System.out.println();
        }
    }


}
