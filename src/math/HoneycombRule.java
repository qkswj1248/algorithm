package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HoneycombRule {
	// 완벽하게 통과 ^^
	// 숫자들이 i*6씩 증가하므로
	// 어찌보면 굉장히 간단한 문제이다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 1, i=1;
		
		if(n > 1) {
			while(sum < n) {
				sum += (6*i);
				i++;
			}
		}
		System.out.println(i);
	}
}
