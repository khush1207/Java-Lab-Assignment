import java.util.Scanner;

public class VectorMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean valid = false;

        // Try-Catch only for dimension input
        while (!valid) {
            try {
                System.out.print("Enter dimension (2 or 3): ");
                n = sc.nextInt();

                if (n != 2 && n != 3) {
                    throw new InvalidVectorDimensionException(
                            "Dimension must be 2 or 3 only.");
                }

                valid = true; // correct input

            } catch (InvalidVectorDimensionException e) {
                System.out.println(e.getMessage());
            }
        }

        // Now program continues normally
        double[] a = new double[n];
        double[] b = new double[n];

        System.out.println("Enter elements of first vector:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }

        System.out.println("Enter elements of second vector:");
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextDouble();
        }

        try {
            Vector v1 = new Vector(a);
            Vector v2 = new Vector(b);

            Vector sum = v1.add(v2);
            Vector diff = v1.subtract(v2);
            double dot = v1.dotProduct(v2);

            System.out.println("Addition:");
            sum.display();

            System.out.println("Subtraction:");
            diff.display();

            System.out.println("Dot Product: " + dot);

        } catch (InvalidVectorDimensionException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}