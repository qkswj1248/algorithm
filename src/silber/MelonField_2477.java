package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MelonField_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int melonNumber = Integer.parseInt(br.readLine());
        Side sides[] = new Side[6];

        int bigWidthIndex = -1;
        int bigHeightIndex = -1;
        // 입력받기
        for(int i=0; i<sides.length; i++){
            token = new StringTokenizer(br.readLine());
            Side side = new Side(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
            sides[i] = side;
            if(side.direction == 1){
                bigWidthIndex = i;
            }
            if(side.direction == 3){
                bigHeightIndex = i;
            }
        }

        // max 값 찾기
        for(int i=0; i<sides.length; i++){
            if(sides[i].direction == 1 || sides[i].direction == 2){
                if(sides[i].size > sides[bigWidthIndex].size){
                    bigWidthIndex = i;
                }
            }else{
                if(sides[i].size > sides[bigHeightIndex].size){
                    bigHeightIndex = i;
                }
            }
        }

        int startIndex = bigWidthIndex;
        // 다음이 max 일때
        if((startIndex+1)%6 == bigHeightIndex){
            startIndex = bigHeightIndex;
        }
        // +2 구하기
        int smallWidthIndex = (startIndex+2)%6;
        int smallHeightIndex = (startIndex+3)%6;

        int area = (sides[bigHeightIndex].size * sides[bigWidthIndex].size
                - sides[smallHeightIndex].size * sides[smallWidthIndex].size) * melonNumber;
        System.out.print(area);

    }

    static class Side{
        final int direction;
        final int size;

        Side(int direction, int size){
            this.direction = direction;
            this.size = size;
        }
    }
}
