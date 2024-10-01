public class Matrix {
    private final int row;
    private final int col;
    private final int[][] matrix;

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int get(int i, int j) {
        return matrix[i][j];
    }

    Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.row = matrix.length;
        this.col = matrix[0].length;
    }

    public Matrix mult(Matrix mToMultiply) {
        int row1 = this.getRow();
        int row2 = mToMultiply.getRow();
        int col1 = this.getCol();
        int col2 = mToMultiply.getCol();

        if (col1 != row2) {
            System.out.println("can't multiply these two matrices i guess :/");
            return null;
        }

        int[][] resultMat = new int[row1][col2];
        for (int i = 0; i < this.getRow(); i++) {
            for (int k = 0; k < mToMultiply.getCol(); k++) {
                for (int j = 0; j < this.getCol(); j++) {
                    resultMat[i][k] += this.get(i, j) * mToMultiply.get(j, k);
                }
            }
        }
        return new Matrix(resultMat);
    }

    public long determinant() {
        if (getRow() != getCol())
            throw new RuntimeException("matrix is not a square");
        long det = 0;
        int len = getRow();
        if (getRow() == 2)
            det = (long) get(0, 0) * get(1, 1) - (long) get(0, 1) * get(1, 0);
        else {
            int[][] tmpMat = new int[len - 1][len - 1];
            for (int j = 0; j < len; j++) {
                for (int k = 1; k < len; k++) {
                    int tmpIndex = 0;
                    for (int l = 0; l < len; l++) {
                        if (l == j)
                            continue;
                        tmpMat[k - 1][tmpIndex++] = get(k, l);
                    }
                }
                Matrix tmpMatrix = new Matrix(tmpMat);
                det += (int) Math.pow(-1, j) * get(0, j) * tmpMatrix.determinant();
            }
        }
        return det;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getCol(); j++) {
                str.append(String.format("%d ", get(i, j)));
            }
            str.append("\n");
        }
        return String.valueOf(str);
    }
}
