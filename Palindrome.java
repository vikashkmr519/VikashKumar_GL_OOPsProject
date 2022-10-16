import java.util.Scanner;

public class Palindrome {
    /*
    Question 1:
Check if a given string is a palindrome and return true or false based on the result, only with the help of recursion. You can not use string buffer or inbuilt string features like reverse etc.

	Test cases:

	1. Sample Input: “AKA”
	    Sample output: True

	2. Sample Input: “JAVA”
                Sample output: False

3. Sample Input: “LEVEL”
                Sample output: True
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(palindrome(str,0,str.length()-1));
    }

    private  static boolean palindrome(String str, int start , int end){
        if(start == end){
            return true;
        }

        if(str.charAt(start)==str.charAt(end)){
            return palindrome(str,start+1,end-1);
        }
            return false;


    }
}
