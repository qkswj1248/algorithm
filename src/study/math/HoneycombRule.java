package study.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HoneycombRule {
	// �Ϻ��ϰ� ��� ^^
	// ���ڵ��� i*6�� �����ϹǷ�
	// ����� ������ ������ �����̴�.
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
