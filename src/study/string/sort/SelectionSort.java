package study.string.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {

	public static void main(String[] args) throws IOException {
		
		// ���� ���� ���ڸ� �����ؼ� ������ ������. > min�� �ʿ�

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int numbers[] = new int[n];
		
		int min, tmp;
		
		// �� �Է¹ޱ�
		for(int i=0; i<n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<n; i++) {
			min = i;
			
			for(int j=(i+1); j<n; j++)
				if(numbers[min] > numbers[j])
					min = j;
			
			tmp = numbers[i];
			numbers[i] = numbers[min];
			numbers[min] = tmp; //���⿡ tmp���� number[i]�־���� 30�е��� ���..��
		}
		
		for(int item : numbers) {
			System.out.println(item);
		}
	}

}
