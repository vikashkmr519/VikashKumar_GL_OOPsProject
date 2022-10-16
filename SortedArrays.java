import java.util.Scanner;

public class SortedArrays {
    /*
    Given a sorted array of integers “nums” and an integer target, return indices for two numbers such that they add up to the target.  You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.  
Example:  nums = [2,7,11,15], target = 9
Output: [0,1], nums[0] + nums[1] = 9.

nums = [2,4,6], target = 6
Output: [0,1], nums[0] + nums[1] = 6.

nums = [4,4], target = 8
Output: [0,1], nums[0] + nums[1] = 8.

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("size of array");
        int n = sc.nextInt();

        System.out.println("Give the array values");
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Whats the target is?");
        int target = sc.nextInt();

        int[] ans = new int[2];
        for(int i =0;i<n-1;i++){
            for(int j =i+1;j<n;j++){
                if(arr[i]+arr[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }

        if(ans[0]==0 && ans[1]==0){
            System.out.println(-1);
        }else {
            System.out.println("[" + ans[0] + ", " + ans[1] + "]");
        }
    }
}
