package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {

	public static void main(String[] args) throws IOException {
		
		// 가장 작은 숫자를 선택해서 앞으로 보낸다. > min이 필요

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int numbers[] = new int[n];
		
		int min, tmp;
		
		// 수 입력받기
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
			numbers[min] = tmp; //여기에 tmp말고 number[i]넣어놓고 30분동안 헤맴..ㅎ
		}
		
		for(int item : numbers) {
			System.out.println(item);
		}
	}

}
