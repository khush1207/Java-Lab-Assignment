public class Vector {

    private double[] values;

    // Constructor
    public Vector(double[] arr) throws InvalidVectorDimensionException {

        if (arr.length != 2 && arr.length != 3) {
            throw new InvalidVectorDimensionException(
                    "Vector must be 2D or 3D only.");
        }

        this.values = arr.clone();
    }

    // Dimension check
    private void checkDimension(Vector v)
            throws InvalidVectorDimensionException {

        if (this.values.length != v.values.length) {
            throw new InvalidVectorDimensionException(
                    "Vectors must have same dimensions.");
        }
    }

    // Addition
    public Vector add(Vector v)
            throws InvalidVectorDimensionException {

        checkDimension(v);

        double[] result = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            result[i] = this.values[i] + v.values[i];
        }

        return new Vector(result);
    }

    // Subtraction
    public Vector subtract(Vector v)
            throws InvalidVectorDimensionException {

        checkDimension(v);

        double[] result = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            result[i] = this.values[i] - v.values[i];
        }

        return new Vector(result);
    }

    // Dot Product
    public double dotProduct(Vector v)
            throws InvalidVectorDimensionException {

        checkDimension(v);

        double sum = 0;

        for (int i = 0; i < values.length; i++) {
            sum += this.values[i] * v.values[i];
        }

        return sum;
    }

    // Display
    public void display() {
        System.out.print("(");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if (i < values.length - 1)
                System.out.print(", ");
        }
        System.out.println(")");
    }
}