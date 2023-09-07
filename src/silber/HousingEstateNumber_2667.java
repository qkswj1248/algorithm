package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HousingEstateNumber_2667 {
    static int N;
    static int[][] map;
    static int[] houseCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        houseCount = new int[500];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1){
                    //탐색하기
                    houseNumber++;
                    findHouse(i, j);
                }
            }
        }

        System.out.println(houseNumber-1);
        Arrays.sort(houseCount, 2, houseNumber+1);
        for(int i=2; i<=houseNumber; i++){
            System.out.println(houseCount[i]);
        }

    }

    static int houseNumber = 1;

    static void findHouse(int i, int j){
        map[i][j] = houseNumber;
        houseCount[houseNumber]++;

        // 상화좌우 표현방법 (이거 생각한 사람 진짜 천재)
        int[] x = {1, 0, 0, -1};
        int[] y = {0, 1, -1, 0};

        for(int k=0; k<4; k++){
            int a = i + x[k];
            int b = j + y[k];

            if(a >= 0 && b >= 0 && a < N && b < N){
                if(map[a][b] == 1){
                    findHouse(a, b);
                }
            }
        }

    }

}
