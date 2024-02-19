package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Tree_1068_2 {
    static LinkedList<Integer>[] tree;
    static boolean parentNodes[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int key = Integer.parseInt(br.readLine());
        int keyParent = -1;

        initTree(n);

        for(int i=0; i<n; i++){
            int parent = Integer.parseInt(token.nextToken());
            if(parent == -1){
                continue;
            }
            tree[parent].add(i);
            if(i == key){
                keyParent = parent;
            }
        }

//        for(int i=0; i<n; i++){
//            System.out.print(i + " : ");
//            Iterator<Integer> iterator = tree[i].iterator();
//            while(iterator.hasNext()){
//                System.out.print(iterator.next() + " ");
//            }
//            System.out.println();
//        }

        parentNodes = new boolean[n];
        parentNodes[key] = true;

        dfs(key);

        // ListSize가 0 이상인 것도 바꾸기
        for(int i=0; i<n; i++){
            int size = tree[i].size();
            if(i == keyParent){
                size--;
            }
            if(!parentNodes[i] && size > 0){
                parentNodes[i] = true;
            }
        }

        int count = 0;
        for(int i=0; i<n; i++){
            if(parentNodes[i]){
//                System.out.print("x ");
            }
            if(!parentNodes[i]){
//                System.out.print("leaf ");
                count++;
            }
        }
//        System.out.println();

        System.out.print(count);
    }

    static void dfs(int key){
        // key와 연관된 것도 다 true로 바꾸기
        Iterator<Integer> iterator = tree[key].iterator();
        while(iterator.hasNext()){
            int now = iterator.next();
            if(!parentNodes[now]){
                parentNodes[now] = true;
                dfs(now);
            }
        }
    }

    static void initTree(int v){
        tree = new LinkedList[v];
        for(int i=0; i<v; i++){
            tree[i] = new LinkedList<>();
        }
    }

}
