import java.util.Scanner;

public class PowerOfXoverN {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x  = sc.nextInt();
        int n = sc.nextInt();

        findPowerofxton(x,n);
    }

    private static void findPowerofxton(int x, int n){

        int ans = 1;
        while(n>0){
            if(n%2!=0){
                ans = ans * x;
            }

            x = x*x;
            n = n >> 1;
        }

        System.out.println(ans);
    }

}
