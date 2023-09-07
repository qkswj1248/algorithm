package fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChickenDelivery_156686 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[][] map = new int[n][n];
        ArrayList<int[]> chicken = new ArrayList<>();
        ArrayList<int[]> house = new ArrayList<>();

        // 데이터 받아서 확인하기
        for(int i=0; i<n; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(token.nextToken());

                if(map[i][j] == 1){
                    // 집 위치 (행, 열)
                    house.add( new int[]{i, j} );
                }
                if(map[i][j] == 2){
                    // 치킨집 위치 (행, 열), 거리
                    chicken.add( new int[]{i, j} );
                }

            }
        }

        int[] dis = new int[chicken.size()];

        for(int i=0; i<house.size(); i++){
            int min_dis = n * 2;
            int num = -1;
            for(int j=0; j<chicken.size(); j++){
                int y = Math.abs(house.get(i)[0] - chicken.get(j)[0]);
                int x = Math.abs(house.get(i)[1] - chicken.get(j)[1]);

                if(x+y < min_dis){
                    min_dis = x+y;
                    num = j;
                }
            }

            dis[num] += min_dis;
        }

//        Arrays.sort(dis);
        System.out.println(Arrays.toString(dis));

    }
}
