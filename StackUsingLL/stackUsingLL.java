package StackUsingLL;

import java.util.Scanner;

public class stackUsingLL {
  private class ListNode {
  
    private int data;
    private ListNode next;
    public ListNode(int data){
      this.data=data;
      this.next=null;
    }
  }

  ListNode top;

  void push(int data){
    ListNode newNode = new ListNode(data);
    if(top==null)
      top = newNode;
    else
    {
      newNode.next=top;
      top=newNode;
    }
  }

  void pop(){
    if(top==null){
      System.out.println("List is empty");
      return;
    }
    ListNode temp = new ListNode(0);
    temp=top;
    top=top.next;
    System.out.println("Deleted data: "+temp.data);
  }

  void display(){
    if(top==null){
      System.out.println("List is empty");
      return;
    }
    ListNode temp = new ListNode(0);
    temp=top;
    int i=1;
    while (temp!=null&&i<10) {
      System.out.println("Data: "+temp.data);
      i++;
      temp=temp.next;
    }  
  }
  void menu() {
    stackUsingLL sLl = new stackUsingLL();
    Scanner sc=new Scanner(System.in);
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
          data=sc.nextInt();
          sLl.push(data);
          break;
        case 2:
          System.out.println("-------------------------------------");
          sLl.pop();
          break;
        case 3:
          System.out.println("-------------------------------------");
          sLl.display();
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
    stackUsingLL sLl = new stackUsingLL();
    sLl.menu();
  }
}
