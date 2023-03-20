import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int count5 = five_power_n(n) - five_power_n(n - m) - five_power_n(m);
        int count2 = two_power_n(n) - two_power_n(n - m) - two_power_n(m);

        System.out.println(Math.min(count5, count2));

    }

    static int five_power_n(int num) {
        int count = 0;

        while(num >= 5) {
            count += (num / 5);
            num /= 5;
        }
        return count;
    }

    static int two_power_n(int num) {
        int count = 0;

        while(num >= 2) {
            count += (num / 2);
            num /= 2;
        }
        return count;
    }

}