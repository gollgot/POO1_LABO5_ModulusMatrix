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

        // TODO : Remove les tests ci-dessous qui servent juste d'example pour voir que ca marche comme l'example du prof
        /*
        int modulus = 5;

        Matrix m1 = new Matrix(new int[][] {{1,3,1,1},{3,2,4,2},{1,0,1,0}}, modulus);
        Matrix m2 = new Matrix(new int[][] {{1,4,2,3,2},{0,1,0,4,2},{0,0,2,0,2}}, modulus);

        System.out.println("The modulus is " + modulus + "\n");

        System.out.println("one");
        System.out.println(m1);

        System.out.println("two");
        System.out.println(m2);

        System.out.println("one + two");
        System.out.println(m1.add(m2));

        System.out.println("one - two");
        System.out.println(m1.sub(m2));

        System.out.println("one x two");
        System.out.println(m1.multiply(m2));
        */
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

        System.out.println("The modulus is " + modulus + "\n");

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
