package SinglyLinkedList;

import java.util.Scanner;

public class SLL {

  private ListNode head;
  private ListNode tail;

  // creating node
  private static class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // adding new node

  void addNewNode() {
    int d;
    SLL sll = new SLL();
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Data: ");
    d = sc.nextInt();
    ListNode newNode = new ListNode(d);

    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
  }

  // deleting node
  void deleteNode() {

    if (tail == null) {
      System.out.println("List Is Empty");
    } else {
      ListNode start = new ListNode(0);
      ListNode end = new ListNode(0);
      start = head;
      end = tail;
      if (start == end) {
        head = tail = null;
        System.out.println("Deleted Data is: " + end.data);
      } else {
        while (start.next != end) {
          start = start.next;
        }
        tail = start;
        tail.next = null;
        System.out.println("Deleted Data is: " + end.data);
      }
    }

  }

  // displaying linked list
  void display() {
    ListNode temp = new ListNode(0);
    temp = head;
    if (temp == null) {
      System.out.println("List Is Empty");
    } else {
      System.out.println("---------------------");
      System.out.println("List Is:");
      while (temp.next != null) {
        System.out.println(temp.data);
        temp = temp.next;
      }
      System.out.println(temp.data);
    }
  }

  // menu
  void menu() {
    SLL sll = new SLL();
    System.out.println("-----------MENU----------");
    System.out.println("Press 1. To Add New Node");
    System.out.println("Press 2. To Delete a Node");
    System.out.println("Press 3. To Display Linked List");
    System.out.println("Press 4. To Exit");
    while (true) {
      System.out.println("------------------------------");
      System.out.println("Enter your choice: ");
      Scanner sc = new Scanner(System.in);
      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          System.out.println("-------------------------------------");
          sll.addNewNode();
          break;
        case 2:
          System.out.println("-------------------------------------");
          sll.deleteNode();
          break;
        case 3:
          System.out.println("-------------------------------------");
          sll.display();
          break;
        case 4:
          System.out.println("-------------------------------------");
          System.out.println("Thank You!!");
          System.exit(0);
          break;
        default:
          System.out.println("-------------------------------------");
          System.out.println("Enter a Valid choice");
          break;
      }
    }
  }

  public static void main(String[] args) {
    SLL sll = new SLL();
    sll.menu();
  }

}
