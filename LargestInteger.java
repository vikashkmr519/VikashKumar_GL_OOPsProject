import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LargestInteger {

    /*
        Question 5:
        You are given an array of integers. Your task is to create the largest number possible using those integers.
        Input: [11, 2]
        Output: “211”

        Input: [2, 30, 56] Output: “56302”

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         Integer[] arr = new Integer[n];
         for(int i =0;i<n;i++){
             arr[i]= sc.nextInt();
         }

         findLargest(arr,n);
    }

    private static void findLargest(Integer[] arr, int n){
        Arrays.sort(arr, (a,b) -> {
            int ab = a;
            int ba = b;
            ab = Integer.valueOf(""+a+b);
            ba = Integer.valueOf(""+b+a);

            if(ab>ba){
                return -1;
            }else {
                return 1;
            }

        });

        for(int i =0;i<n;i++){
            System.out.print(arr[i]);
        }


    }

}
