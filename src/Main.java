/*
 * Fichier  : Main.java
 * Auteurs  : Dessaules Loïc, Kayoumi Doran
 * But      : Permet de tester le bon fonctionnement de la représentation et des opérations effectuée sur des Matrices
 * Date     : 26.10.2019
 */

import matrix.Matrix;

public class Main {

    public static void main(String[] args) {

        test(3, 4, 3, 5, 5);

        testBreakingPoint();
    }

    /**
     * Test all the breaking points of the Matrix class
     * i.e. when exceptions are lifted
     */
    private static void testBreakingPoint() {
        System.out.println("Testing breaking points");
        try {
            System.out.println("Creating a Matrix with an invalid modulus:");
            // creating a matrix w/ an invalid modulus
            new Matrix(2, 3, -1);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println();
        try {
            System.out.println("Creating a Matrix with invalid dimensions:");
            new Matrix(-2, 3, 3);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println();
        try {
            System.out.println("Creating a Matrix with data not having the same amount of rows and columns:");
            new Matrix(new int[][] {{1,3,1},{3,2,4,2},{1,0,1,0}}, 3);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println();
        try {
            System.out.println("Performing an operation on matrices with different modulus:");
            Matrix m1 = new Matrix(3, 3, 4);
            Matrix m2 = new Matrix(3, 3, 5);

            m1.add(m2);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Create two matrix, execute arithmetic operations (add,sub,multiplication) and display the result.
     *
     * @param n1      The row size of the first matrix
     * @param m1      The column size of the first matrix
     * @param n2      The row size of the second matrix
     * @param m2      The column size of the second matrix
     * @param modulus The modulus
     */
    private static void test(int n1, int m1, int n2, int m2, int modulus) {
        Matrix matrix1 = new Matrix(n1, m1, modulus);
        Matrix matrix2 = new Matrix(n2, m2, modulus);

        System.out.println("The modulus is " + modulus);

        System.out.println("one");
        System.out.println(matrix1);

        System.out.println("two");
        System.out.println(matrix2);

        System.out.println("one + two");
        System.out.println(matrix1.add(matrix2));

        System.out.println("one - two");
        System.out.println(matrix1.sub(matrix2));

        System.out.println("one x two");
        System.out.println(matrix1.multiply(matrix2));
    }

}
