package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FineFractions {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0, line = 0;

		do {
			line++;
			sum += line;
		} while((sum + line + 1) <= n); //이렇게 해야 한 번 더 도는 일이 없다.

		int dis = n - sum, up = 1, down = 1;
		//짝수일 땐 내려가고 홀수일 땐 올라가고
		if(dis == 0) {
			up = line;
		}else {
			line++; //다음줄로 넘어가니까
			dis--;
			down = line;
			up += dis;
			down -= dis;
		}
		if(line % 2 == 1) {
			System.out.println(down + "/" + up);
		}else {
			System.out.println(up + "/"+ down);
		}
		
	}

}
