import java.util.Scanner;
public class Calculator {
    public int num1, num2;
    public int addition(int n1, int n2){
        return n1+n2;
    }
    public int subtraction(int n1, int n2){
        return n1-n2;
    }
    public int multiplication(int n1, int n2){
        return n1*n2;
    }
    public float division(float n1, float n2){
        return n1/n2;
    }
    public int modulus(int n1, int n2){
        return n1%n2;
    }
    public static void main(String[] args)
    {
        Calculator c = new Calculator();
        Scanner scan = new Scanner(System.in);
        String ch = "";
        do{
            System.out.println("Enter first number: ");
            c.num1 = scan.nextInt();
            System.out.println("Enter second number: ");
            c.num2 = scan.nextInt();
            System.out.println("Which operation would you like the perforn?\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Modulus\nEnter your choice (1-5): ");
        int op = scan.nextInt();
        switch (op)
        {
            case 1:
                int sum = c.addition(c.num1, c.num2);
                System.out.println("Sum is: " + sum);
                break;
            case 2:
                int diff = c.subtraction(c.num1, c.num2);
                System.out.println("Difference is: " + diff);
                break;
            case 3:
                int mul = c.multiplication(c.num1, c.num2);
                System.out.println("Multiplication is: " + mul);
                break;
            case 4:
                float div = c.division(c.num1, c.num2);
                System.out.println("Division is: " + div);
                break;
            case 5:
                int mod = c.modulus(c.num1, c.num2);
                System.out.println("Modulus is: " + mod);
                break;
            default:
                System.out.println("Invalid Choice.");
        }
        System.out.print("Would you like to continue calculating?\nEnter your choice (y/n): \n");
        scan.nextLine();
        ch = scan.nextLine();
    }while(ch.equalsIgnoreCase("y"));
    scan.close();
    }
}