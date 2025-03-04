package CircularLinkedList;
import java.util.Scanner;

public class Circular_Linked_List {
  ListNode head;

  private static class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }

  }

  void AddData(int data) {
    ListNode newNode = new ListNode(data);
    if (head == null) {
      head = newNode;
      head.next = head;
    } else {
      newNode.next = head.next;
      head.next = newNode;
      head = newNode;
    }
  }

  void removeData() {
    if (head == null) {
      System.out.println("List is empty!!");
    } else {
      ListNode temp = new ListNode(0);
      temp = head.next;
      if (head == head.next) {
        head = null;
      } else
        head.next = temp.next;
      System.out.println("Deleted data is: " + temp.data);
    }
  }

  void displayData() {
    if (head == null) {
      System.out.println("List is empty");
    } else {
      ListNode temp = new ListNode(0);
      temp = head.next;
      int i = 1;
      while (temp != head && i < 10) {
        System.out.println("data: " + temp.data);
        temp = temp.next;
        i++;
      }
      System.out.println("data: " + head.data);
    }
  }

  void menu() {
    Circular_Linked_List cll = new Circular_Linked_List();
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
          cll.AddData(data);
          break;
        case 2:
          System.out.println("-------------------------------------");
          cll.removeData();
          break;
        case 3:
          System.out.println("-------------------------------------");
          cll.displayData();
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
    Circular_Linked_List cll = new Circular_Linked_List();
    cll.menu();

  }
}
