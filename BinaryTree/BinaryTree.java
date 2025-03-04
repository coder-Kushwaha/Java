package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

  private class TreeNode {
    private int data;
    private TreeNode Left;
    private TreeNode Right;

    public TreeNode(int data) {
      this.data = data;
      this.Left = null;
      this.Right = null;
    }

  }

  TreeNode addData() {
    Scanner scanner = new Scanner(System.in);
    int data;
    TreeNode newNode = new TreeNode(0);
    System.out.println("Enter Data(-1 to stop entering)");
    data = scanner.nextInt();
    if (data == -1) {
      return null;
    }
    newNode.data = data;
    System.out.println("Enter left child of: " + newNode.data);
    newNode.Left = addData();
    System.out.println("Enter right child: " + newNode.data);
    newNode.Right = addData();
    return newNode;
  }

  void preorder(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + "  ");
    preorder(root.Left);
    preorder(root.Right);

  }

  void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.Left);
    System.out.print(root.data + "  ");
    inorder(root.Right);
  }

  void postorder(TreeNode root) {
    if (root == null) {
      return;
    }
    postorder(root.Left);
    postorder(root.Right);
    System.out.print(root.data + "  ");
  }

  void LevelTraversal(TreeNode root) {
    TreeNode temp = new TreeNode(0);
    if (root == null)
      return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      temp = queue.poll();
      System.out.print(temp.data + "  ");
      if (temp.Left != null) {
        queue.offer(temp.Left);
      }
      if (temp.Right != null)
        queue.offer(temp.Right);

    }
  }

  public static void main(String[] args) {
    try {
      TreeNode root;
      BinaryTree binaryTree = new BinaryTree();
      root = binaryTree.addData();
      System.out.println("\nPreorder traversal: ");
      binaryTree.preorder(root);
      System.out.println("\nInorder traversal: ");
      binaryTree.inorder(root);
      System.out.println("\nPostorder traversal: ");
      binaryTree.postorder(root);
      System.out.println("\nLevel Traversal");
      binaryTree.LevelTraversal(root);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
