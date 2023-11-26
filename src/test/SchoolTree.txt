package test;

public class SchoolTree {
    public class Node{
        int data;
        Node left;
        Node right;
    }

    /*
    트리가 비어있는지 확인하는 메서드
     */
    public boolean isEmptyTree(Node tree){
        if(tree == null){
            return true;
        }
        return false;
    }

    /*
    트리의 최대값을 찾는 함수
    트리의 가장 오른쪽 아래에 제일 큰 수가 있으므로
    트리의 끝인 null이 나올 때까지 while문으로 반복 저장해서 오른쪽 노드를 부른다.
    만약 null이 나올경우 해당 node 값을 반환한다.
     */
    public int treeMaximum(Node tree){
        if(isEmptyTree(tree)){
            throw new IllegalArgumentException();
        }

        Node node = tree.right;

        while(node != null){
            node = node.right;
        }
        return node.data;
    }

    /*
    트리의 최소값을 찾는 함수
    트리의 가장 왼쪽 아래에 제일 작은 수가 있으므로
    트리의 끝인 null이 나올 때까지 while문으로 반복 저장해서 왼쪽 노드를 부른다.
    만약 null이 나올경우 해당 node 값을 반환한다.
     */
    public int treeMinimum(Node tree){
        if(isEmptyTree(tree)){
            throw new IllegalArgumentException();
        }

        Node node = tree.left;

        while(node != null){
            node = node.left;
        }
        return node.data;
    }


}
