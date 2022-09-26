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
		} while((sum + line + 1) <= n); //�̷��� �ؾ� �� �� �� ���� ���� ����.
		
		int dis = n - sum, up = 1, down = 1;
		//¦���� �� �������� Ȧ���� �� �ö󰡰�
		if(dis == 0) {
			up = line;
		}else {
			line++; //�����ٷ� �Ѿ�ϱ�
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
