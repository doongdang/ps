import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int[] arr;
        int n = sc.nextInt();

        arr = new int[n];

        ArrayList<Stack<Integer>> sl = new ArrayList<>();
        sl.add(new Stack<>());
        sl.add(new Stack<>());
        sl.add(new Stack<>());
        sl.add(new Stack<>());


        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for (int num : arr) {
            for (int i = 0; i < 4; i++) {
                if (sl.get(i).empty()) {
                    sl.get(i).push(num);
                    n--;
                    break;
                }

                if (sl.get(i).peek() < num) {
                    sl.get(i).push(num);
                    n--;
                    break;
                }
            }
        }
        if (n == 0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
