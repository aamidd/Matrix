public class UnProfessionalMatrix {
    public static void main(String[] args) {
        int[][] A = {
                {3, 4},
                {1, 2}
        };
        int[][] B = {
                {2, 0},
                {1, 3}
        };
        int[][] R = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < B[0].length; k++) {
                for (int j = 0; j < A[0].length; j++) {
                    R[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        for (int i = 0; i < R.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < R[0].length; j++) {
                System.out.printf("%02d ", R[i][j]);
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
