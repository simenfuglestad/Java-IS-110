import java.util.Scanner;


public class CheckPoint3_4 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number to be greater than zero");
        int y = input.nextInt();
        
        int x = 0;
        
        if (y > 0) {
            x += 1;
        }
        
        System.out.print(x);
    }
}
        
