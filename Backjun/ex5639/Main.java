package ex5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    private Node left, rigth;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setRight(Node node) {
        this.rigth = node;
    }

    public Node getRight() {
        return this.rigth;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Node headNode = new Node(Integer.parseInt(bf.readLine()));

        while (true) {
            String input = bf.readLine();
            if(input == null || input.equals("")){
                break;
            }
            makeNode(headNode, Integer.parseInt(input));
        }

        postOrder(headNode);
    }

    static void makeNode(Node node, int value) {
        int headValue = node.getValue();

        if (value < headValue) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(value));
            } else {
                makeNode(node.getLeft(), value);
            }
        } else if (value > headValue){
            if (node.getRight() == null) {
                node.setRight(new Node(value));
            } else {
                makeNode(node.getRight(), value);
            }
        }
    }

    static void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getValue());
    }
}
