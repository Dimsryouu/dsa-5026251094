package lw06.unguided;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        BinarySearchTree bst = new BinarySearchTree();
        
        int current = read.nextInt();
        while(read.hasNextInt()){
            bst.insert(current);
            current = read.nextInt();
        }

        int target = current;

        System.out.print("Preorder Traversal: ");
        bst.preOrder();

        System.out.print("Inorder Traversal: ");
        bst.inOrder();

        System.out.print("Postorder Traversal: ");
        bst.postOrder();

        System.out.println("Search: " + target + " : " + bst.search(target));

        System.out.println("Total number of nodes: " + bst.countNodes());
        System.out.println("Total number of leaves: " + bst.countLeaves());
        

        read.close();
    }
}