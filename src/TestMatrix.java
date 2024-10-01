public class TestMatrix {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[][] B = {
                {2, 3, 1},
                {4, 1, 2},
                {3, 0, 5},
                {1, 2, 4}
        };

        int[][] C = {
                {18, 3, 45, 2, 7},
                {11, 3, 2, 4, 7},
                {1, 2, 4, 6, 10},
                {2, 3, 4, 6, 8},
                {2, 3, 5, 7, 11}
        };


        Matrix mC = new Matrix(C);
        System.out.println(mC.determinant());
        Matrix mA = new Matrix(A);
        Matrix mB = new Matrix(B);
        Matrix R = mA.mult(mB);
        System.out.println(R);
    }
}
