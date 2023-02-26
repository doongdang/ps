import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            int a = sc.nextInt();
            a %= 10;
            int b = sc.nextInt();
            if(a == 1 || a == 5 || a == 6){
                System.out.println(a);
            }else if(a == 2){
                if(b % 4 == 1){
                    System.out.println(2);
                }else if(b % 4 == 2){
                    System.out.println(4);
                }else if(b % 4 == 3){
                    System.out.println(8);
                }else{
                    System.out.println(6);
                }
            }else if(a == 3){
                if(b % 4 == 1){
                    System.out.println(3);
                }else if(b % 4 == 2){
                    System.out.println(9);
                }else if(b % 4 == 3){
                    System.out.println(7);
                }else{
                    System.out.println(1);
                }
            }else if(a == 4){
                if(b % 2 == 1){
                    System.out.println(4);
                }else{
                    System.out.println(6);
                }
            }else if(a == 7){
                if(b % 4 == 1){
                    System.out.println(7);
                }else if(b % 4 == 2){
                    System.out.println(9);
                }else if(b % 4 == 3){
                    System.out.println(3);
                }else{
                    System.out.println(1);
                }
            }else if(a == 8){
                if(b % 4 == 1){
                    System.out.println(8);
                }else if(b % 4 == 2){
                    System.out.println(4);
                }else if(b % 4 == 3){
                    System.out.println(2);
                }else{
                    System.out.println(6);
                }
            }else if(a == 9){
                if(b % 2 == 1){
                    System.out.println(9);
                }else{
                    System.out.println(1);
                }
            }else{
                System.out.println(10);
            }
        }
    }
}