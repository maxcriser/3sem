import java.util.Scanner;

public class DivideConquer {

    public static void main(String argc[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter count of elements:");

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(String.valueOf(gcd(a, b)));
    }

    public static int gcd(int a, int b){
        if(a < b){
            int swap = a;
            a = b;
            b = swap;
        }

        return (a == 0) ? b : (b==0 || a==b) ? a : (a == 1 || b == 1) ? 1 : (a % 2 == 0 && b % 2 == 0) ?
                2 * gcd(a / 2, b / 2) : (a % 2 == 0 && b % 2 != 0) ? gcd (a / 2, b) : (a % 2 != 0 && b % 2 == 0) ?
                gcd(a, b / 2) : gcd((a - b) / 2, b);
//        if(a == 0) return b;
//        if(b == 0) return a;
//        if(a == b) return a;
//        if(a == 1 || b == 1) return 1;
//
//        if(a % 2 == 0 && b % 2 == 0) return 2 * gcd(a / 2, b / 2);
//        if(a % 2 == 0 && b % 2 != 0) return gcd (a / 2, b);
//        if(a % 2 != 0 && b % 2 == 0) return gcd(a, b / 2);

//        if(a < b){
//            int swap = a;
//            a = b;
//            b = swap;
//        }

//        return gcd((a - b) / 2, b);
    }

}
