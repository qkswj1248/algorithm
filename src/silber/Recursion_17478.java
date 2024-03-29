package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 17478 재귀함수가 뭔가요?

<입력>
2

<답변>
어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.
"재귀함수가 뭔가요?"
"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
____"재귀함수가 뭔가요?"
____"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
________"재귀함수가 뭔가요?"
________"재귀함수는 자기 자신을 호출하는 함수라네"
________라고 답변하였지.
____라고 답변하였지.
라고 답변하였지.

print(a)
recur(n, re)
print(b)
이런식으로 구성해야함

re가 n이랑 같아지면 답을 말하고 아니면 recur을 계속 호출하는 식으로 함

 */

public class Recursion_17478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursion(n, 0);
    }

    public static void recursion(int n, int re){
        String question = "\"재귀함수가 뭔가요?\"";
        String explain = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
        String explain2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
        String explain3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
        String answer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
        String end = "라고 답변하였지.";
        String under = "____";

        //물어봄
        System.out.print(under.repeat(re));
        System.out.println(question);

        if(re < n){ //이어감
            System.out.print(under.repeat(re));
            System.out.println(explain);
            System.out.print(under.repeat(re));
            System.out.println(explain2);
            System.out.print(under.repeat(re));
            System.out.println(explain3);
            recursion(n, re+1);
        }else{ //답변함
            System.out.print(under.repeat(re));
            System.out.println(answer);
        }

        System.out.print(under.repeat(re));
        System.out.println(end);

    }
}
