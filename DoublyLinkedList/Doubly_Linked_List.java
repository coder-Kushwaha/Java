package DoublyLinkedList;

import java.util.Scanner;

public class Doubly_Linked_List {
  ListNode head;

  private class ListNode {

    private int data;
    private ListNode next;
    private ListNode previous;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
      this.previous = null;
    }
  }

  void addData(int data) {
    ListNode newnode = new ListNode(data);
    if (head == null) {
      head = newnode;
    } else {
      newnode.previous = head;
      head.next = newnode;
      head = newnode;
    }
  }

  void RemoveData() {

    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    ListNode temp = new ListNode(0);
    temp = head;
    head = head.previous;
    System.out.println("Deleted data is: " + temp.data);
  }

  void DisplayList() {
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    ListNode temp = new ListNode(0);
    int i = 1;
    temp = head;
    while (temp != null && i < 10) {
      System.out.println("Data: " + temp.data);
      temp = temp.previous;
      i++;
    }
  }

  void menu() {
    Doubly_Linked_List dl = new Doubly_Linked_List();
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
          dl.addData(data);
          break;
        case 2:
          System.out.println("-------------------------------------");
          dl.RemoveData();
          break;
        case 3:
          System.out.println("-------------------------------------");
          dl.DisplayList();
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
    Doubly_Linked_List dll = new Doubly_Linked_List();
    dll.menu();

  }
}
