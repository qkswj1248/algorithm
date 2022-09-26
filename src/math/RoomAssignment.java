package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoomAssignment {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer token;
		int floor, unit;
		
		for(int i=0; i<n; i++) {
			token = new StringTokenizer(br.readLine());
			int topfloor = Integer.parseInt(token.nextToken()); //h
			int room = Integer.parseInt(token.nextToken()); //w
			int goal = Integer.parseInt(token.nextToken()); //n 이 더 좋은 변수명이 었을 것 같다.
			if((goal%topfloor) == 0) {
				unit = (int)(goal/topfloor);
				floor = topfloor;
			}else {
				unit = (int)(goal/topfloor) + 1;
				floor = goal%topfloor;
			}
			if(unit < 10) {
				sb.append(floor).append('0').append(unit).append('\n');
			}else {
				sb.append(floor).append(unit).append('\n');
			}
		}
		System.out.println(sb);		
	}
}
