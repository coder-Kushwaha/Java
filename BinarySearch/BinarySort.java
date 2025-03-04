package BinarySearch;
import java.util.*;
public class BinarySort {
    void Bsort(int n,int array[]){
        int i,j,temp;
        for ( i = 0; i < n; i++) {
            for(j=0;j<n-i-1;j++){
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
            
        }  
    }
    void Bsearch(int n,int array[],int se){
        int l=0,u=n, mid;
        while(l<u){
            mid=(u+l)/2;
            if(array[mid]==se){
                System.out.println("Element found at: "+(mid+1));
                return;
            }
            else if(array[mid]<se)
             l=mid+1;
            else 
             u=mid-1;
        }
        System.out.println("Element not found");
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length: ");
        n=sc.nextInt();
        int array[]=new int[n];
        System.out.println("Enter array: ");
        for(int i=0;i<n;i++)
         array[i]=sc.nextInt();
         new BinarySort().Bsort(n, array);
        System.out.println("Sorted Array: ");
        for (int k : array) {
            System.out.println(k);
        } 
        System.out.println("\n\nEnter element to be searched: ");
        int l=sc.nextInt();
        new BinarySort().Bsearch(n, array, l);
        }

    }

