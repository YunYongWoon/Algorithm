package ex1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
    private char head,left,right;

    public Node(char head, char left, char right){
        this.head = head;
        this.left = left;
        this.right = right;
    }

    public char getHead(){
        return head;
    }

    public char getLeft(){
        return left;
    }

    public char getRight(){
        return right;
    }
}

public class Main {
    static Node[] nodeArr;
    public static void main(String[] args) throws IOException{
        int n;
        nodeArr = new Node[26];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        for(int i=0;i<n;i++){
            char[] charArr = bf.readLine().toCharArray();
            Node inputNode = new Node(charArr[0],charArr[2],charArr[4]);
            nodeArr[charArr[0] - 'A'] = inputNode;
        }      
        preorder(nodeArr[0]);
        System.out.println();
        inorder(nodeArr[0]);
        System.out.println();
        postorder(nodeArr[0]);

    }

    public static void preorder(Node node){
        System.out.print(node.getHead());
        if(node.getLeft()-'A' > -1)
            preorder(nodeArr[node.getLeft()-'A']);
        if(node.getRight()-'A'> -1)
            preorder(nodeArr[node.getRight()-'A']);
    }

    public static void inorder(Node node){
        if(node.getLeft()-'A' > -1)
            inorder(nodeArr[node.getLeft()-'A']);
        System.out.print(node.getHead());
        if(node.getRight()-'A'> -1)
            inorder(nodeArr[node.getRight()-'A']);
    }

    public static void postorder(Node node){
        if(node.getLeft()-'A' > -1)
            postorder(nodeArr[node.getLeft()-'A']);
        if(node.getRight()-'A'> -1)
            postorder(nodeArr[node.getRight()-'A']);
        System.out.print(node.getHead());
    }
}
