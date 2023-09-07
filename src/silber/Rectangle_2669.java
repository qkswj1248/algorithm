package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 아니 char 로 하면 틀리고 StringTokenizer 로 해야 맞네;;
 */
public class Rectangle_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean map[][] = new boolean[101][101];
        int count = 0;

        for(int i=0; i<4; i++){
//            char[] line = br.readLine().toCharArray();
//            int x1 = line[0] - 48;
//            int y1 = line[2] - 48;
//            int x2 = line[4] - 48;
//            int y2 = line[6] - 48;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int x=x1; x < x2; x++){
                for(int y=y1; y < y2; y++){
                    if(!map[x][y]){
                        map[x][y] = true;
                        count++;
                    }
                }
            }
        }

        System.out.print(count);



    }
}
