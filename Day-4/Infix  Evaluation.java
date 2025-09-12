import java.util.*;
public class RadixSort {
    public static void main(String args []) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int arr [] =new int [n];
        for(int i=0;i<arr.length;i++) {
            arr[i]=sc.nextInt();
        }
        radixsort(arr);
        print(arr);
    }
    public static void print(int arr []) {
        for(int i =0; i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
    public static void radixsort(int arr []) {
        int max=Integer.MIN_VALUE;
        for(int val:arr) {
            if(val>max) {
                max=val;
            }
            int exp=1;
            while(exp<=max) {
                countsort(arr,exp);
               exp= exp*10;
            }

        }
    }
    public static void countsort(int arr [], int exp)  {
        int ans [] =new int[arr.length];
        int farr []=new int [10];
         for(int i=0;i<arr.length; i++) {
             farr[arr[i]/exp%10]++;
         }
         for(int i=1;i<farr.length;i++) {
             farr[i]+=farr[i-1];
         }
         for(int i=arr.length-1; i>=0;i--) {
             int pos=farr[arr[i]/exp%10];
             int idx=pos-1;
             ans[idx]=arr[i];
             farr[arr[i]/exp%10]--;
         }
        for(int i=0;i<ans.length;i++) {
            arr[i]=ans[i];
        }


    }
}

