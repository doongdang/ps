import java.io.*;
import java.util.StringTokenizer;

class Node{
    char val;
    Node left;
    Node right;

    Node(char val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main{
    static void preOrder(Node node){
        System.out.print(node.val);
        if(node.left != null){
            preOrder(node.left);
        }
        if(node.right != null){
            preOrder(node.right);
        }
    }

    static void inOrder(Node node){
        if(node.left != null){
            inOrder(node.left);
        }
        System.out.print(node.val);
        if(node.right != null){
            inOrder(node.right);
        }
    }

    static void postOrder(Node node){
        if(node.left != null){
            postOrder(node.left);
        }
        if(node.right != null){
            postOrder(node.right);
        }
        System.out.print(node.val);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Node[] data = new Node[n];
        for (int i = 0; i < n; i++) {
            data[i] = new Node((char)('A'+i), null, null);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            if(leftChild != '.'){
                data[parent-'A'].left = data[leftChild-'A'];
            }

            if(rightChild != '.'){
                data[parent-'A'].right = data[rightChild-'A'];
            }
        }
        preOrder(data[0]);
        System.out.println();
        inOrder(data[0]);
        System.out.println();
        postOrder(data[0]);
    }
}