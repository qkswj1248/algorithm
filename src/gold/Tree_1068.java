package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tree_1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        Node tree = null;
        for(int i=0; i<n; i++){
            int p_num = Integer.parseInt(token.nextToken());
            if(p_num == -1){
                tree = new Node(i);
                continue;
            }
            tree = add(tree, new Node(i), p_num);
//            printTree(tree);
//            System.out.println();
//            System.out.println("-----------------");
        }
        int key = Integer.parseInt(br.readLine());
        System.out.print(find(tree, key, 0));
    }

    public static void printTree(Node tree){
        if(tree == null){
            return;
        }
        System.out.print(tree.n + " ");
        printTree(tree.left);
        printTree(tree.right);
    }

    public static Node add(Node tree, Node newNode, int parent){
        if(tree.n == parent){
            if(tree.left == null){
                tree.left = newNode;
            }else{
                tree.right = newNode;
            }
        }

        if(tree.left != null){
            tree.left = add(tree.left, newNode, parent);
        }
        if(tree.right != null){
            tree.right = add(tree.right, newNode, parent);
        }
        return tree;
    }

    public static int find(Node tree, int key, int count){
//        System.out.println("now node : " + tree.n);
        if(tree.n == key){
            return 0;
        }
        if(tree.left == null && tree.right == null){
//            System.out.println("leaf node : " + tree.n);
            return 1;
        }
        if(tree.left != null){
            count += find(tree.left, key, count);
        }
        if(tree.right != null){
            count += find(tree.right, key, count);
        }
        return count;
    }

    static class Node{
        int n;
        Node left;
        Node right;
        Node(int n){
            this.n = n;
        }
    }
}
