package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchTree_5639 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Node root = new Node(Integer.parseInt(br.readLine()));
        while((line = br.readLine()) != null){
            Node next = new Node(Integer.parseInt(line));
            root = addTree(root, next);
        }
        printTree(root);
        System.out.print(sb);
    }

    public static Node addTree(Node tree, Node addNode){
        if(tree == null){
            // 이건 tree.left에 들어갈 값이기 때문에 새로 추가할 노드를 반환하면 된다,,,
            return addNode;
        }
        if(tree.n > addNode.n){
            tree.left = addTree(tree.left, addNode);
        }else{
            tree.right = addTree(tree.right, addNode);
        }
        return tree;
    }
    public static void printTree(Node root){
        if(root == null){
            return;
        }
        printTree(root.left);
        printTree(root.right);
        sb.append(root.n).append("\n");
    }

}

class Node{
    int n;
    Node left;
    Node right;
    Node(int n){
        this.n = n;
    }
}
