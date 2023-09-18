package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bingo_2578 {

    static int[][] bingo = new int[5][5];
    static int ok = 0;
    static int count = 0;
    static int[] width = new int[5];
    static int[] height = new int[5];
    static int rDiagonal = 0;
    static int lDiagonal = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        // 배열에 수 담기
        for(int i=0; i<5; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                bingo[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        boolean exit = false;

        // 5줄 빙고 받는 부분
        for(int p=0; p<5; p++){
            token = new StringTokenizer(br.readLine());
            // 1줄에 있는 5개 숫자 받는 부분
            for(int k=0; k<5; k++){
                int in = Integer.parseInt(token.nextToken());
                // 해당 숫자로 어디 있는지 찾는 부분
                findBing(in);
                // 빙고가 2개이다가 바로 4개가 되는 경우도 있으므로 3개 이상! 중오**
                if(ok >= 3){
                    exit = true;
                    break;
                }
            }
            if(exit){
                break;
            }
        }

        System.out.println(count);

    }

    private static void findBing(int in) {

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(bingo[i][j] == in){
                    count++;

                    width[j]++;
                    if(width[j] >= 5) {
                        ok++;
                    }
                    height[i]++;
                    if(height[i] >= 5){
                        ok++;
                    }

                    if(i==j){
                        lDiagonal++;
                        if(lDiagonal >= 5){
                            ok++;
                        }
                    }

                    if(i+j == 4){
                        rDiagonal++;
                        if(rDiagonal >= 5){
                            ok++;
                        }
                    }
                    return;
                }
            }
        }
    }

}
