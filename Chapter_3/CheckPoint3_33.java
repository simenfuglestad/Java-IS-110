import java.util.Scanner;

public class CheckPoint3_33 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        double y = input.nextDouble();
        double z = input.nextDouble();
        
        System.out.println((x < y && y < z) ? "sorted" : "not sorted");
    }
}
