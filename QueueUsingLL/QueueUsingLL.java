package QueueUsingLL;

import java.util.Scanner;

public class QueueUsingLL {
  private class ListNode {

    private int data;
    private ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  ListNode head;
  ListNode tail;

  void push(int data) {
    ListNode newNode = new ListNode(data);
    if (head == null && tail == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
  }

  void pop() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    ListNode temp = new ListNode(0);
    temp = head;
    if (head == tail) {
      head = null;
      tail = null;
    } else
      head = head.next;
    System.out.println("Deleted data: " + temp.data);
  }

  void display() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    ListNode temp = new ListNode(0);
    temp = head;
    int i = 1;
    while (temp != null && i < 10) {
      System.out.println("Data: " + temp.data);
      i++;
      temp = temp.next;
    }
  }

  void menu() {
    QueueUsingLL qLl = new QueueUsingLL();
    Scanner sc = new Scanner(System.in);
    System.out.println("-----------MENU----------");
    System.out.println("Press 1. To Add New Node");
    System.out.println("Press 2. To Delete a Node");
    System.out.println("Press 3. To Display Linked List");
    System.out.println("Press 4. To Exit");
    while (true) {
      System.out.println("------------------------------");
      System.out.println("Enter your choice: ");
      int choice = sc.nextInt();
      int data;

      switch (choice) {
        case 1:
          System.out.println("-------------------------------------");
          System.out.println("Enter data: ");
          data = sc.nextInt();
          qLl.push(data);
          break;
        case 2:
          System.out.println("-------------------------------------");
          qLl.pop();
          break;
        case 3:
          System.out.println("-------------------------------------");
          qLl.display();
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
    QueueUsingLL qLl = new QueueUsingLL();

    qLl.menu();
  }
}
