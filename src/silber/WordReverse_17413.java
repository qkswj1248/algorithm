package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class WordReverse_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] s = br.readLine().toCharArray();
        Stack<Character> word = new Stack<>();
        boolean stSwitch = false;
        boolean between = false;
        if(s[0] == '<'){
            between = true;
        }else{
            stSwitch = true;
        }

        for(int i=0; i<s.length; i++){
            char a = s[i];

            if(between){
                sb.append(a);
                if(a == '>'){
                    between = false;
                    if(i+1 < s.length && i+1 != '<')
                        stSwitch = true;
                }
                continue;
            }

            if(!stSwitch){
                sb.append(a);
                if(a == '<'){
                    between = true;
                }
                // 공백이거나 > 나오면 스택에 넣기
                if(a == ' ' || a == '>'){
                    stSwitch = true;
                    continue;
                }
            }


            if(stSwitch){
                // true 인데 공백이나 < 나오면 다 뺴기
                if(a == ' ' || a == '<'){
                    while(!word.empty()){
                        sb.append(word.pop());
                    }
                    sb.append(a);

                    if(a == '<'){
                        stSwitch = false;
                        between = true;
                    }
                }else{
                    word.add(a);
                }
            }


        }

        while(!word.isEmpty()){
            sb.append(word.pop());
        }

        System.out.println(sb);

    }

}
