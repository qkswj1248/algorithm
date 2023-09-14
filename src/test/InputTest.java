package test;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;
import java.util.StringTokenizer;

// 3:50
public class InputTest {

    static StringBuilder a = new StringBuilder();
    static StringBuilder b = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringBuilder sb;
        for(int t=0; t<5; t++){
            sb = new StringBuilder();

            Random rand = new Random();
            int n = rand.nextInt(20)+2;
            sb.append(n).append("\n");
            for(int i=0; i<n; i++){
                sb.append(rand.nextInt(1));
                sb.append(' ');
            }
            sb.append("\n");

            int p = rand.nextInt(10)+1;
            sb.append(p);
            for(int i=0; i<p; i++){
                sb.append("\n");
                sb.append(rand.nextInt(2)+1);
                sb.append(' ');
                sb.append(rand.nextInt(n)+1);
            }

            main3(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sb.toString().getBytes()))));
            main2(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sb.toString().getBytes()))));


            if(!Objects.equals(a.toString().trim(), b.toString().trim())){
                System.out.println("-------반례 찾음--------");
                System.out.println("<입력>");
                System.out.println(sb);
                System.out.println("<내답>");
                System.out.println(a);
                System.out.println("<정답>");
                System.out.println(b);

                a = new StringBuilder();
                b = new StringBuilder();
                System.out.println("--------------------");

            }

        }

    }

    static int sw[];
    public static void main2(BufferedReader br) throws IOException {
        StringTokenizer token;
        int n = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        sw = new int[n];

        // 스위치 상태 저장
        for(int i=0; i<n; i++){
            sw[i] = Integer.parseInt(token.nextToken());
        }

        // 학생수
        int stu = Integer.parseInt(br.readLine());
        for(int i=0; i<stu; i++){
            token = new StringTokenizer(br.readLine());
            if(token.nextToken().equals("2")){
                girlSwitch(Integer.parseInt(token.nextToken())-1);
            }else{
                bodySwitch(Integer.parseInt(token.nextToken()));
            }
        }
        for(int j=0; j<sw.length; j++){
            if(j != 0 && j % 20 == 0){
//                System.out.println();
                a.append("\n");
            }
//            System.out.print(sw[j] + " ");
            a.append(sw[j]).append(' ');

        }

    }

    private static void bodySwitch(int n) {
        if(n == 0){
            return;
        }
        for(int i=n-1; i<sw.length; i+=n){
            if(sw[i] == 0){
                sw[i] = 1;
            }else{
                sw[i] = 0;
            }
        }
    }

    private static void girlSwitch(int n) {
        if(sw[n] == 0){
            sw[n] = 1;
        }else{
            sw[n] = 0;
        }

        int count = 1;
        // 대칭이 아니거나 끝이면 return;
        while(n-count >= 0 && n+count < sw.length){
            if(sw[n+count] == sw[n-count]){
                if(sw[n+count] == 0){
                    sw[n+count] = 1;
                    sw[n-count] = 1;
                }else{
                    sw[n+count] = 0;
                    sw[n-count] = 0;
                }
            }else{
                break;
            }
            count++;
        }


    }











    static int num; // 스위치 개수
    static int[] state; // 스위치 상태
    static int student; // 학생 수

    public static void main3(BufferedReader br) throws IOException{
        // 스위치 개수 입력
        num = Integer.parseInt(br.readLine());

        // 스위치 상태 입력
        state = new int[num + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < state.length; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }

        // 학생수 입력
        student = Integer.parseInt(br.readLine());

        // 학생 스위치 처리
        for(int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());

            // 남자
            if(gender == 1) {
                man(Integer.parseInt(st.nextToken()));
            }
            // 여자
            else if(gender == 2) {
                women(Integer.parseInt(st.nextToken()));
            }

        }

        for(int i = 1; i < state.length; i++) {
//            System.out.print(state[i] + " ");
            b.append(state[i]).append(' ');
            if(i % 20 == 0) {
//                System.out.println();
                b.append("\n");
            }
        }

    }

    public static void man(int x) {
        int cur = x;
        // 배수 번호 스위치 상태 반대로 변경
        while(cur < state.length) {
            if(state[cur] == 0) {
                state[cur] = 1;
            }
            else if(state[cur] == 1) {
                state[cur] = 0;
            }
            cur += x;
        }
    }

    public static void women(int x) {
        // 현재 위치 스위치 상태 반대로 변경
        if(state[x] == 0) {
            state[x] = 1;
        }
        else if(state[x] == 1) {
            state[x] = 0;
        }

        // 대칭 스위치 반대로 변경
        int count = 1;
        while((x - count) > 0 && (x + count) < state.length) {
            if(state[x + count] == state[x - count]) {

                if(state[x + count] == 0) {
                    state[x + count] = 1;
                    state[x - count] = 1;
                }
                else if(state[x + count] == 1) {
                    state[x + count] = 0;
                    state[x - count] = 0;
                }
                count++;

            }
            else {
                break;
            }
        }
    }




}
