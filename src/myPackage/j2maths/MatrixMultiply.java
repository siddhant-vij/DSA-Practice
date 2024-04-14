package myPackage.j2Maths;

public class MatrixMultiply {
    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] B = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                B[i][j] = 0;
                for (int k = 0; k < A[i].length; k++) {
                        B[i][j] = B[i][j] + A[i][k] * A[k][j];
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.printf("%d ", B[i][j]);
            }
            System.out.println();
        }
    }
}
