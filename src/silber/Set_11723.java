package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Set_11723 {

    static boolean[] arr = new boolean[21];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String line = br.readLine();
            if(line.equals("all")){
                all();
                continue;
            }
            if(line.equals("empty")){
                empty();
                continue;
            }

            token = new StringTokenizer(line);
            String key = token.nextToken();
            int x = Integer.parseInt(token.nextToken());
            switch (key){
                case "add":
                    add(x);
                    break;
                case "remove":
                    remove(x);
                    break;
                case "check":
                    sb.append(check(x)).append("\n");
                    break;
                case "toggle":
                    toggle(x);
                    break;
            }

        }

        System.out.print(sb);

    }

    public static int check(int x){
        if(!arr[x]){
            return 0;
        }else{
            return 1;
        }
    }

    public static void add(int x){
        if(!arr[x]){
            arr[x] = true;
        }
    }

    public static void remove(int x){
        if(arr[x]){
            arr[x] = false;
        }
    }

    public static void toggle(int x){
        if(arr[x]){
            arr[x] = false;
        }else{
            arr[x] = true;
        }
    }

    public static void all(){
        for(int i=1; i<=20; i++){
            arr[i] = true;
        }
    }

    public static void empty(){
        for(int i=1; i<=20; i++){
            arr[i] = false;
        }
    }

}
